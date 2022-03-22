package com.example.loginusingmvvm.viewmodel

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loginusingmvvm.model.User
import com.example.loginusingmvvm.view.GroceryActivity

class UserViewModel(user: User, context: Context) : ViewModel() {

    var email: MutableLiveData<String> = MutableLiveData<String>()
    var password: MutableLiveData<String> = MutableLiveData<String>()

    var user = user
    var context = context

    fun onClickLogin() {
        user.email = email.value.toString()
        user.password = password.value.toString()

        if (!user.isValidEmail()) {
            Toast.makeText(context, "Invalid Email", Toast.LENGTH_LONG).show()
        }else if (!user.isValidPassword()){
            Toast.makeText(context, "Password must be minimum 6 characters", Toast.LENGTH_LONG).show()
        }else if (user.isValidCredential()){
            Toast.makeText(context, "Login Successful", Toast.LENGTH_LONG).show()
            context.startActivity(Intent(context, GroceryActivity::class.java))
        }
        else {
            Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_LONG).show()
        }
    }
}