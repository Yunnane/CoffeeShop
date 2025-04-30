package com.coffeeshop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coffeeshop.R
import com.coffeeshop.databinding.ViewholderCategoryBinding
import com.coffeeshop.domain.CategoryModel


class CategoryAdapter(private val items: MutableList<CategoryModel>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    private lateinit var context: Context
    private var selectedPosition = -1
    private var lastSelectedPosition = -1

    inner class ViewHolder(val binding: ViewholderCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
        context = parent.context
        val binding = ViewholderCategoryBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
        val item = items[holder.adapterPosition]
        holder.binding.titleCategory.text = item.title
        holder.binding.root.setOnClickListener {
            lastSelectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(position)
        }
        if (selectedPosition == position) {
            holder.binding.titleCategory.setBackgroundResource(R.drawable.dark_bg)
            holder.binding.titleCategory.setTextColor(context.resources.getColor(R.color.white))
        } else {
            holder.binding.titleCategory.setBackgroundResource(R.drawable.white_bg)
            holder.binding.titleCategory.setTextColor(context.resources.getColor(R.color.darkBrown))
        }
    }

    override fun getItemCount(): Int = items.size
}