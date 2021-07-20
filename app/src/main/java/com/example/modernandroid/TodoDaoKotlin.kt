package com.example.modernandroid

import androidx.room.*


@Dao
interface TodoDaoKotlin {
    @Query("SELECT * FROM TodoKotlin")
    fun getAll(): List<TodoKotlin>

    @Insert
    fun insert(todo: TodoKotlin?)

    @Update
    fun update(todo: TodoKotlin?)

    @Delete
    fun delete(todo: TodoKotlin?)
}