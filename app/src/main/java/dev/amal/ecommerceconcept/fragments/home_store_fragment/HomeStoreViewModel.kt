package dev.amal.ecommerceconcept.fragments.home_store_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.amal.ecommerceconcept.common.Resource
import dev.amal.ecommerceconcept.domain.use_cases.GetAllProductsUseCase
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HomeStoreViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase
) : ViewModel() {

    private val _stateFlow = MutableStateFlow(AllProductsState())
    val stateFlow = _stateFlow.asStateFlow()

    init {
        getAllItems()
    }

    private fun getAllItems() {
        getAllProductsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _stateFlow.value = AllProductsState(allProducts = result.data)
                }
                is Resource.Error -> {
                    _stateFlow.value = AllProductsState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _stateFlow.value = AllProductsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}