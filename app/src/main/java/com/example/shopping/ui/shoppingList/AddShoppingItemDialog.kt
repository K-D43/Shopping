package com.example.shopping.ui.shoppingList

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shopping.R
import com.example.shopping.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class AddShoppingItemDialog(context: Context,val addDialogListener: AddDialogListener): AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        tv_add.setOnClickListener {
            val name=et_item_name.text.toString()
            val amount = et_item_amount.text.toString()

            if (name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context,"Please enter all the information",Toast.LENGTH_SHORT).show()
            }

            val item = ShoppingItem(name, amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }
        tv_cancel.setOnClickListener{
            cancel()
        }
    }
}