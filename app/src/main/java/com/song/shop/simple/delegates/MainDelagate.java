package com.song.shop.simple.delegates;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import com.song.core.app.SsUtils;
import com.song.core.delegates.SsDelegate;

/**
 * Created by zhaojp on 17-8-17.
 */

public class MainDelagate extends SsDelegate {

  @Override
  public Object setLayout() {
    TextView textView = new TextView(SsUtils.getApplicationContext());
    textView.setText("asdasdasd");
    return textView;
  }

  @Override
  public void onBindView(@Nullable Bundle savedInstanceState, View viewRoot) {

  }
}
