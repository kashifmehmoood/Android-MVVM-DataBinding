package com.android_mvvm_databinding_recyclerviewexample;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android_mvvm_databinding_recyclerviewexample.CustomAdatper.CustomAdapter;
import com.android_mvvm_databinding_recyclerviewexample.databinding.ActivityMainBinding;
import com.android_mvvm_databinding_recyclerviewexample.model.MovieModel;
import com.android_mvvm_databinding_recyclerviewexample.Viewmodel.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    ProgressBar loadBar;
    private ViewModel mainViewModel;
    private CustomAdapter mDeveloper_CustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        RecyclerView recyclerView = activityMainBinding.viewdeveloper;
        loadBar = activityMainBinding.loadBar;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        mainViewModel = ViewModelProviders.of(this).get(ViewModel.class);
        mDeveloper_CustomAdapter = new CustomAdapter();
        recyclerView.setAdapter(mDeveloper_CustomAdapter);
        getAllDev();
    }

    private void getAllDev() {
        ///get the list of dev from api response
        mainViewModel.getAllMoviesData().observe(this, new Observer<List<MovieModel.Result>>() {
            @Override
            public void onChanged(@Nullable List<MovieModel.Result> movieResult) {
                ///if any thing chnage the update the UI
                mDeveloper_CustomAdapter.setDeveloperList((ArrayList<MovieModel.Result>) movieResult);
                loadBar.setVisibility(View.GONE);
            }
        });
    }
}
