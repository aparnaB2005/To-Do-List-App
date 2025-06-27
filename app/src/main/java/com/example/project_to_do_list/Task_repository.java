package com.example.project_to_do_list;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Task_repository {
    public TaskDao taskDao;
    public LiveData<List<TaskEntity>> allTasks;

    public Task_repository(Context context){
        TaskDatabase db=TaskDatabase.getInstance(context);
        taskDao=db.taskDao();
        allTasks= taskDao.getAllTasks();
    }

    public void insert(TaskEntity task){
        new Thread(()-> taskDao.insert(task)).start();
    }

    public void delete(TaskEntity task){
        new Thread(()-> taskDao.delete(task)).start();
    }

    public void update(TaskEntity task){

        new Thread(()->taskDao.update(task)).start();
    }

    public LiveData<List<TaskEntity>> getAllTasks() {
        return allTasks;
    }


}
