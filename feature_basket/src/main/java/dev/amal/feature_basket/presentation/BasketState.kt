package dev.amal.feature_basket.presentation

import dev.amal.feature_basket.domain.model.Basket

data class BasketState(
    val isLoading: Boolean = false,
    val basket: Basket? = null,
    val error: String = ""
)