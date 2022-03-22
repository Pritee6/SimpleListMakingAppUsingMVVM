package com.example.loginusingmvvm.db

import com.example.loginusingmvvm.model.GroceryItems

interface DialogListener {

    fun onAddButtonClicked(item: GroceryItems)

}