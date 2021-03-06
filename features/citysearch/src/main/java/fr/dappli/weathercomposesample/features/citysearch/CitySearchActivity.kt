package fr.dappli.weathercomposesample.features.citysearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import fr.dappli.weathercomposesample.features.citysearch.ui.CitySearchScaffold
import fr.dappli.weathercomposesample.features.citysearch.vm.CitySearchViewModel
import fr.dappli.weathercomposesample.features.citysearch.vo.UiState
import fr.dappli.weathercomposesample.libraries.design.theme.WeatherComposeSampleTheme

@AndroidEntryPoint
class CitySearchActivity : ComponentActivity() {

    private val viewModel: CitySearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherComposeSampleTheme {

                val suggestions = viewModel.citiesFlow.collectAsState(initial = emptyList())
                CitySearchScaffold(
                    viewModel.uiState.value,
                    viewModel.city.value,
                    suggestions.value,
                    ::onCityInputChanged
                ) {
                    viewModel.onTestMe()
                }
            }
        }
    }

    private fun onCityInputChanged(cityName: String) {
        viewModel.onCityInputChanged(cityName)
    }
}

@Preview
@Composable
fun CitySearchPreview() {
    WeatherComposeSampleTheme {
        CitySearchScaffold(UiState.Idle, "Paris", emptyList(), {}, {})
    }
}
