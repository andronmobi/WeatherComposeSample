package fr.dappli.weathercomposesample.features.citysearch.vm

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.dappli.weathercomposesample.usecases.citysearch.GetCitiesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class CitySearchViewModel @Inject constructor(
    private val getCitiesUseCase: GetCitiesUseCase
): ViewModel() {

    val city = mutableStateOf("")
    val suggestions = mutableStateListOf<String>()

    fun onCityInputChanged(cityName: String) {
        println("vm onCityInputChanged: $cityName")
        city.value = cityName
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = getCitiesUseCase.invoke(cityName)
                println("vm search result: $result")
                val s = result.map { it.zipName }.take(5)
                suggestions.clear()
                suggestions.addAll(s)
            } catch (e: Exception) {
                // TODO
            }
        }
    }

}
