package com.example.modernandroid

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoKotlin(var title: String){
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}