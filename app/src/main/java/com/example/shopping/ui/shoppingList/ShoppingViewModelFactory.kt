package com.example.shopping.ui.shoppingList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shopping.data.repository.shoppingViewModel

class ShoppingViewModelFactory(private val repository: ShoppingRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return shoppingViewModel(repository) as T
    }
}