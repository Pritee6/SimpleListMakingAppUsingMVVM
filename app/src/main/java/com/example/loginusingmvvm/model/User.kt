package com.example.loginusingmvvm.model

import android.text.TextUtils
import android.util.Patterns

class User() {

    lateinit var email: String
    lateinit var password: String

    fun isValidEmail(): Boolean {
        if (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email)
                .matches()
        ) {
            return true
        }
        return false
    }

    fun isValidPassword(): Boolean {
        if (this.password.length>=6){
            return true
        }
        return false
    }

    fun isValidCredential(): Boolean {
        if (this.email.equals("pritee@gmail.com") && this.password.equals("123456")){
            return true
        }
        return false
    }
}