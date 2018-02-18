package com.hd.data.source;

import android.content.Context;

import com.hd.data.source.remote.RemoteDataSource;
import com.hd.data.source.remote.RemoteDataSourceImpl;
import com.hd.model.UserInfo;

/**
 * Created by whs on 2017/5/18
 * 数据访问层
 */

public class DataRepository implements RemoteDataSource {
    private Context mContext;

    private static DataRepository INSTANCE = null;
    //
    private final RemoteDataSourceImpl mLocalDataSource;

    public static DataRepository getInstance(RemoteDataSourceImpl remoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new DataRepository(remoteDataSource);
        }
        return INSTANCE;
    }

    public DataRepository(RemoteDataSourceImpl remoteDataSource) {
        this.mLocalDataSource = remoteDataSource;
    }


    @Override
    public void onLogin(UserInfo userInfo, Callback callback) {

    }
}
