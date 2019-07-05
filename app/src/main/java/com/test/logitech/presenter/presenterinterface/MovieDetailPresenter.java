package com.test.logitech.presenter.presenterinterface;

import com.test.logitech.view.viewinterface.MovieDetailView;

public interface MovieDetailPresenter {

    void attachView(MovieDetailView view);

    void detachView();

    void getData();

    void getActorNames();
}
