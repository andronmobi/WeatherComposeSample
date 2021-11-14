package fr.dappli.weathercomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import fr.dappli.weathercomposesample.libraries.navigation.CitySearchNavigator
import fr.dappli.weathercomposesample.ui.theme.WeatherComposeSampleTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var citySearchNavigator: CitySearchNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherComposeSampleTheme {
                Scaffold {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ) {
                        Greeting("Android")
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            onClick = ::onSearchClicked
                        ) {
                            Text("Search")
                        }
                    }
                }
            }
        }
    }

    private fun onSearchClicked() {
        startActivity(citySearchNavigator.newIntent())
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherComposeSampleTheme {
        Scaffold {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Greeting("Android")
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = {}
                ) {
                    Text("Search")
                }
            }
        }
    }
}
