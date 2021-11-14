package fr.dappli.weathercomposesample.features.citysearch.vm

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

    fun onCityInputTextChanged(cityName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = getCitiesUseCase.invoke(cityName)
                println("andrei $result")
            } catch (e: Exception) {

            }
        }
    }

}
