package fr.dappli.weathercomposesample.repo.geogouv

import fr.dappli.weathercomposesample.repo.geogouv.vo.GeoGouvSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GeoGouvApiService {

    @GET("search")
    suspend fun getCities(
        @Query(CITY) cityName: String
    ): GeoGouvSearchResponse

    private companion object {
        const val CITY = "q"
    }
}
