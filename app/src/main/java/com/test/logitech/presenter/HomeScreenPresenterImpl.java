package com.test.logitech.presenter;

import com.test.logitech.AppInstance;
import com.test.logitech.R;
import com.test.logitech.model.entity.MovieData;
import com.test.logitech.presenter.presenterinterface.HomeScreenPresenter;
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

        if (isNotNetworkAvailable()) {
            view.showError(AppInstance.getInstance().getString(R.string.error_connection));
            return;
        }

        view.showLoading();

        apiFacade.getApiService().getMovieList().enqueue(new Callback<MovieData>() {
            @Override
            public void onResponse(Call<MovieData> call, Response<MovieData> response) {
                if (view == null)
                    return;
                view.hideLoading();
                MovieData movieData = response.body();
                if (response.isSuccessful() && movieData != null) {
                    Collections.sort(movieData.movies);
                    view.setData(movieData.movies);
                }
            }

            @Override
            public void onFailure(Call<MovieData> call, Throwable t) {

            }
        });
    }
}
