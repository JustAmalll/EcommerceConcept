package dev.amal.ecommerceconcept

import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import dev.amal.ecommerceconcept.adapters.BestSellerAdapter
import dev.amal.ecommerceconcept.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>(
    FragmentMainBinding::inflate
) {

    private lateinit var dialog: BottomSheetDialog

    override fun setupClickListener() = with(binding) {
        bestSellerRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = BestSellerAdapter()
        }
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