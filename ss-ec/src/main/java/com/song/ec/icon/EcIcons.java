package com.song.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by zhaojp on 17-8-16.
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
