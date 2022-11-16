package dev.amal.feature_product_details.data.repository

import dev.amal.feature_product_details.data.remote.ProductDetailsApi
import dev.amal.feature_product_details.data.remote.dto.ProductDetailsDto
import dev.amal.feature_product_details.domain.repository.ProductDetailsRepository
import javax.inject.Inject

class ProductDetailsRepositoryImpl @Inject constructor(
    private val api: ProductDetailsApi
) : ProductDetailsRepository {

    override suspend fun getProductDetails(): ProductDetailsDto = api.getProductDetails()
}