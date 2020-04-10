 package com.esq.e_listmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

 public class MainActivity extends AppCompatActivity {
    private TaskViewModel taskViewModel;
    private String TAG = "MainActivity";
    ViewModelProvider.Factory factory = new ViewModelProvider.AndroidViewModelFactory(getApplication());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taskViewModel = new ViewModelProvider(MainActivity.this, factory).get(TaskViewModel.class);
        taskViewModel.getAllTasks().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(List<Task> tasks) {
                //update RecyclerView
                Toast.makeText(MainActivity.this, "onChanged", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
