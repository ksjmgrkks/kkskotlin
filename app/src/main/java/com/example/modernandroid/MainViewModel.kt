package com.example.modernandroid

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Room
import androidx.lifecycle.AndroidViewModel

class MainViewModel(application : Application): AndroidViewModel(application) {
   private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "database-name"
    ).build()

    fun getAll(): LiveData<List<Todo>> {
        return db.todoDao().getAll()
    }

    fun insert(todo: Todo){
        db.todoDao().insert(todo)
    }
}