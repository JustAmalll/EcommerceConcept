package dev.amal.ecommerceconcept.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.amal.ecommerceconcept.databinding.BestSellerItemBinding

class BestSellerAdapter : RecyclerView.Adapter<BestSellerAdapter.MyViewHolder>() {

    class MyViewHolder(binding: BestSellerItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            BestSellerItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 8
}