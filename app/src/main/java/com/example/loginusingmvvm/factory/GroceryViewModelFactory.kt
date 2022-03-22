package com.example.loginusingmvvm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.loginusingmvvm.model.GroceryRepository
import com.example.loginusingmvvm.viewmodel.GroceryViewModel

class GroceryViewModelFactory(private val repository: GroceryRepository)
    : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GroceryViewModel(repository) as T
    }
}