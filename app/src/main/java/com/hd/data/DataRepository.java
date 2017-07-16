package com.hd.data;

import android.content.Context;

import com.hd.data.local.LocalDataSource;
import com.hd.data.remote.RemoteDataSource;


/**
 * Created by whs on 2017/5/18
 */

public class DataRepository implements DataSource ,RemotDataSource{
    private Context mContext;

    private static DataRepository INSTANCE = null;


    private final RemoteDataSource mRemoteDataSource;

    private final LocalDataSource mLocalDataSource;

    public static DataRepository getInstance(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new DataRepository(remoteDataSource, localDataSource);
        }
        return INSTANCE;
    }

    public DataRepository(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        //this.mContext=context;
        this.mRemoteDataSource = remoteDataSource;
        this.mLocalDataSource = localDataSource;
    }




}
