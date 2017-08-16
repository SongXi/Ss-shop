package com.song.core.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.Iconify.IconifyInitializer;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/**
 * Created by ljs on 17-8-16. 用来进行配置文件的存储以及获取的
 */
public final class Configurator {

    private static final WeakHashMap<String, Object> SS_CONFIGS = new WeakHashMap<>();
    private static final List<IconFontDescriptor> ICON_FONT_LIST=new ArrayList<>();
    private Configurator() {
        // 配置剛開始
        SS_CONFIGS.put(ConfigType.CONFIG_READ.name(), false);
    }

    public static Configurator getInstance() {
        return ConfiguratorHolder.INSTANCE;
    }

    // 通过静态内部类的方式来实现单例
    private static class ConfiguratorHolder {
        public static final Configurator INSTANCE = new Configurator();
    }

    final WeakHashMap<String,Object> getConfigMap() {
        return SS_CONFIGS;
    }


    // 初始化完成后调用
    public void configDone() {
        initIcon();
        SS_CONFIGS.put(ConfigType.CONFIG_READ.name(), true);
    }

    // 配置apihost
    public Configurator configApiHost(String apiHost) {
        SS_CONFIGS.put(ConfigType.API_HOST.name(), apiHost);
        return this;
    }

    // 在获取参数的时候先验证参数是否配置完毕
    // 如果没有配置完毕则throw异常
    private final void checkConfigFinal() {
        boolean configFinal = (boolean) SS_CONFIGS.get(ConfigType.CONFIG_READ.name());
        if (!configFinal) {
            throw new RuntimeException("config 未初始化完毕");
        }
    }

  //获取配置的参数
  @SuppressWarnings("unchecked")
  public final<T> T getConfiguration(ConfigType key){
    checkConfigFinal();
    return (T) SS_CONFIGS.get(key.name());
  }

    //对外提供的方法 用于设置Iconify
    public Configurator configIcon(IconFontDescriptor iconFontDescriptor){
        ICON_FONT_LIST.add(iconFontDescriptor);
        return this;
    }

    //初始化时调用.用来初始化Iconity
    private void initIcon(){
        if (ICON_FONT_LIST.isEmpty()){
            IconifyInitializer with = Iconify.with(ICON_FONT_LIST.get(0));
            for (int i=1;i<ICON_FONT_LIST.size();i++){
                with.with(ICON_FONT_LIST.get(i));
            }
        }
    }

}
