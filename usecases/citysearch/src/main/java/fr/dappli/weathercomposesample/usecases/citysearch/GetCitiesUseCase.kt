package fr.dappli.weathercomposesample.usecases.citysearch

import fr.dappli.weathercomposesample.repo.geogouv.GeoGouvRepository
import fr.dappli.weathercomposesample.usecases.citysearch.vo.City
import javax.inject.Inject

class GetCitiesUseCase @Inject constructor(
    private val repository: GeoGouvRepository
) {

    suspend operator fun invoke(cityName: String): List<City> =
        repository.getCities(cityName).let { response ->
            val cities = mutableListOf<City>()
            response.features?.forEach { feature ->
                val properties = feature.properties ?: throw ProtocolException.EmptyProperties
                cities.add(
                    City(
                        properties.label ?: throw ProtocolException.EmptyLabel,
                        properties.name ?: throw ProtocolException.EmptyName,
                        properties.city ?: throw ProtocolException.EmptyCity
                    )
                )
            } ?: throw ProtocolException.EmptyFeatures
            cities
        }


    sealed class ProtocolException(message: String = "") : Exception(message) {
        object EmptyFeatures : ProtocolException()
        object EmptyProperties : ProtocolException()
        object EmptyName : ProtocolException()
        object EmptyCity : ProtocolException()
        object EmptyLabel : ProtocolException()
    }
}
