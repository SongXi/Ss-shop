package com.song.core.activitys;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;
import com.song.core.R;
import com.song.core.app.SsUtils;
import com.song.core.delegates.SsDelegate;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by ljs on 17-8-17.
 * 仅仅作为一个容器
 */

public abstract class ProxyActivity extends SupportActivity{

  /**
   * 子类实现用来返回根Fragment
   * @return
   */
  public abstract SsDelegate setRootDelegate();


  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //创建一个容器用来存放Fragment
    final ContentFrameLayout frameLayout=new ContentFrameLayout(SsUtils.getApplicationContext());
    //通过资源文件ids让android为我们生成一个没有重复的id
    frameLayout.setId(R.id.deleage_container);
    setContentView(frameLayout);
    if (savedInstanceState==null){
      //第一次夹在这个activity时初始化调用
      loadRootFragment(R.id.deleage_container,setRootDelegate());//通过Fragmentation框架来加载fragment
    }
  }


  @Override
  protected void onDestroy() {
    //由于是单activity应用  所以Activity销毁时代表应用已经退出
    System.gc();
    System.runFinalization();
    super.onDestroy();
  }
}
