package dev.amal.ecommerceconcept.data.repository

import dev.amal.ecommerceconcept.data.remote.StoreApi
import dev.amal.ecommerceconcept.data.remote.dto.AllItems
import dev.amal.ecommerceconcept.data.remote.dto.BasketDto
import dev.amal.ecommerceconcept.data.remote.dto.ItemDetailsDto
import dev.amal.ecommerceconcept.domain.repository.StoreRepository
import javax.inject.Inject

class StoreRepositoryImpl @Inject constructor(
    private val api: StoreApi
) : StoreRepository {

    override suspend fun getAllItems(): AllItems = api.getAllItems()

    override suspend fun getItemDetails(): ItemDetailsDto = api.getItemDetails()

    override suspend fun getBasket(): BasketDto = api.getBasket()
}