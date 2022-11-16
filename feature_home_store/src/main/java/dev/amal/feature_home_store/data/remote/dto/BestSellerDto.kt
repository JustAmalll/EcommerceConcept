package dev.amal.feature_home_store.data.remote.dto

import dev.amal.feature_home_store.domain.model.BestSeller

data class BestSellerDto(
    val discount_price: Int,
    val id: Int,
    val is_favorites: Boolean,
    val picture: String,
    val price_without_discount: Int,
    val title: String
)

fun BestSellerDto.toBestSeller(): BestSeller = BestSeller(
    id = id,
    discountPrice = discount_price,
    isFavorites = is_favorites,
    picture = picture,
    priceWithoutDiscount = price_without_discount,
    title = title
)