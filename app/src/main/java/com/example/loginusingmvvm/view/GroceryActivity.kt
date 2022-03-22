package com.example.loginusingmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginusingmvvm.R
import com.example.loginusingmvvm.adapter.GroceryAdapter
import com.example.loginusingmvvm.db.DialogListener
import com.example.loginusingmvvm.db.GroceryDatabase
import com.example.loginusingmvvm.db.GroceryItemDialog
import com.example.loginusingmvvm.factory.GroceryViewModelFactory
import com.example.loginusingmvvm.model.GroceryItems
import com.example.loginusingmvvm.model.GroceryRepository
import com.example.loginusingmvvm.viewmodel.GroceryViewModel
import kotlinx.android.synthetic.main.activity_grocery.*

class GroceryActivity : AppCompatActivity() {
    lateinit var ViewModel: GroceryViewModel
    lateinit var list: List<GroceryItems>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grocery)

        val groceryRepository = GroceryRepository(GroceryDatabase(this))
        val factory = GroceryViewModelFactory(groceryRepository)

        ViewModel = ViewModelProvider(this, factory).get(GroceryViewModel::class.java)
        val groceryAdapter = GroceryAdapter(listOf(), ViewModel)
        rvList.layoutManager = LinearLayoutManager(this)
        rvList.adapter = groceryAdapter

        ViewModel.allGroceryItems().observe(this, Observer {
            groceryAdapter.list = it
            groceryAdapter.notifyDataSetChanged()
        })

        btnAdd.setOnClickListener {
            GroceryItemDialog(this, object : DialogListener {
                override fun onAddButtonClicked(item: GroceryItems) {
                    ViewModel.insert(item)
                }
            }).show()
        }
    }
}