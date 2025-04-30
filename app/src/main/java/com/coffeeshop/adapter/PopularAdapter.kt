package com.coffeeshop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.coffeeshop.databinding.ViewholderPopularBinding
import com.coffeeshop.domain.ItemsModel

class PopularAdapter(private val items: MutableList<ItemsModel>) :
    RecyclerView.Adapter<PopularAdapter.ViewHolder>() {
    private lateinit var context: Context

    inner class ViewHolder(val binding: ViewholderPopularBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularAdapter.ViewHolder {
        context = parent.context
        val binding = ViewholderPopularBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.popularCoffeeTitle.text = item.title
        holder.binding.popularCoffeePrice.text = buildString {
            append(item.price)
            append("$")
        }
        Glide.with(context)
            .load(items[position].picUrl[0])
            .into(holder.binding.popularCoffeePicture)
    }

    override fun getItemCount(): Int = items.size
}