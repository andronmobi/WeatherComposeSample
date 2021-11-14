package fr.dappli.weathercomposesample.repo.geogouv

import fr.dappli.weathercomposesample.repo.geogouv.vo.GeoGouvSearchResponse
import javax.inject.Inject

class GeoGouvRepositoryImpl @Inject constructor(
    private val apiService: GeoGouvApiService
) : GeoGouvRepository {

    override suspend fun getCities(cityName: String): GeoGouvSearchResponse {
        // TODO handle exceptions
        return apiService.getCities(cityName)
    }
}
