package dev.amal.feature_home_store.domain.use_cases

import dev.amal.core.utils.Resource
import dev.amal.feature_home_store.domain.repository.AllProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBasketSizeUseCase @Inject constructor(
    private val repository: AllProductsRepository
) {
    operator fun invoke(): Flow<Resource<Int>> = flow {
        try {
            emit(Resource.Loading())
            val basket = repository.getBasket().basket.size
            emit(Resource.Success(basket))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}