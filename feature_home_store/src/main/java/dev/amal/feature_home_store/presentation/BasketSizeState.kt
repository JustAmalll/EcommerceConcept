package dev.amal.feature_home_store.presentation

data class BasketSizeState(
    val isLoading: Boolean = false,
    val basketSize: Int = 0,
    val error: String = ""
)