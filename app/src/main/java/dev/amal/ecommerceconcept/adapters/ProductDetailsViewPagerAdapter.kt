package dev.amal.ecommerceconcept.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.amal.ecommerceconcept.databinding.ProductDetailsViewPagerItemBinding

class ProductDetailsViewPagerAdapter(
    private val images: List<String>,
    private val context: Context
) :
    RecyclerView.Adapter<ProductDetailsViewPagerAdapter.ViewPagerViewHolder>() {

    class ViewPagerViewHolder(val binding: ProductDetailsViewPagerItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder =
        ViewPagerViewHolder(
            ProductDetailsViewPagerItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val image = images[position]
        Glide.with(context)
            .load(image)
            .into(holder.binding.phonePreviewImageView)
    }

    override fun getItemCount(): Int = images.size
}