package com.callor.movie.service;

import com.callor.movie.config.NaverAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit getInstanse(){

        return new Retrofit.Builder()
                .baseUrl(NaverAPI.Naver_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NaverRetrofit getApiClient(){

        return getInstanse().create(NaverRetrofit.class);
    }

}
