package dev.amal.ecommerceconcept.data.remote.dto

import dev.amal.ecommerceconcept.domain.model.BasketInfo

data class BasketInfoDto(
    val id: Int,
    val images: String,
    val price: Int,
    val title: String
)

fun BasketInfoDto.toBasketInfo(): BasketInfo = BasketInfo(
    id = id,
    images = images,
    price = price,
    title = title
)

