package dev.amal.ecommerceconcept.adapters

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.amal.ecommerceconcept.R
import dev.amal.ecommerceconcept.common.setImageDrawable
import dev.amal.ecommerceconcept.databinding.BestSellerItemBinding
import dev.amal.ecommerceconcept.domain.model.BestSeller

class BestSellerAdapter(
    private val bestSeller: List<BestSeller>,
    private val context: Context,
    private val navController: NavController
) : RecyclerView.Adapter<BestSellerAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: BestSellerItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            BestSellerItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val bestSeller = bestSeller[position]
        holder.binding.apply {
            bestSellerContainer.setOnClickListener {
                navController.navigate(R.id.action_homeStoreFragment_to_productDetailsFragment)
            }

            newPriceTextView.text = bestSeller.discountPrice.toString()
            oldPriceTextView.text = bestSeller.priceWithoutDiscount.toString()
            oldPriceTextView.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            brandTextView.text = bestSeller.title

            Glide.with(context)
                .load(bestSeller.picture)
                .into(phonePreviewImageView)

            if (bestSeller.isFavorites) heartIcon.setImageDrawable(
                context, R.drawable.ic_heart_filled
            )
            else heartIcon.setImageDrawable(context, R.drawable.ic_heart_outline)
        }
    }

    override fun getItemCount(): Int = bestSeller.size
}