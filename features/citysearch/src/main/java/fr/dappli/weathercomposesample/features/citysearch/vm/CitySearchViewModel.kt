package fr.dappli.weathercomposesample.features.citysearch.vm

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.dappli.weathercomposesample.usecases.citysearch.GetCitiesUseCase
import fr.dappli.weathercomposesample.usecases.citysearch.vo.City
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class CitySearchViewModel @Inject constructor(
    private val getCitiesUseCase: GetCitiesUseCase
): ViewModel() {

    private val userInputFlow = MutableStateFlow("")
    private var citiesList = emptyList<City>()
    private val _events = MutableSharedFlow<Event>()

    val city = mutableStateOf("")
    val events: SharedFlow<Event> = _events
    val citiesFlow: Flow<List<String>> = userInputFlow
        .debounce(DEBOUNCE_TIME_MS)
        .filter { query ->
            return@filter query.isNotEmpty()
        }
        .mapLatest {
            try {
                getCitiesUseCase(it)
            } catch (ex: Exception) { // we should catch exceptions here, otherwise the coroutine will be stopped.
                _events.emit(Event.Error(ex.message))
                emptyList()
            }
        }.flowOn(Dispatchers.IO)
        .map {
            citiesList = it
            it.map { city -> city.zipName }
        }.flowOn(Dispatchers.Main)

    fun onCityInputChanged(cityName: String) {
        println("vm onCityInputChanged: $cityName")
        city.value = cityName
        userInputFlow.value = cityName
    }

    sealed class Event {
        class CitySelected(val cityName: String) : Event()
        class NextButtonClicked(val cityName: String) : Event()
        class Error(val errorName: String?) : Event()
    }

    private companion object {
        const val DEBOUNCE_TIME_MS = 300L
    }

}
