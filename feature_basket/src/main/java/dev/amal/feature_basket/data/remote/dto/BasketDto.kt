package dev.amal.feature_basket.data.remote.dto

import dev.amal.feature_basket.domain.model.Basket

data class BasketDto(
    val basket: List<BasketInfoDto>,
    val delivery: String,
    val id: String,
    val total: Int
)

fun BasketDto.toBasket(): Basket = Basket(
    basket = basket.map { it.toBasketInfo() },
    delivery = delivery,
    id = id,
    total = total
)