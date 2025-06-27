package com.example.project_to_do_list;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = TaskEntity.class ,exportSchema = false,version = 1)
public abstract class TaskDatabase extends RoomDatabase {
    private static final String DB_NAME="task_db";

    public static TaskDatabase instance;

    public abstract TaskDao taskDao();

    public static synchronized TaskDatabase getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context, TaskDatabase.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
