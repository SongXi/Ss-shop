package com.song.core.delegates;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by ljs on 17-8-17.
 * 所有fragment的父类   封装了填充布局以及bindview的操作.
 */

public abstract class BaseDelegate extends SupportFragment {

    // 子类复写 设置view
    public abstract Object setLayout();

    // 用于绑定view
    public abstract void onBindView(@Nullable Bundle savedInstanceState, View viewRoot);

    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View rootView = null;
        Object layout = setLayout();
        if (layout instanceof Integer) {
            rootView = inflater.inflate((Integer) layout, container, false);
        } else if (layout instanceof View) {
            rootView = (View) layout;
        }
        if (rootView != null) {
            bind = ButterKnife.bind(this, rootView);
            onBindView(savedInstanceState, rootView);
        }

        return rootView;
    }



    @Override
    public void onDestroyView() {
        //解除帮顶
        if (bind!=null){
            bind.unbind();
        }
        super.onDestroyView();
    }
}
