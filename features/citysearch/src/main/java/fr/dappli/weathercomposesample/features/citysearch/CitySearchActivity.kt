package fr.dappli.weathercomposesample.features.citysearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import dagger.hilt.android.AndroidEntryPoint
import fr.dappli.weathercomposesample.features.citysearch.vm.CitySearchViewModel
import fr.dappli.weathercomposesample.libraries.design.theme.WeatherComposeSampleTheme

@AndroidEntryPoint
class CitySearchActivity : ComponentActivity() {

    private val viewModel: CitySearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherComposeSampleTheme {
                Scaffold {
                    Button(onClick = {
                        viewModel.onCityInputTextChanged("paris")
                    }) {
                        Text("Test me")
                    }
                }
            }
        }
    }

}
