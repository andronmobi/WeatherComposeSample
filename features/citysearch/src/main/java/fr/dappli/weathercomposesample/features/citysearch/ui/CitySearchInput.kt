package fr.dappli.weathercomposesample.features.citysearch.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.window.PopupProperties

@Composable
fun CitySearchInput(
    city: String,
    onInputChanged: (String) -> Unit,
    suggestions: List<String>,
    onOptionSelected: (String) -> Unit
) {
    val textfieldSize = remember { mutableStateOf(Size.Zero)}

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth().onGloballyPositioned { coordinates ->
            //This value is used to assign to the DropDown the same width
            textfieldSize.value = coordinates.size.toSize()
        },
        value = city,
        onValueChange = { onInputChanged(it) },
        label = { Text("City") }
    )
    DropdownMenu(
        modifier = Modifier
            .width(with(LocalDensity.current){textfieldSize.value.width.toDp()}),
        expanded = suggestions.isNotEmpty(),
        onDismissRequest = {  },
        // This line here will accomplish what you want
        properties = PopupProperties(focusable = false)
    ) {
        suggestions.forEach { label ->
            DropdownMenuItem(
                onClick = {
                onOptionSelected(label)
            }) {
                Text(text = label)
            }
        }
    }
}
