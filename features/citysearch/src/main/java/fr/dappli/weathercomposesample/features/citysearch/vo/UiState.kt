package fr.dappli.weathercomposesample.features.citysearch.vo

sealed class UiState {
    object Idle: UiState()
    object Error: UiState()
}
