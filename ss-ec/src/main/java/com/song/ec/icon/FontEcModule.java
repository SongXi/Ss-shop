package com.song.ec.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

/**
 * FontIcon描述类  \
 * 指定ttf文件的地址
 * 并返回所有FontIcon对象
 */

public class FontEcModule implements IconFontDescriptor {

  @Override
  public String ttfFileName() {
    return "iconfont.ttf";
  }

  @Override
  public Icon[] characters() {
    return EcIcons.values();
  }
}
