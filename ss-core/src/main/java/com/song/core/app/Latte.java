package com.song.core.app;

import android.content.Context;
import java.util.WeakHashMap;

/**
 *
 * 工具类
 */

public class Latte {

   public static Configurator init(Context context){
     getConfigurator().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
     return Configurator.getInstance();

   }

  private static WeakHashMap<String,Object> getConfigurator(){
    return Configurator.getInstance().getConfigMap();
  }

}
