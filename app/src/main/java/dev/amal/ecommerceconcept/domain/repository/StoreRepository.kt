package dev.amal.ecommerceconcept.domain.repository

import dev.amal.ecommerceconcept.data.remote.dto.AllItems
import dev.amal.ecommerceconcept.data.remote.dto.BasketDto
import dev.amal.ecommerceconcept.data.remote.dto.ItemDetailsDto

interface StoreRepository {
    suspend fun getAllItems(): AllItems
    suspend fun getItemDetails(): ItemDetailsDto
    suspend fun getBasket(): BasketDto
}