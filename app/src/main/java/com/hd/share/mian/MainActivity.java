package com.hd.share.mian;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.hd.share.BaseActivity;
import com.hd.BaseViewModel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by whs on 2018/1/14
 */

public class MainActivity extends BaseActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @NotNull
    @Override
    public Fragment findOrCreateViewFragment() {
        return null;
    }

    @NotNull
    @Override
    public BaseViewModel findOrCreateViewModel() {
        return null;
    }
}
