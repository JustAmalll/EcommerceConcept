package dev.amal.feature_basket.domain.repository

import dev.amal.feature_basket.data.remote.dto.BasketDto

interface BasketRepository {
    suspend fun getBasket(): BasketDto
}