package fr.dappli.weathercomposesample.features.citysearch.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CitySearchScaffold(
    city: String,
    suggestions: List<String>,
    onCityNameChange: (String) -> Unit
) {
    val (snackbarVisibleState, setSnackBarState) = remember { mutableStateOf(false) }

    Scaffold(
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 32.dp, end = 16.dp)
            ) {
                CitySearchInput(city, onCityNameChange, suggestions, {})
                if (snackbarVisibleState) {
                    Snackbar(
                        action = {
                            Button(onClick = {}) {
                                Text("MyAction")
                            }
                        },
                        modifier = Modifier.padding(8.dp)
                    ) { Text(text = "This is a snackbar!") }
                }
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
                    Button(onClick = {
                        // TODO
                        setSnackBarState(!snackbarVisibleState)
                    }) {
                        Text("Test me")
                    }
                }
            }
        }
    )
}
