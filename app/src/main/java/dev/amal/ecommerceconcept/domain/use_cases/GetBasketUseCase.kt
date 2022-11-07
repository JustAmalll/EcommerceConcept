package dev.amal.ecommerceconcept.domain.use_cases

import dev.amal.ecommerceconcept.common.Resource
import dev.amal.ecommerceconcept.data.remote.dto.toBasket
import dev.amal.ecommerceconcept.domain.model.Basket
import dev.amal.ecommerceconcept.domain.repository.StoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBasketUseCase @Inject constructor(
    private val repository: StoreRepository
) {
    operator fun invoke(): Flow<Resource<Basket>> = flow {
        try {
            emit(Resource.Loading())
            val basket = repository.getBasket().toBasket()
            emit(Resource.Success(basket))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}