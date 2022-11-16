package dev.amal.feature_product_details.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.amal.core.utils.Resource
import dev.amal.feature_product_details.domain.use_cases.GetProductDetailsUseCase
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val getProductDetailsUseCase: GetProductDetailsUseCase
) : ViewModel() {

    private val _stateFlow = MutableStateFlow(ProductDetailState())
    val stateFlow = _stateFlow.asStateFlow()

    init {
        getProductDetails()
    }

    private fun getProductDetails() {
        getProductDetailsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _stateFlow.value = ProductDetailState(item = result.data)
                }
                is Resource.Error -> {
                    _stateFlow.value = ProductDetailState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _stateFlow.value = ProductDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}