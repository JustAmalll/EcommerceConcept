package dev.amal.feature_home_store.domain.repository

import dev.amal.feature_home_store.data.remote.dto.AllProductsDto
import dev.amal.feature_home_store.data.remote.dto.BasketDto

interface AllProductsRepository {
    suspend fun getAllProducts(): AllProductsDto
    suspend fun getBasket(): BasketDto
}