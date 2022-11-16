package dev.amal.feature_basket.presentation

import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.amal.core.utils.BaseFragment
import dev.amal.core.utils.showProgressBarWhenLoading
import dev.amal.feature_basket.adapters.BasketRecyclerViewAdapter
import dev.amal.feature_basket.databinding.FragmentBasketBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BasketFragment : BaseFragment<FragmentBasketBinding>(
    FragmentBasketBinding::inflate
) {

    private val viewModel by viewModels<BasketViewModel>()

    @SuppressLint("SetTextI18n")
    override fun onCreateView() {
        lifecycleScope.launch {
            viewModel.stateFlow.collectLatest {
                binding.basketProgressBar.showProgressBarWhenLoading(it.isLoading)

                it.basket?.let { basket ->
                    binding.basketRecyclerView.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        adapter = BasketRecyclerViewAdapter(
                            basket = basket.basket, context = requireContext()
                        )
                    }

                    binding.priceTextView.text = "$${basket.total} us"
                    binding.deliveryTextView.text = basket.delivery
                }
            }
        }
    }

    override fun setupClickListener() = with(binding) {
        backCardView.setOnClickListener { findNavController().popBackStack() }
    }
}