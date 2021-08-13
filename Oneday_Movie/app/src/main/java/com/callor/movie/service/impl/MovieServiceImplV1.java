package com.callor.movie.service.impl;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.movie.adapter.NaverMovieAdapter;
import com.callor.movie.config.Naver;
import com.callor.movie.model.MovieDTO;
import com.callor.movie.model.NaverParent;
import com.callor.movie.service.MovieService;
import com.callor.movie.service.RetrofitAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieServiceImplV1 implements MovieService {

    protected RecyclerView recyclerView;

    public MovieServiceImplV1(RecyclerView recyclerView){
        this.recyclerView = recyclerView;
    }

    @Override
    public String getMovies(String search) {

        Call<NaverParent> rtfReturn = RetrofitAPI.getAPIclient()
                .getMovie(Naver.Naver_Client_Id, Naver.Naver_Client_Secret, search, 1,15);

        rtfReturn.enqueue(new Callback<NaverParent>() {
            @Override
            public void onResponse(Call<NaverParent> call, Response<NaverParent> response) {

                int res = response.code();
                if(res < 300){
                    Log.d("응답한 데이터",response.body().toString() );
                    NaverParent naverParent = response.body();

                    List<MovieDTO> movieList = naverParent.items;

                    NaverMovieAdapter movieAdapter = new NaverMovieAdapter(movieList);

                    recyclerView.setAdapter(movieAdapter);

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
                    recyclerView.setLayoutManager(layoutManager);
                } else{
                    Log.d("오류 발생", response.toString());
                }

            }

            @Override
            public void onFailure(Call<NaverParent> call, Throwable t) {

            }
        });

        return null;
    }
}
