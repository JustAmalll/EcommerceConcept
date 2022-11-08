package dev.amal.ecommerceconcept.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.amal.ecommerceconcept.databinding.ViewPagerHotSalesItemBinding
import dev.amal.ecommerceconcept.domain.model.HomeStore

class HotSalesViewPagerAdapter(
    private val hotSales: List<HomeStore>,
    private val context: Context
) :
    RecyclerView.Adapter<HotSalesViewPagerAdapter.ViewPagerViewHolder>() {

    class ViewPagerViewHolder(val binding: ViewPagerHotSalesItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder =
        ViewPagerViewHolder(
            ViewPagerHotSalesItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val hotSales = hotSales[position]
        Glide.with(context)
            .load(hotSales.picture)
            .into(holder.binding.hotSalesImageView)

        if (hotSales.isNew) holder.binding.newCardView.visibility = View.VISIBLE
        else holder.binding.newCardView.visibility = View.INVISIBLE

        holder.binding.titleTextView.text = hotSales.title
        holder.binding.subTitleTextView.text = hotSales.subtitle

        // Second image already have it owns text
        if (position == 1) {
            holder.binding.titleTextView.visibility = View.INVISIBLE
            holder.binding.subTitleTextView.visibility = View.INVISIBLE
        } else {
            holder.binding.titleTextView.visibility = View.VISIBLE
            holder.binding.subTitleTextView.visibility = View.VISIBLE
        }

        if (hotSales.isBuy) holder.binding.buyNowButton.visibility = View.VISIBLE
        else holder.binding.buyNowButton.visibility = View.GONE

    }

    override fun getItemCount(): Int = hotSales.size
}