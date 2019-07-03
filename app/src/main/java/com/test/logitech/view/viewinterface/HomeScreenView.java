package com.test.logitech.view.viewinterface;

import com.test.logitech.model.entity.Movie;

import java.util.List;

public interface HomeScreenView {

    void showLoading();

    void hideLoading();

    void showError(String errorMessage);

    void setData(List<Movie> movieList);
}
