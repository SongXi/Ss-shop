package com.song.core.app;

import android.content.Context;
import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * 工具类
 */

public class SsUtils {

    // 項目是否初始化的标志位 只能调用一次init方法
    private static boolean isInit = false;
    public static Configurator init(Context context) {
        if (!isInit) {
            getConfigurator().put(ConfigType.APPLICATION_CONTEXT.name(),
                    context.getApplicationContext());
        }
        return Configurator.getInstance();
    }


    private static HashMap<String, Object> getConfigurator() {
        return Configurator.getInstance().getConfigMap();
    }

    public static Context getApplicationContext(){
        return Configurator.getInstance().getConfiguration(ConfigType.APPLICATION_CONTEXT);
    }

}
