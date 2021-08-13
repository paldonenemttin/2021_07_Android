package com.callor.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.SearchView;

import com.callor.movie.service.MovieService;
import com.callor.movie.service.impl.MovieServiceImplV1;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar main_search = findViewById(R.id.main_search);
//        setSupportActionBar(main_search);

        recyclerView = findViewById(R.id.movie_list);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.movie_item_menu,menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();

        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("title search");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("click", query);

                MovieService movieService = new MovieServiceImplV1(recyclerView);
                movieService.getMovies(query.trim());
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}