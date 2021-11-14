package fr.dappli.weathercomposesample.libraries.navigation

import android.content.Context
import android.content.Intent
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class CitySearchNavigator @Inject constructor(
    @ActivityContext
    private val context: Context
) {

    fun newIntent(): Intent {
        return Intent().apply {
            setClassName(context.packageName, CITY_SEARCH_ACTIVITY_CLASS_NAME)
        }
    }


    companion object {
        const val CITY_SEARCH_ACTIVITY_CLASS_NAME =
            "fr.dappli.weathercomposesample.features.citysearch.CitySearchActivity"
    }
}
