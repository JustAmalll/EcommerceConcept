package dev.amal.feature_basket.data.repository

import dev.amal.feature_basket.data.remote.BasketApi
import dev.amal.feature_basket.data.remote.dto.BasketDto
import dev.amal.feature_basket.domain.repository.BasketRepository
import javax.inject.Inject

class BasketRepositoryImpl @Inject constructor(
    private val api: BasketApi
) : BasketRepository {

    override suspend fun getBasket(): BasketDto = api.getBasket()
}