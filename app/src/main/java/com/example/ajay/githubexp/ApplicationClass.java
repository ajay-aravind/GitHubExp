package com.example.ajay.githubexp;

import android.app.Application;
import android.content.res.Configuration;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by ajay on 30/8/17.
 */

public class ApplicationClass extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.d("just registered logger");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Logger.d("Ping...");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Logger.d("Ping...");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Logger.d("Ping...");
    }
}
