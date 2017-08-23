package com.song.shop.simple.application;

import android.app.Application;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.song.core.app.SsUtils;
import com.song.ec.icon.EcIcons;
import com.song.ec.icon.FontEcModule;

/**
 * Created by zhaojp on 17-8-16.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SsUtils.init(this)
            .configApiHost("http://127.0.0.1")
            .configIcon(new FontAwesomeModule())
            .configIcon(new FontEcModule())
            .configDone();
    }
}
