package com.example.project_to_do_list;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtTask;
    Button addTask;
    RecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTask = findViewById(R.id.edtTask);
        addTask = findViewById(R.id.addTask);
        addTask.setBackgroundTintList(null);
        addTask.setBackgroundResource(R.drawable.btn_bg);
        recyclerView = findViewById(R.id.recyclerView);

        adapter = new RecyclerViewAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        viewModel.getAllTasks().observe(this, taskEntities -> adapter.setTaskList(taskEntities));

        addTask.setOnClickListener(v -> {
            String taskText = edtTask.getText().toString().trim();
            if (!taskText.isEmpty()) {
                TaskEntity task = new TaskEntity(taskText);
                viewModel.insert(task);
                edtTask.setText("");
            }
        });

     adapter.setTaskListener(new RecyclerViewAdapter.onTaskClickListener() {
         @Override
         public void onTaskClick(TaskEntity task) {
             showEditDialog(task);
         }

         @Override
         public void onTaskLongClick(TaskEntity task) {
              viewModel.delete(task);
         }
     });
    }
       public void showEditDialog(TaskEntity task){

           Dialog dialog=new Dialog(this);
           dialog.setContentView(R.layout.dialog_update);
           Button btn_update_task=dialog.findViewById(R.id.btn_update_task);
           EditText edt_dialog_task=dialog.findViewById(R.id.edt_dialog_task);
           edt_dialog_task.setText(task.getTaskName());

           btn_update_task.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   String updatedText=edt_dialog_task.getText().toString().trim();
                   if(!updatedText.isEmpty()){
                       task.setTaskName(updatedText);
                       viewModel.update(task);
                   }
                   Toast.makeText(MainActivity.this, "Task is updated!!", Toast.LENGTH_LONG).show();
                   dialog.dismiss();
               }
           });
             dialog.show();

       }
}
