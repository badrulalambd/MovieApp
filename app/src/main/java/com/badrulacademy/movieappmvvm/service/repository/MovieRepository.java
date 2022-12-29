package com.badrulacademy.movieappmvvm.service.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.badrulacademy.movieappmvvm.service.model.MovieModel;
import com.badrulacademy.movieappmvvm.service.model.Result;
import com.badrulacademy.movieappmvvm.service.network.ApiServices;
import com.badrulacademy.movieappmvvm.service.network.RetrofitInstance;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private static Context mContext;
    private static MovieRepository instance;
    private MovieModel movieModel;
    private List<Result> mResult;
    private MutableLiveData<List<Result>> mLiveData;

    public static MovieRepository getInstance(Context context){
        if(instance == null){
            mContext = context;
            instance = new MovieRepository();
        }
        return  instance;
    }

    public MutableLiveData<List<Result>> getTopRatedMovieList(){

        if(mLiveData == null){
            mLiveData = new MutableLiveData<List<Result>>();
        }

        RetrofitInstance.getRetroInstance().getTopRatedMovieList("5666133161b84efcb98bbb233a45cb6b").enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {

                Log.d("response", "Response Check: " + new Gson().toJson(response.body()));

                movieModel = response.body();
                mResult = movieModel.getResults();

                Log.d("TAG", "mResult");

                mLiveData.postValue(mResult);
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });

        //return mResult;
        return mLiveData;
    }


}
