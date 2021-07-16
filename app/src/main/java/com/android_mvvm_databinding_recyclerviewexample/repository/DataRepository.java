package com.android_mvvm_databinding_recyclerviewexample.repository;

import androidx.lifecycle.MutableLiveData;

import com.android_mvvm_databinding_recyclerviewexample.model.MovieModel;
import com.android_mvvm_databinding_recyclerviewexample.network.ApiDataService;
import com.android_mvvm_databinding_recyclerviewexample.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {
    private ArrayList<MovieModel.Result> movieModelslist = new ArrayList<>();
    private MutableLiveData<List<MovieModel.Result>> mutableLiveData = new MutableLiveData<>();

    public DataRepository() {
    }

    ////call to internet and  retun  MutableLiveData
    public MutableLiveData<List<MovieModel.Result>> getMutableLiveData() {
        final ApiDataService userDataService = RetrofitClient.getService();
        Call<MovieModel> call = userDataService.getApiRequestsArray();
        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> resp) {
                if (resp != null && resp.body() != null) {
                    try {
                        MovieModel movieModel = new MovieModel();
                        movieModel = resp.body();
                        movieModelslist.addAll(movieModel.getResults());
                        mutableLiveData.setValue(movieModelslist);
                    } catch (Exception ex) {
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                t.printStackTrace();
            }
        });


        return mutableLiveData;
    }
}
