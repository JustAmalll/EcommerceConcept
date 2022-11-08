package dev.amal.ecommerceconcept.fragments.details_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.amal.ecommerceconcept.common.Resource
import dev.amal.ecommerceconcept.domain.use_cases.GetProductDetailsUseCase
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val getProductDetailsUseCase: GetProductDetailsUseCase
): ViewModel() {

    private val _stateFlow = MutableStateFlow(ItemDetailState())
    val stateFlow = _stateFlow.asStateFlow()

    init {
        getItemDetails()
    }

    private fun getItemDetails() {
        getProductDetailsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _stateFlow.value = ItemDetailState(item = result.data)
                }
                is Resource.Error -> {
                    _stateFlow.value = ItemDetailState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _stateFlow.value = ItemDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}