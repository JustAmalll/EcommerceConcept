package dev.amal.ecommerceconcept.data.remote.dto

import dev.amal.ecommerceconcept.domain.model.HomeStore

data class HomeStoreDto(
    val id: Int,
    val is_buy: Boolean,
    val is_new: Boolean,
    val picture: String,
    val subtitle: String,
    val title: String
)

fun HomeStoreDto.toHomeStore(): HomeStore = HomeStore(
    id = id,
    isBuy = is_buy,
    isNew = is_new,
    picture = picture,
    subtitle = subtitle,
    title = title
)