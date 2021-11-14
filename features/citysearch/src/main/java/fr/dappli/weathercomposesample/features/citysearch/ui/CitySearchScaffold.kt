package fr.dappli.weathercomposesample.features.citysearch.ui

import androidx.appcompat.widget.SearchView
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import fr.dappli.weathercomposesample.features.citysearch.R

@Composable
fun CitySearchScaffold(
    city: String,
    onCityNameChange: (String) -> Unit
) {
    Scaffold(
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 32.dp, end = 16.dp)
            ) {
                CitySearchInput(city, onCityNameChange)
                Spacer(modifier = Modifier.height(16.dp))
                AndroidView(
                    modifier = Modifier.fillMaxWidth(),
                    factory = { context ->
                        // TODO apply dark theme
                        SearchView(context).apply {
                            println("andrei redraw SearchView")
                            setBackgroundResource(R.drawable.search_background)
                            isIconified = false
                            clearFocus()
                            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                                override fun onQueryTextSubmit(query: String?) = true

                                override fun onQueryTextChange(newText: String?): Boolean {
                                    newText?.let { text -> onCityNameChange(text) }
                                    return true
                                }
                            })
                        }
                    },
                    update = { searchView ->
                        // TODO update adapter
                    }
                )

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
                    }) {
                        Text("Test me")
                    }
                }
            }
        }
    )
}
