package fr.dappli.weathercomposesample.repo.geogouv.vo

import com.google.gson.annotations.SerializedName

data class GeoGouvSearchResponse(
    @SerializedName("type") val type: String?,
    @SerializedName("version") val version: String?,
    @SerializedName("features") val features: List<Feature>?
) {

    data class Feature(
        @SerializedName("properties") val properties: CityProperties?
    ) {

        data class CityProperties(
            @SerializedName("label") val label: String?,
            @SerializedName("name") val name: String?,
            @SerializedName("city") val city: String?,
            @SerializedName("postcode") val postcode: String?
        )
    }
}
