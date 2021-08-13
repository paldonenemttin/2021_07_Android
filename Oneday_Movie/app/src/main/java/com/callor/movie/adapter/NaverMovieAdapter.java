package com.callor.movie.adapter;

import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.movie.R;
import com.callor.movie.model.MovieDTO;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class NaverMovieAdapter extends RecyclerView.Adapter {

    private List<MovieDTO> movieList;

    public NaverMovieAdapter(List<MovieDTO> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.movie_item_view,parent,false);

        MovieItemHolder viewHolder = new MovieItemHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MovieItemHolder movieItemHolder = (MovieItemHolder) holder;

        MovieDTO movieDTO = movieList.get(position);
        String item_title = movieDTO.getTitle();
        Spanned sp_title = Html.fromHtml(item_title,Html.FROM_HTML_MODE_LEGACY);
        movieItemHolder.item_title.setText(sp_title);

        String item_direct = movieDTO.getDirector();
        Spanned sp_direct = Html.fromHtml(item_direct,Html.FROM_HTML_MODE_LEGACY);
        movieItemHolder.item_direct.setText(sp_direct);

        String item_rating = movieDTO.getUserRating();
        Spanned sp_rating = Html.fromHtml(item_rating,Html.FROM_HTML_MODE_LEGACY);
        movieItemHolder.item_rating.setText(sp_rating);

        String item_actor = movieDTO.getActor();
        Spanned sp_actor = Html.fromHtml(item_actor,Html.FROM_HTML_MODE_LEGACY);
        movieItemHolder.item_rating.setText(sp_actor);

        if (!movieDTO.getImage().isEmpty()){
            Picasso.get().load(movieDTO.getImage()).into(movieItemHolder.item_image);
        }

    }

    @Override
    public int getItemCount() {

        return movieList == null ? 0 : movieList.size();
    }

    public static class MovieItemHolder extends RecyclerView.ViewHolder{

        public TextView item_title;
        public ImageView item_image;
        public TextView item_direct;
        public TextView item_rating;

        public MovieItemHolder(@NonNull View itemView) {
            super(itemView);

            item_title = itemView.findViewById(R.id.movie_item_title);
            item_image = itemView.findViewById(R.id.movie_item_image);
            item_direct = itemView.findViewById(R.id.movie_item_direct);
            item_rating = itemView.findViewById(R.id.movie_item_rating);
        }
    }
}
