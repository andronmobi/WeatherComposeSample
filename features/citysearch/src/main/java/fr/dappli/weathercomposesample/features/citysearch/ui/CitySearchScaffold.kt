package fr.dappli.weathercomposesample.features.citysearch.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.dappli.weathercomposesample.features.citysearch.vo.UiState

@Composable
fun CitySearchScaffold(
    uiState: UiState,
    city: String,
    suggestions: List<String>,
    onCityNameChange: (String) -> Unit,
    onButtonClick: () -> Unit
) {
    Scaffold(
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 32.dp, end = 16.dp)
            ) {
                if (uiState is UiState.Error) {
                    Snackbar(
                        action = {
                            Button(onClick = {}) {
                                Text("MyAction")
                            }
                        },
                        modifier = Modifier.padding(8.dp)
                    ) { Text(text = "An error is appeared!") }
                }
                CitySearchInput(city, onCityNameChange, suggestions, {})
            }
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = MaterialTheme.colors.background,
                elevation = 0.dp
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = onButtonClick) {
                        Text("Test me")
                    }
                }
            }
        }
    )
}
