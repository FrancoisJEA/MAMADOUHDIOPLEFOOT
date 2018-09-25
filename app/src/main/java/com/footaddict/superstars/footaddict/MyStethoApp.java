package com.footaddict.superstars.footaddict;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class MyStethoApp extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}