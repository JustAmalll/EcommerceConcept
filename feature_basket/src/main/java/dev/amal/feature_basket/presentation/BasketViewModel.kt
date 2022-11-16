package dev.amal.feature_basket.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.amal.core.utils.Resource
import dev.amal.feature_basket.domain.use_cases.GetBasketUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor(
    private val getBasketUseCase: GetBasketUseCase
) : ViewModel() {

    private val _stateFlow = MutableStateFlow(BasketState())
    val stateFlow = _stateFlow.asStateFlow()

    init {
        getBasket()
    }

    private fun getBasket() {
        getBasketUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    println(result.data)
                    _stateFlow.value = BasketState(basket = result.data)
                }
                is Resource.Error -> {
                    _stateFlow.value = BasketState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _stateFlow.value = BasketState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}