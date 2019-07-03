package com.test.logitech.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.test.logitech.R;
import com.test.logitech.model.entity.Movie;
import com.test.logitech.presenter.HomeScreenPresenterImpl;
import com.test.logitech.presenter.presenterinterface.HomeScreenPresenter;
import com.test.logitech.utils.DialogUtils;
import com.test.logitech.view.viewinterface.HomeScreenView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeScreenView{

    HomeScreenPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new HomeScreenPresenterImpl();
        presenter.attachView(this);
        presenter.getMovieList();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void showLoading() {
        DialogUtils.showProgressDialog(this);
    }

    @Override
    public void hideLoading() {
        DialogUtils.hideProgressDialog();
    }

    @Override
    public void showError(String errorMessage) {
        DialogUtils.showErrorMessage(this, errorMessage);
    }

    @Override
    public void setData(List<Movie> movieList) {

    }
}
