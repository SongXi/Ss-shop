package com.song.shop.simple.delegates;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.song.core.app.SsUtils;
import com.song.core.delegates.SsDelegate;
import com.song.shop.simple.R;

/**
 * Created by zhaojp on 17-8-17.
 */

public class MainDelagate extends SsDelegate {

  @Override
  public Object setLayout() {
    return R.layout.delegate_main;
  }

  @Override
  public void onBindView(@Nullable Bundle savedInstanceState, View viewRoot) {

  }
}
