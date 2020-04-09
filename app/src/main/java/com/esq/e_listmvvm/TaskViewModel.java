package com.esq.e_listmvvm;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class TaskViewModel extends AndroidViewModel {
    private TaskRepository repository;
    private LiveData<List<Task>> allTasks;
    private String TAG = "TaskViewModel";

    public TaskViewModel (@NonNull Application application){
        super(application);
        repository = new TaskRepository(application);
        allTasks = repository.getAllTasks();
    }

    public void insert (Task task){
        repository.insert(task);
        Log.d(TAG, "insert: A new task has been inserted");
    }

    public void update (Task task){
        repository.update(task);
        Log.d(TAG, "update: Task Updated");
    }

    public void delete(Task task){
        repository.delete(task);
        Log.d(TAG, "delete: Task deleted");
    }

    public void deleteAllTasks (Task task){
        repository.deleteAllTasks(task);
        Log.d(TAG, "deleteAllTasks: All tasks has been deleted");
    }

    public LiveData<List<Task>> getAllTasks(){
        return allTasks;
    }
}
