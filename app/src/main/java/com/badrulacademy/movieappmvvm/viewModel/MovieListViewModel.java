package com.badrulacademy.movieappmvvm.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.badrulacademy.movieappmvvm.service.model.Result;
import com.badrulacademy.movieappmvvm.service.repository.MovieRepository;

import java.util.List;

public class MovieListViewModel extends AndroidViewModel {

    private final MovieRepository mRepo;

    public MovieListViewModel(@NonNull Application application) {
        super(application);
        mRepo = MovieRepository.getInstance(application);
    }

    public MutableLiveData<List<Result>> getTopRatedMovieList(){
        return mRepo.getTopRatedMovieList();
    }
}
