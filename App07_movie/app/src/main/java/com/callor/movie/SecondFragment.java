package com.callor.movie;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.callor.movie.databinding.FragmentSecondBinding;
import com.callor.movie.service.NaverApiService;
import com.callor.movie.service.impl.NaverMovieServiceImplV1;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        if(getArguments() != null){
            Log.d("전달받은 전체 arguments",getArguments().toString());
            // 전달받은 매개변수 중에 변수 이름이 movie_search라는 친구가 있으면
            // 그 값을 movie_search 변수에 담아라
            // 만약 있으면 기본 값인 ""을 변수에 담아라
            String movie_search = getArguments().getString("movie_search","");
            Log.d("movie_search",movie_search);


            NaverApiService naverApiService = new NaverMovieServiceImplV1(binding.movieListView);
            naverApiService.getNaverData(movie_search);
        }

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}