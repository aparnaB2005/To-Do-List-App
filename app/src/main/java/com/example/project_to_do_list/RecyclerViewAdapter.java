package com.example.project_to_do_list;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.TaskViewHolder> {

    private List<TaskEntity> taskList;

    public interface onTaskClickListener{
        void onTaskClick(TaskEntity task);
        void onTaskLongClick(TaskEntity task);
    }

    private onTaskClickListener listener;

    public void setTaskListener(onTaskClickListener listener){
        this.listener=listener;
    }


    @SuppressLint("NotifyDataSetChanged")
    public void setTaskList(List<TaskEntity> tasks) {
        this.taskList = tasks;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_item, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        TaskEntity task = taskList.get(position);
        holder.taskTitle.setText(task.getTaskName());
        holder.taskCheckBox.setChecked(false);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
            if(listener!=null){
                listener.onTaskLongClick(task);
            }

                return true;
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.onTaskClick(task);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return taskList == null ? 0 : taskList.size();
    }

    static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView taskTitle;
        CheckBox taskCheckBox;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            taskTitle = itemView.findViewById(R.id.task_title);
            taskCheckBox = itemView.findViewById(R.id.task_checkbox);
        }
    }
}
