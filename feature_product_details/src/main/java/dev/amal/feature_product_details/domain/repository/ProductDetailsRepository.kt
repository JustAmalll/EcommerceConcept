package dev.amal.feature_product_details.domain.repository

import dev.amal.feature_product_details.data.remote.dto.ProductDetailsDto

interface ProductDetailsRepository {
    suspend fun getProductDetails(): ProductDetailsDto
}