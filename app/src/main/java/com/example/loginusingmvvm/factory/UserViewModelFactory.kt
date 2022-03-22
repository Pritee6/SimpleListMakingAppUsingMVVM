package com.example.loginusingmvvm.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.loginusingmvvm.model.User
import com.example.loginusingmvvm.viewmodel.UserViewModel

class UserViewModelFactory(private var user: User,
                           private var context: Context)
    : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(user, context) as T
    }
}