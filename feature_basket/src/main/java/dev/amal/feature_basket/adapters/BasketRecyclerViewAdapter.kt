package dev.amal.feature_basket.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.amal.feature_basket.databinding.CartItemBinding
import dev.amal.feature_basket.domain.model.BasketInfo

class BasketRecyclerViewAdapter(
    private val basket: List<BasketInfo>,
    private val context: Context
) : RecyclerView.Adapter<BasketRecyclerViewAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            CartItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val basketItems = basket[position]
        holder.binding.apply {
            brandTextView.text = basketItems.title
            priceTextView.text = "$${basketItems.price}.00"
            Glide.with(context)
                .load(basketItems.images)
                .into(phonePreviewImageView)
        }
    }

    override fun getItemCount(): Int = basket.size
}