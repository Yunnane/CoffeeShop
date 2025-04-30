package com.coffeeshop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.coffeeshop.domain.BannerModel
import com.coffeeshop.domain.CategoryModel
import com.coffeeshop.domain.ItemsModel
import com.coffeeshop.repository.MainRepository

class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    fun loadBanner(): LiveData<MutableList<BannerModel>> {
        return repository.loadBanner()
    }

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        return repository.loadCategory()
    }

    fun loadPopular(): LiveData<MutableList<ItemsModel>> {
        return repository.loadPopular()
    }
}