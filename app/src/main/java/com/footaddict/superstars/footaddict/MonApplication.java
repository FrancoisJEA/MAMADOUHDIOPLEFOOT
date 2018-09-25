package com.footaddict.superstars.footaddict;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class MonApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
