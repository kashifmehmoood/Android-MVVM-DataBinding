package com.android_mvvm_databinding_recyclerviewexample.network;


import com.android_mvvm_databinding_recyclerviewexample.model.MovieModel;
import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiDataService {

    @GET("upcoming?api_key=16e74fede93dc203e9d049a1e92fc29a")
    Call<MovieModel> getApiRequestsArray();

}
