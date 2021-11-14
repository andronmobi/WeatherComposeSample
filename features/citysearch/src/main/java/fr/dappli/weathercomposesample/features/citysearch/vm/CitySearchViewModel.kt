package fr.dappli.weathercomposesample.features.citysearch.vm

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.dappli.weathercomposesample.usecases.citysearch.GetCitiesUseCase
import javax.inject.Inject

@HiltViewModel
class CitySearchViewModel @Inject constructor(
    private val getCitiesUseCase: GetCitiesUseCase
): ViewModel() {

    fun onCityInputTextChanged(cityName: String) {
        println("city: $cityName")
    }

}
