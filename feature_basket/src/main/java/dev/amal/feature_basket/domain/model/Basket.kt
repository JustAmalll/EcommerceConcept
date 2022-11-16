package dev.amal.feature_basket.domain.model

data class Basket(
    val id: String,
    val basket: List<BasketInfo>,
    val delivery: String,
    val total: Int
)