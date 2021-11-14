package fr.dappli.weathercomposesample.features.citysearch

import app.cash.turbine.test
import fr.dappli.weathercomposesample.features.citysearch.vm.CitySearchViewModel
import fr.dappli.weathercomposesample.usecases.citysearch.GetCitiesUseCase
import fr.dappli.weathercomposesample.usecases.citysearch.vo.City
import io.mockk.*
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CitySearchViewModelTest {

    private val useCase = mockk<GetCitiesUseCase>()
    private val viewModel = CitySearchViewModel(useCase)

    @Before
    fun setUp() = MockKAnnotations.init(this, relaxUnitFun = true)

    @Test
    fun `verify me`() = runBlockingTest {
        val cityName = slot<String>()
        coEvery { useCase(capture(cityName)) } returns listOf(City("zipName", "districtName", "Paris"))

        // when
        viewModel.citiesFlow.test {
            viewModel.onCityInputChanged("Paris")
            Assert.assertEquals(listOf("zipName"), awaitItem())

            Assert.assertEquals(cityName.captured, "Paris")
            coVerify(exactly = 1) { useCase.invoke("Paris") }
        }
    }
}
