package dev.amal.ecommerceconcept.fragments.home_store_fragment

import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import dev.amal.ecommerceconcept.R
import dev.amal.ecommerceconcept.adapters.BestSellerAdapter
import dev.amal.ecommerceconcept.adapters.HotSalesViewPagerAdapter
import dev.amal.ecommerceconcept.common.BaseFragment
import dev.amal.ecommerceconcept.common.setLightSystemBars
import dev.amal.ecommerceconcept.common.showProgressBarWhenLoading
import dev.amal.ecommerceconcept.common.toggleTextColor
import dev.amal.ecommerceconcept.databinding.FragmentHomeStoreBinding
import dev.amal.ecommerceconcept.fragments.basket_fragment.BasketViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeStoreFragment : BaseFragment<FragmentHomeStoreBinding>(
    FragmentHomeStoreBinding::inflate
) {

    private lateinit var dialog: BottomSheetDialog
    private val homeStoreViewModel by viewModels<HomeStoreViewModel>()
    private val basketViewModel by viewModels<BasketViewModel>()

    override fun onCreateView() {
        activity?.window?.setLightSystemBars(requireContext())

        lifecycleScope.launch {
            homeStoreViewModel.stateFlow.collectLatest {
                binding.hotSalesProgressBar.showProgressBarWhenLoading(it.isLoading)
                binding.bestSellerProgressBar.showProgressBarWhenLoading(it.isLoading)

                it.allProducts?.let { allItems ->
                    val hotSalesViewPagerAdapter = HotSalesViewPagerAdapter(
                        hotSales = allItems.homeStore,
                        context = requireContext()
                    )
                    binding.hotSalesViewPager.adapter = hotSalesViewPagerAdapter

                    binding.bestSellerRecyclerView.apply {
                        layoutManager = GridLayoutManager(requireContext(), 2)
                        adapter = BestSellerAdapter(
                            allItems.bestSeller, requireContext(), findNavController()
                        )
                    }
                }
            }
        }
        lifecycleScope.launch {
            basketViewModel.stateFlow.collectLatest { basketState ->

                if (basketState.isLoading)
                    binding.cardItemCountCardView.visibility = View.INVISIBLE
                else binding.cardItemCountCardView.visibility = View.VISIBLE

                basketState.basket?.basket?.let { basket ->
                    if (basket.isNotEmpty()) {
                        binding.cardItemCountCardView.visibility = View.VISIBLE
                        binding.cartItemCountTextView.text = basket.size.toString()
                    } else binding.cardItemCountCardView.visibility = View.INVISIBLE
                }
            }
        }
    }

    override fun setupClickListener() = with(binding) {
        filterIcon.setOnClickListener { showFilterBottomSheet() }
        cardView.setOnClickListener {}
        bagIcon.setOnClickListener {
            findNavController().navigate(R.id.action_homeStoreFragment_to_basketFragment)
        }
        toggleButtonGroup.selectButton(R.id.phoneButton)
        toggleButtonGroup.setOnSelectListener { button ->
            when (button.selectedText) {
                "phoneButton" -> {
                    phoneTV.toggleTextColor(
                        requireContext(), phoneTV, computerTV, healthTV, booksTV
                    )
                }
                "computerButton" -> {
                    computerTV.toggleTextColor(
                        requireContext(), phoneTV, computerTV, healthTV, booksTV
                    )
                }
                "healthButton" -> {
                    healthTV.toggleTextColor(
                        requireContext(), phoneTV, computerTV, healthTV, booksTV
                    )
                }
                "booksButton" -> {
                    booksTV.toggleTextColor(
                        requireContext(), phoneTV, computerTV, healthTV, booksTV
                    )
                }
            }
        }
    }

    private fun showFilterBottomSheet() {
        dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
        dialog.apply {
            setContentView(R.layout.filter_options_bottom_sheet)

            this.findViewById<CardView>(R.id.closeCardView)?.setOnClickListener { hide() }
            this.findViewById<Button>(R.id.doneButton)?.setOnClickListener { hide() }

            findViewById<AutoCompleteTextView>(
                R.id.brandAutoCompleteTextView
            )?.setDropDownMenu(R.array.brands)

            findViewById<AutoCompleteTextView>(
                R.id.priceAutoCompleteTextView
            )?.setDropDownMenu(R.array.price)

            findViewById<AutoCompleteTextView>(
                R.id.sizeCompleteTextView
            )?.setDropDownMenu(R.array.size)

            show()
        }
    }

    private fun AutoCompleteTextView.setDropDownMenu(stringArray: Int) {
        val brands = resources.getStringArray(stringArray)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.drop_down_item, brands)
        this.setAdapter(arrayAdapter)
    }
}