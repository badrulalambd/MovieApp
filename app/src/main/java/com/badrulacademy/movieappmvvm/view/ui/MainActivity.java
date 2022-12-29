package com.badrulacademy.movieappmvvm.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.badrulacademy.movieappmvvm.R;
import com.badrulacademy.movieappmvvm.service.model.Result;
import com.badrulacademy.movieappmvvm.view.adapter.TopMovieListAdapter;
import com.badrulacademy.movieappmvvm.viewModel.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Full_Link: https://api.themoviedb.org/3/movie/top_rated?api_key=5666133161b84efcb98bbb233a45cb6b

    private RecyclerView recyclerView;
    private TopMovieListAdapter topMovieListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView_id);

        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        MovieListViewModel mListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
        mListViewModel.getTopRatedMovieList().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {

                topMovieListAdapter = new TopMovieListAdapter(MainActivity.this, results);
                recyclerView.setAdapter(topMovieListAdapter);
            }
        });


    }
}