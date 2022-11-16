package dev.amal.feature_home_store.data.repository

import dev.amal.feature_home_store.data.remote.AllProductsApi
import dev.amal.feature_home_store.data.remote.dto.AllProductsDto
import dev.amal.feature_home_store.data.remote.dto.BasketDto
import dev.amal.feature_home_store.domain.repository.AllProductsRepository
import javax.inject.Inject

class AllProductsRepositoryImpl @Inject constructor(
    private val api: AllProductsApi
) : AllProductsRepository {

    override suspend fun getAllProducts(): AllProductsDto = api.getAllProducts()
    override suspend fun getBasket(): BasketDto  = api.getBasket()
}