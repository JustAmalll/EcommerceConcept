package dev.amal.ecommerceconcept.fragments.home_store_fragment

import dev.amal.ecommerceconcept.domain.model.AllProducts

data class AllProductsState(
    val isLoading: Boolean = false,
    val allProducts: AllProducts? = null,
    val error: String = ""
)