package com.footaddict.superstars.footaddict;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

public class MyApplication extends Application {

    public OkHttpClient client;

    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
    }

    public OkHttpClient getClient() {
        return client;
    }
}