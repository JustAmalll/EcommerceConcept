package dev.amal.ecommerceconcept.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.amal.ecommerceconcept.R
import dev.amal.ecommerceconcept.data.remote.dto.BestSeller
import dev.amal.ecommerceconcept.databinding.BestSellerItemBinding

class BestSellerAdapter(
    private val bestSellers: List<BestSeller>,
    private val context: Context
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
        val bestSeller = bestSellers[position]
        holder.binding.apply {
            newPriceTextView.text = bestSeller.discount_price.toString()
            oldPriceTextView.text = bestSeller.price_without_discount.toString()
            brandTextView.text = bestSeller.title

            Glide.with(context)
                .load(bestSeller.picture)
                .into(phonePreviewImageView)

            if (bestSeller.is_favorites) {
                heartIcon.setImageDrawable(
                    ContextCompat.getDrawable(context, R.drawable.ic_heart_filled)
                )
            } else {
                heartIcon.setImageDrawable(
                    ContextCompat.getDrawable(context, R.drawable.ic_heart_outline)
                )
            }
        }
    }

    override fun getItemCount(): Int = bestSellers.size
}