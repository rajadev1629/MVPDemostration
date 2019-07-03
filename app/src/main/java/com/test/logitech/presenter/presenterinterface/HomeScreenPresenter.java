package com.test.logitech.presenter.presenterinterface;

import com.test.logitech.view.viewinterface.HomeScreenView;

public interface HomeScreenPresenter {

    void attachView(HomeScreenView view);

    void detachView();

    void getMovieList();
}
