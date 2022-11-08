package dev.amal.ecommerceconcept.data.repository

import dev.amal.ecommerceconcept.data.remote.StoreApi
import dev.amal.ecommerceconcept.data.remote.dto.ProductsDto
import dev.amal.ecommerceconcept.data.remote.dto.BasketDto
import dev.amal.ecommerceconcept.data.remote.dto.ProductDetailsDto
import dev.amal.ecommerceconcept.domain.repository.StoreRepository
import javax.inject.Inject

class StoreRepositoryImpl @Inject constructor(
    private val api: StoreApi
) : StoreRepository {

    override suspend fun getAllProducts(): ProductsDto = api.getAllProducts()

    override suspend fun getProductDetails(): ProductDetailsDto = api.getProductDetails()

    override suspend fun getBasket(): BasketDto = api.getBasket()
}