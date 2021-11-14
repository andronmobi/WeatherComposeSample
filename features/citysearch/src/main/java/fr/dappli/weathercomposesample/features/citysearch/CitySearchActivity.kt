package fr.dappli.weathercomposesample.features.citysearch

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import fr.dappli.weathercomposesample.ui.theme.WeatherComposeSampleTheme

class CitySearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherComposeSampleTheme {
                Scaffold {
                    Text("Android")
                }
            }
        }
    }

}
