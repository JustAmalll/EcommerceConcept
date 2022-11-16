package dev.amal.feature_product_details.data.remote

import dev.amal.feature_product_details.data.remote.dto.ProductDetailsDto
import retrofit2.http.GET

interface ProductDetailsApi {

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getProductDetails(): ProductDetailsDto

}