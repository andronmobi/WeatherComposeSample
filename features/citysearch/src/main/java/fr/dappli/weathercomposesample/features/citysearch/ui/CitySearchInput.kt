package fr.dappli.weathercomposesample.features.citysearch.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CitySearchInput(
    city: String,
    onInputChanged: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = city,
        onValueChange = { onInputChanged(it) },
        label = { Text("City") }
    )
}
