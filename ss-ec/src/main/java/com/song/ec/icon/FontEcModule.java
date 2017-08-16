package com.song.ec.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

/**
 * Created by zhaojp on 17-8-16.
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
