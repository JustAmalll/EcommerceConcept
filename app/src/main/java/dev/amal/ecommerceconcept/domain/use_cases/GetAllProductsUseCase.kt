package dev.amal.ecommerceconcept.domain.use_cases

import dev.amal.ecommerceconcept.common.Resource
import dev.amal.ecommerceconcept.data.remote.dto.toAllProductItems
import dev.amal.ecommerceconcept.domain.model.AllProducts
import dev.amal.ecommerceconcept.domain.repository.StoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(
    private val repository: StoreRepository
) {
    operator fun invoke(): Flow<Resource<AllProducts>> = flow {
        try {
            emit(Resource.Loading())
            val items = repository.getAllProducts().toAllProductItems()
            emit(Resource.Success(items))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}