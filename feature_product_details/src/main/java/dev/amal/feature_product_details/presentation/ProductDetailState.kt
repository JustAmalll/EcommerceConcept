package dev.amal.feature_product_details.presentation

import dev.amal.feature_product_details.domain.model.ProductDetails

data class ProductDetailState(
    val isLoading: Boolean = false,
    val item: ProductDetails? = null,
    val error: String = ""
)