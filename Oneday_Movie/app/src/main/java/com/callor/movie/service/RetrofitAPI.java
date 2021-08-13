package com.callor.movie.service;

import com.callor.movie.config.Naver;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAPI {

    public static NaverRetrofit getAPIclient(){

        NaverRetrofit naverRetrofit = getConnection().create(NaverRetrofit.class);
        return  naverRetrofit;
    }

    private static Retrofit getConnection() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Naver.Naver_Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
