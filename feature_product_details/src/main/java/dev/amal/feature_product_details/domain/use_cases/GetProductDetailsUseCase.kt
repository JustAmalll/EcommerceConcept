package dev.amal.feature_product_details.domain.use_cases

import dev.amal.core.utils.Resource
import dev.amal.feature_product_details.data.remote.dto.toProductDetails
import dev.amal.feature_product_details.domain.model.ProductDetails
import dev.amal.feature_product_details.domain.repository.ProductDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetProductDetailsUseCase @Inject constructor(
    private val repository: ProductDetailsRepository
) {
    operator fun invoke(): Flow<Resource<ProductDetails>> = flow {
        try {
            emit(Resource.Loading())
            val item = repository.getProductDetails().toProductDetails()
            emit(Resource.Success(item))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}