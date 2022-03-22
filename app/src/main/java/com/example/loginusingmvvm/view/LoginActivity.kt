package com.example.loginusingmvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.loginusingmvvm.R
import com.example.loginusingmvvm.databinding.ActivityLoginBinding
import com.example.loginusingmvvm.factory.UserViewModelFactory
import com.example.loginusingmvvm.model.User
import com.example.loginusingmvvm.viewmodel.UserViewModel

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var activityMainBinding: ActivityLoginBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_login
        )
        var userViewModel: UserViewModel = ViewModelProvider(this, UserViewModelFactory(
            User(), this)).get(UserViewModel::class.java)

        activityMainBinding.userViewModel = userViewModel
    }
}