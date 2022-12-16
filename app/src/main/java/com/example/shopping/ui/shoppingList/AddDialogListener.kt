package com.example.shopping.ui.shoppingList

import com.example.shopping.data.db.entities.ShoppingItem

interface AddDialogListener {

    fun onAddButtonClicked(item:ShoppingItem)
}