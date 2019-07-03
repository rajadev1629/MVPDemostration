package com.test.logitech.presenter;

import com.test.logitech.model.api.ApiFacade;
import com.test.logitech.utils.ConnectionUtils;

public class BasePresenter<T> {

    protected ApiFacade apiFacade;
    protected T view;

    public BasePresenter() {
        this.apiFacade = new ApiFacade();
    }

    public void attachView(T view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

    protected boolean isNotNetworkAvailable() {
        return !ConnectionUtils.isInternetAvailable();
    }

}