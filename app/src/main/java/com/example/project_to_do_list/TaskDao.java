package com.example.project_to_do_list;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface TaskDao {

@Query("select * from tasks")
   LiveData<List<TaskEntity>> getAllTasks();

@Insert
    void insert(TaskEntity task);

@Delete
    void delete(TaskEntity task);

@Update
    void update(TaskEntity task);

}
