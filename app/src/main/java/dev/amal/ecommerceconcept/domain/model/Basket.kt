package dev.amal.ecommerceconcept.domain.model

import dev.amal.ecommerceconcept.data.remote.dto.BasketInfo

data class Basket(
    val basket: List<BasketInfo>,
    val delivery: String,
    val id: String,
    val total: Int
)