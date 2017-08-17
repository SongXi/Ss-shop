package com.song.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 *  自定义FontIcon类
 */
public enum  EcIcons implements Icon {
  icon_scan('\ue649'),
  icon_ali_pay('\ue67c');



  private char aChar;

  EcIcons(char charact){
    aChar=charact;
  }
  public String key() {
    return this.name().replace('_', '-');
  }

  @Override
  public char character() {
    return aChar;
  }

}
