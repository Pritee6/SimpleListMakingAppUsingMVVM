package com.example.loginusingmvvm.model

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.loginusingmvvm.model.GroceryItems

@Dao
interface GroceryDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: GroceryItems)

    @Delete
    suspend fun delete(item: GroceryItems)

    @Query("SELECT * FROM grocery_items")
    fun getAllGroceryItems(): LiveData<List<GroceryItems>>
}