package com.test.logitech.presenter;

import com.test.logitech.model.entity.MovieList;
import com.test.logitech.presenter.presenterinterface.HomeScreenPresenter;
import com.test.logitech.utils.ConnectionUtils;
import com.test.logitech.view.viewinterface.HomeScreenView;

import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeScreenPresenterImpl extends BasePresenter<HomeScreenView> implements HomeScreenPresenter {

    @Override
    public void getMovieList() {

        if (view == null)
            return;

        if (!ConnectionUtils.isInternetAvailable()) {
            view.showError("No Internet Connection");
            return;
        }

        view.showLoading();

        apiFacade.getApiService().getMovieList().enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                if (view == null)
                    return;
                view.hideLoading();
                MovieList movieData = response.body();
                if (response.isSuccessful() && movieData != null) {
                    Collections.sort(movieData.movies);
                    view.setData(movieData.movies);
                }

            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {

            }
        });
    }
}
