package dev.amal.ecommerceconcept.fragments.home_store_fragment

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
import dev.amal.ecommerceconcept.common.showProgressBarWhenLoading
import dev.amal.ecommerceconcept.databinding.FragmentHomeStoreBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeStoreFragment : BaseFragment<FragmentHomeStoreBinding>(
    FragmentHomeStoreBinding::inflate
) {

    private lateinit var dialog: BottomSheetDialog
    private val viewModel by viewModels<HomeStoreViewModel>()

    override fun setupClickListener() = with(binding) {
        filterIcon.setOnClickListener {
            showFilterBottomSheet()
        }
        phonesLinearLayout.setOnClickListener {

        }
        computerLinearLayout.setOnClickListener {

        }
        healthLinearLayout.setOnClickListener {

        }
        booksLinearLayout.setOnClickListener {

        }
    }

    override fun onCreateView() {
        super.onCreateView()

        lifecycleScope.launch {
            viewModel.stateFlow.collectLatest {
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