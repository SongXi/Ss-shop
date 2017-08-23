package com.song.shop.simple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.song.core.activitys.ProxyActivity;
import com.song.core.app.SsUtils;
import com.song.core.delegates.SsDelegate;
import com.song.shop.simple.delegates.MainDelagate;

public class MainActivity extends ProxyActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public SsDelegate setRootDelegate() {
    return new MainDelagate();
  }
}
