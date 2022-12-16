package com.example.shopping.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "shopping_item")
data class ShoppingItem(
    @ColumnInfo(name="ItemName")
    var name:String,
    @ColumnInfo(name = "ItemAmount")
    var amount:Int
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
