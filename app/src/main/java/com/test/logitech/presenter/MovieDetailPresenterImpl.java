package com.test.logitech.presenter;

import com.test.logitech.model.entity.Movie;
import com.test.logitech.presenter.presenterinterface.MovieDetailPresenter;
import com.test.logitech.view.viewinterface.MovieDetailView;

import java.util.Arrays;

public class MovieDetailPresenterImpl extends BasePresenter<MovieDetailView> implements MovieDetailPresenter {

    private Movie movie;

    @Override
    public void getData() {
        if (view == null)
            return;

        movie = view.captureData();
        if (movie != null) {
            view.setData(movie);
            getActorNames();
        }

    }

    @Override
    public void getActorNames() {
        if (movie.actors == null)
            return;

        String [] names = movie.actors.split(",");
        if (view != null)
            view.setNameList(Arrays.asList(names));
    }

}
