package com.test.logitech;

import android.app.Application;

public class AppInstance extends Application {

    private static AppInstance instance;

    public static AppInstance getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
