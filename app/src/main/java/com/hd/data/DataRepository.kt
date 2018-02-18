package com.hd.data

import android.content.Context
import com.hd.data.local.LocalDataSource
import com.hd.data.remote.RemoteDataSourceImpl


/**
 * Created by whs on 2017/5/18
 */

class DataRepository(private val mRemoteDataSource: RemoteDataSourceImpl, private val mLocalDataSource: LocalDataSource)//this.mContext=context;
    : DataSource, RemotDataSource {
    private val mContext: Context? = null


    fun checkLogin(trim: String, trim1: String, cid: String, callback: (Any)->Unit) {
        mRemoteDataSource.checkLogin()

    }

    companion object {

        private var INSTANCE: DataRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSourceImpl, localDataSource: LocalDataSource): DataRepository {
            if (INSTANCE == null) {
                INSTANCE = DataRepository(remoteDataSource, localDataSource)
            }
            return INSTANCE as DataRepository
        }
    }
}
