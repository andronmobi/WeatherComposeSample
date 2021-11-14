package fr.dappli.weathercomposesample.features.citysearch.vm

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.dappli.weathercomposesample.features.citysearch.vo.UiState
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

    val city = mutableStateOf("")
    val uiState = mutableStateOf<UiState>(UiState.Idle)
    val citiesFlow: Flow<List<String>> = userInputFlow
        .debounce(DEBOUNCE_TIME_MS)
        .filter { query ->
            return@filter query.isNotEmpty()
        }
        .mapLatest {
            try {
                getCitiesUseCase(it).also {
                    uiState.value = UiState.Idle
                }
            } catch (ex: Exception) { // we should catch exceptions here, otherwise the coroutine will be stopped.
                uiState.value = UiState.Error
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

    private var k = 0
    fun onTestMe() {
        uiState.value = if (k++ % 2 == 0) UiState.Error else UiState.Idle
    }

    private companion object {
        const val DEBOUNCE_TIME_MS = 300L
    }

}
