package com.song.shop.simple.application;

import android.app.Application;
import com.song.core.app.Latte;

/**
 * Created by zhaojp on 17-8-16.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this).configApiHost("http://127.0.0.1").configDone();
    }
}
