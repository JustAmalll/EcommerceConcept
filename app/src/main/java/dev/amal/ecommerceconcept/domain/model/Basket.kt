package dev.amal.ecommerceconcept.domain.model

data class Basket(
    val id: String,
    val basket: List<BasketInfo>,
    val delivery: String,
    val total: Int
)