package com.example.shopping.Other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.R
import com.example.shopping.data.db.entities.ShoppingItem
import com.example.shopping.data.repository.shoppingViewModel

class ShoppingItemAdapter(
    var items:List<ShoppingItem>,
    private val viewModel:shoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {
    inner class ShoppingViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tvname=itemView.findViewById<TextView>(R.id.tv_name)
        val tvamount=itemView.findViewById<TextView>(R.id.tv_amount)
        val ivdelete=itemView.findViewById<ImageView>(R.id.iv_delete)
        val ivminus=itemView.findViewById<ImageView>(R.id.iv_minus)
        val ivplus=itemView.findViewById<ImageView>(R.id.iv_plus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_list_item,parent,false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItems= items[position]
        holder.tvname.text=curShoppingItems.name
        holder.tvamount.text="${curShoppingItems.amount}"

        holder.ivdelete.setOnClickListener{
            viewModel.delete(curShoppingItems)
        }
        holder.ivminus.setOnClickListener{
            if(curShoppingItems.amount > 0){
                curShoppingItems.amount--
                viewModel.upsert(curShoppingItems)
            }
        holder.ivplus.setOnClickListener{
            if(curShoppingItems.amount>=0){
                curShoppingItems.amount++
                viewModel.upsert(curShoppingItems)
            }
        }
    }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}