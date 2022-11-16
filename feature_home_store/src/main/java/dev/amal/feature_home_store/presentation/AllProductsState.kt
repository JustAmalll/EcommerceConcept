package dev.amal.feature_home_store.presentation

import dev.amal.feature_home_store.domain.model.AllProducts

data class AllProductsState(
    val isLoading: Boolean = false,
    val allProducts: AllProducts? = null,
    val error: String = ""
)