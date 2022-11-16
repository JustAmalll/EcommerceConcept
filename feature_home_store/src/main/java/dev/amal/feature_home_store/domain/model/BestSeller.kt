package dev.amal.feature_home_store.domain.model

data class BestSeller(
    val id: Int,
    val discountPrice: Int,
    val isFavorites: Boolean,
    val picture: String,
    val priceWithoutDiscount: Int,
    val title: String
)