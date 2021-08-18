package com.callor.movie.service;

import com.callor.movie.model.NaverParent;

import lombok.Getter;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface NaverRetrofit {

    @GET("movie.json")
    public Call<NaverParent> getMoive(
            @Header("X-Naver_Client-Id") String clientId,
            @Header("X-Naver_Client-Secret") String clientSecret,
            @Query("query") String query,
            @Query("start") int start,
            @Query("display") int display
    );
}
