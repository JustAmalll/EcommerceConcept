package dev.amal.ecommerceconcept.fragments.basket_fragment

import dev.amal.ecommerceconcept.domain.model.Basket

data class BasketState(
    val isLoading: Boolean = false,
    val basket: Basket? = null,
    val error: String = ""
)