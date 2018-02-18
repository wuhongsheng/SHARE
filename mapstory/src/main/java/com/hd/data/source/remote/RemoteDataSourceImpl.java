package com.hd.data.source.remote;

import android.content.Context;

import com.hd.model.UserInfo;

/**
 * Created by whs on 2017/10/12
 */

public class RemoteDataSourceImpl implements RemoteDataSource {
    private  static RemoteDataSourceImpl INSTANCE;

    private Context mContext;

    public RemoteDataSourceImpl(Context context) {
    }

    public static RemoteDataSourceImpl getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSourceImpl(context);
        }
        return INSTANCE;
    }
    @Override
    public void onLogin(UserInfo userInfo, Callback callback) {

    }
}
