package com.example.modernandroid;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RoomViewModel extends AndroidViewModel {

    private AppDatabase db;


    public RoomViewModel(@NonNull @NotNull Application application) {
        super(application);

        db = Room.databaseBuilder(application, AppDatabase.class, "todo-db")
                .build();
    }

    public LiveData<List<Todo>> getAll(){
        return db.todoDao().getAll();
    }

    public void insert(Todo todo){

    }


}
