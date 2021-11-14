package fr.dappli.weathercomposesample.features.citysearch.vm

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

    fun onCityInputChanged(cityName: String) {
        println("vm onCityInputChanged: $cityName")
        city.value = cityName
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = getCitiesUseCase.invoke(cityName)
                println("vm search result: $result")
            } catch (e: Exception) {
                // TODO
            }
        }
    }

}
