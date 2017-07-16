package com.hd.data.remote;

import android.content.Context;
import android.support.annotation.NonNull;

import com.hd.data.DataSource;
import com.hd.data.RemotDataSource;

/**
 * Created by whs on 2017/5/18
 */

public class RemoteDataSource implements DataSource,RemotDataSource {
    private Context mContext;
    private static RemoteDataSource INSTANCE;

    public RemoteDataSource(Context mContext) {
        this.mContext = mContext;

    }

    public static RemoteDataSource getInstance(@NonNull Context context) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource(context);
        }
        return INSTANCE;
    }


}
