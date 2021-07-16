package com.android_mvvm_databinding_recyclerviewexample.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.android_mvvm_databinding_recyclerviewexample.model.MovieModel;
import com.android_mvvm_databinding_recyclerviewexample.repository.DataRepository;

import java.util.List;


public class ViewModel extends AndroidViewModel {
    private DataRepository dataRepository;

    public ViewModel(@NonNull Application application) {
        super(application);
        dataRepository = new DataRepository();
    }

    public LiveData<List<MovieModel.Result>> getAllMoviesData() {
        return dataRepository.getMutableLiveData();
    }
}
