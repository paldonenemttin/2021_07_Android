package com.callor.movie.adapter;

import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.callor.movie.databinding.MovieItemViewBinding;
import com.callor.movie.model.MovieDTO;

import java.util.List;

public class NaverMovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MovieDTO> movieList;

    public NaverMovieAdapter(List<MovieDTO> movieList) {

        this.movieList = movieList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        MovieItemViewBinding movieBinding = MovieItemViewBinding.inflate(layoutInflater,parent,false);

        return new MovieViewHolder(movieBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MovieViewHolder viewHolder = (MovieViewHolder) holder;
        MovieDTO movieDTO = movieList.get(position);
        MovieItemViewBinding mBinding = viewHolder.movieItemViewBinding;

        Spanned sTitle = Html.fromHtml(movieDTO.getTitle(),Html.FROM_HTML_MODE_LEGACY);
        mBinding.movieItemTitle.setText(sTitle);

        String strDrect = String.format("<b>감독 : </b> %s",movieDTO.getDirector());
        Spanned sDrect = Html.fromHtml(movieDTO.getDirector(),Html.FROM_HTML_MODE_LEGACY);
        mBinding.movieItemDirect.setText(sDrect);

        String strActor = String.format("<b>감독 : </b> %s",movieDTO.getActor());
        Spanned sActor = Html.fromHtml(movieDTO.getActor(),Html.FROM_HTML_MODE_LEGACY);
        mBinding.movieItemActor.setText(strActor);

        Double intRating = Double.valueOf(movieDTO.getUserRating());
        String strRating = String.format("<b>평점 : </b>%3.2f", movieDTO.getUserRating());
        Spanned sRating = Html.fromHtml(movieDTO.getUserRating(),Html.FROM_HTML_MODE_LEGACY);
        mBinding.movieItemRating.setText(sRating);

        /*
        glide를 사용하여 이미지 링크를 참조하여
        이미지 표현하기
         */
        if(!movieDTO.getImage().isEmpty()){
            Glide.with(mBinding.movieItemPoster.getContext())
                    .load(movieDTO.getImage())
                    .into(mBinding.movieItemPoster);
        }

    }

    @Override
    public int getItemCount() {
        return movieList == null ? 0 : movieList.size();
    }

    public static class MovieViewHolder extends  RecyclerView.ViewHolder{
        public MovieItemViewBinding movieItemViewBinding;
        public MovieViewHolder(@NonNull MovieItemViewBinding movieItemViewBinding) {
            super(movieItemViewBinding.getRoot());
            this.movieItemViewBinding = movieItemViewBinding;
        }
    }
}
