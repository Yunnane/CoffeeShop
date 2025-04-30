package com.coffeeshop.activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.coffeeshop.adapter.CategoryAdapter
import com.coffeeshop.adapter.PopularAdapter
import com.coffeeshop.databinding.ActivityDashboardBinding
import com.coffeeshop.viewmodel.MainViewModel

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDashboardBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initBanner()
        initCategory()
        initPopular()
    }

    private fun initBanner() {
        binding.progressBarBanner.visibility = View.VISIBLE
        viewModel.loadBanner().observeForever {
            Glide.with(this@DashboardActivity)
                .load(it[0].url)
                .into(binding.banner)
            binding.progressBarBanner.visibility = View.GONE
        }
        viewModel.loadBanner()
    }

    private fun initCategory() {
        binding.progressBarCategory.visibility = View.VISIBLE
        viewModel.loadCategory().observeForever {
            binding.recyclerViewCategory.layoutManager =
                LinearLayoutManager(this@DashboardActivity, LinearLayoutManager.HORIZONTAL, false)

            binding.recyclerViewCategory.adapter = CategoryAdapter(it)
            binding.progressBarCategory.visibility = View.GONE
        }
        viewModel.loadCategory()
    }

    private fun initPopular() {
        binding.progressBarPopularCoffees.visibility = View.VISIBLE
        viewModel.loadPopular().observeForever {
            binding.recyclerViewPopularCoffees.layoutManager =
                GridLayoutManager(this, 2)
            binding.recyclerViewPopularCoffees.adapter = PopularAdapter(it)
            binding.progressBarPopularCoffees.visibility = View.GONE
        }
        viewModel.loadPopular()
    }
}