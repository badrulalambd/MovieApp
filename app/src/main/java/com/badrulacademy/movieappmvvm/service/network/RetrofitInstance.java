package com.badrulacademy.movieappmvvm.service.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static String BASE_URL = "https://api.themoviedb.org/";
    private static Retrofit retrofit = null;


    public static ApiServices getRetroInstance(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

       return retrofit.create(ApiServices.class);
    }
}
