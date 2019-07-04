package com.test.logitech.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.test.logitech.utils.DialogUtils;

public class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void showLoading() {
        DialogUtils.showProgressDialog(this);
    }

    public void hideLoading() {
        DialogUtils.hideProgressDialog();
    }

    public void showError(String errorMessage) {
        DialogUtils.showErrorMessage(this, errorMessage);
    }
}
