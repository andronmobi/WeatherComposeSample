package fr.dappli.weathercomposesample.features.citysearch

import fr.dappli.weathercomposesample.libraries.navigation.CitySearchNavigator
import org.junit.Assert
import org.junit.Test

class CitySearchNavigatorTest {

    @Test
    fun `verify CitySearchActivity package name`() {
        Assert.assertEquals(
            CitySearchActivity::class.qualifiedName,
            CitySearchNavigator.CITY_SEARCH_ACTIVITY_CLASS_NAME
        )
    }
}
