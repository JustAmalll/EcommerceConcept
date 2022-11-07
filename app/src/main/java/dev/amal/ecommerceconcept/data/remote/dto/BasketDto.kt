package dev.amal.ecommerceconcept.data.remote.dto

import dev.amal.ecommerceconcept.domain.model.Basket

data class BasketDto(
    val basket: List<BasketInfo>,
    val delivery: String,
    val id: String,
    val total: Int
)

fun BasketDto.toBasket(): Basket = Basket(
    basket = basket,
    delivery = delivery,
    id = id,
    total = total
)