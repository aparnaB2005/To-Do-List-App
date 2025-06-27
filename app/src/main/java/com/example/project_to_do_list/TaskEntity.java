package com.example.project_to_do_list;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasks")
public class TaskEntity {
@PrimaryKey(autoGenerate = true)
    private int id;
@ColumnInfo(name="task_Name")
    private String taskName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    @Ignore
    public TaskEntity(String taskName){
        this.taskName=taskName;
    }
    public TaskEntity(){

    }
}
