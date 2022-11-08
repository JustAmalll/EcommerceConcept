package dev.amal.ecommerceconcept.domain.repository

import dev.amal.ecommerceconcept.data.remote.dto.ProductsDto
import dev.amal.ecommerceconcept.data.remote.dto.BasketDto
import dev.amal.ecommerceconcept.data.remote.dto.ProductDetailsDto

interface StoreRepository {
    suspend fun getAllProducts(): ProductsDto
    suspend fun getProductDetails(): ProductDetailsDto
    suspend fun getBasket(): BasketDto
}