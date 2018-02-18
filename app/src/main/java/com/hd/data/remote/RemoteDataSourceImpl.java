package com.hd.data.remote;

import android.content.Context;
import android.support.annotation.NonNull;

import com.hd.data.DataSource;
import com.hd.data.RemotDataSource;

/**
 * Created by whs on 2017/5/18
 */

public class RemoteDataSourceImpl implements DataSource,RemotDataSource {
    private Context mContext;
    private static RemoteDataSourceImpl INSTANCE;

    public RemoteDataSourceImpl(Context mContext) {
        this.mContext = mContext;

    }

    public static RemoteDataSourceImpl getInstance(@NonNull Context context) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSourceImpl(context);
        }
        return INSTANCE;
    }


    public void checkLogin() {

    }
}
