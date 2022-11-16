package dev.amal.feature_home_store.adapters

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.amal.core.utils.Constants.TO_PRODUCT_DETAILS_FRAGMENT
import dev.amal.core.utils.setImageDrawable
import dev.amal.feature_home_store.databinding.BestSellerItemBinding
import dev.amal.feature_home_store.domain.model.BestSeller

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
                val request = NavDeepLinkRequest.Builder
                    .fromUri(TO_PRODUCT_DETAILS_FRAGMENT.toUri())
                    .build()
                navController.navigate(request)
            }

            newPriceTextView.text = bestSeller.discountPrice.toString()
            oldPriceTextView.text = bestSeller.priceWithoutDiscount.toString()
            oldPriceTextView.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            brandTextView.text = bestSeller.title

            Glide.with(context)
                .load(bestSeller.picture)
                .into(phonePreviewImageView)

            if (bestSeller.isFavorites) heartIcon.setImageDrawable(
                context, dev.amal.core.R.drawable.ic_heart_filled
            )
            else heartIcon.setImageDrawable(context, dev.amal.core.R.drawable.ic_heart_outline)
        }
    }

    override fun getItemCount(): Int = bestSeller.size
}