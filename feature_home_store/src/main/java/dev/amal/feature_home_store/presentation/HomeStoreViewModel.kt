package dev.amal.feature_home_store.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.amal.core.utils.Resource
import dev.amal.feature_home_store.domain.use_cases.GetAllProductsUseCase
import dev.amal.feature_home_store.domain.use_cases.GetBasketSizeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeStoreViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val getBasketSizeUseCase: GetBasketSizeUseCase
) : ViewModel() {

    private val _stateFlow = MutableStateFlow(AllProductsState())
    val stateFlow = _stateFlow.asStateFlow()

    private val _basketSizeStateFlow = MutableStateFlow(BasketSizeState())
    val basketSizeStateFlow = _basketSizeStateFlow.asStateFlow()

    init {
        getAllProducts()
        getBasketSize()
    }

    private fun getAllProducts() {
        getAllProductsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _stateFlow.value = AllProductsState(allProducts = result.data)
                }
                is Resource.Error -> {
                    _stateFlow.value = AllProductsState(
                        error = result.message
                            ?: "An unexpected error occurred while getting all products"
                    )
                }
                is Resource.Loading -> {
                    _stateFlow.value = AllProductsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getBasketSize() {
        getBasketSizeUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _basketSizeStateFlow.value = BasketSizeState(basketSize = result.data ?: 0)
                }
                is Resource.Error -> {
                    _basketSizeStateFlow.value = BasketSizeState(
                        error = result.message
                            ?: "An unexpected error occurred while loading basket size"
                    )
                }
                is Resource.Loading -> {
                    _basketSizeStateFlow.value = BasketSizeState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}