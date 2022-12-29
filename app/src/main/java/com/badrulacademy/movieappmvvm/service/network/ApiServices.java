package com.badrulacademy.movieappmvvm.service.network;

import com.badrulacademy.movieappmvvm.service.model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {
    @GET("3/movie/top_rated")
    Call<MovieModel> getTopRatedMovieList(
            @Query("api_key") String api_key
    );
}
