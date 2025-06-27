package com.example.project_to_do_list;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


public class ViewModel extends AndroidViewModel {
    public Task_repository taskRepository;
    public LiveData<List<TaskEntity>> allTasks;
    public ViewModel(@NonNull Application application) {
        super(application);
        taskRepository=new Task_repository(application);
        allTasks=taskRepository.getAllTasks();
    }
    public void insert(TaskEntity task){
        taskRepository.insert(task);
    }
    public void delete(TaskEntity task){
        taskRepository.delete(task);
    }

    public void update(TaskEntity task){
        taskRepository.update(task);
    }

    public LiveData<List<TaskEntity>> getAllTasks(){
        return allTasks;
    }
}

