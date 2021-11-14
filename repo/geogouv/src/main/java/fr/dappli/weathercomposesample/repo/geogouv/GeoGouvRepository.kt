package fr.dappli.weathercomposesample.repo.geogouv

import fr.dappli.weathercomposesample.repo.geogouv.vo.GeoGouvSearchResponse

interface GeoGouvRepository {

    suspend fun getCities(cityName: String): GeoGouvSearchResponse
}
