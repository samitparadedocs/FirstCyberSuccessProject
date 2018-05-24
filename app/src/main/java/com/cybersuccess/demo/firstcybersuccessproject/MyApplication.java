package com.cybersuccess.demo.firstcybersuccessproject;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Samit on 5/23/2018.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
