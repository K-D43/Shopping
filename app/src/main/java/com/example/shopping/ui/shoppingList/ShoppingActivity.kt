package com.example.shopping.ui.shoppingList

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopping.Other.ShoppingItemAdapter
import com.example.shopping.R
import com.example.shopping.data.db.ShoppingDatabase
import com.example.shopping.data.db.entities.ShoppingItem
import com.example.shopping.data.repository.shoppingViewModel
import kotlinx.android.synthetic.main.activity_main.*

class ShoppingActivity : AppCompatActivity()
{
//    private var viewModel:shoppingViewModel?=null
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProvider(this,factory)[shoppingViewModel::class.java]

        val adapter = ShoppingItemAdapter(listOf(),viewModel)

        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

    fab.setOnClickListener{
        AddShoppingItemDialog(this,
        object : AddDialogListener{
            override fun onAddButtonClicked(item: ShoppingItem){
                viewModel.upsert(item)
            }
        }).show()
    }
    }
}