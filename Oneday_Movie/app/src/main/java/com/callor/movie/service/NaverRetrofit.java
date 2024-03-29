package com.callor.movie.service;

import com.callor.movie.model.NaverParent;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface NaverRetrofit {

    @GET("movie.json")
    public abstract Call<NaverParent> getMovie(
            @Header("X-Naver-Client-Id") String clientId,
            @Header("X-Naver-Client-Secret") String clientSecret,
            @Query("query") String qeury,
            @Query("start") int start,
            @Query("display") int display
    );
}
