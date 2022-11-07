package dev.amal.ecommerceconcept.fragments.home_store_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.amal.ecommerceconcept.common.Resource
import dev.amal.ecommerceconcept.domain.use_cases.GetBestSellersUseCase
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HomeStoreViewModel @Inject constructor(
    private val getBestSellersUseCase: GetBestSellersUseCase
) : ViewModel() {

    private val _stateFlow = MutableStateFlow(AllItemsState())
    val stateFlow = _stateFlow.asStateFlow()

    init {
        getAllItems()
    }

    private fun getAllItems() {
        getBestSellersUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _stateFlow.value = AllItemsState(allItems = result.data)
                }
                is Resource.Error -> {
                    _stateFlow.value = AllItemsState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _stateFlow.value = AllItemsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}