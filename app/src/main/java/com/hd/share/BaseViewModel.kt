package com.hd.share

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.hd.data.DataRepository


/**
 * Created by whs on 2017/5/5
 */

class BaseViewModel : BaseObservable() {

    protected var mContext: Context? = null
    protected var mDataRepository: DataRepository? = null
    //数据加载中
    val dataLoading = ObservableBoolean(false)
    //提示信息
    val snackbarText: ObservableField<String> = ObservableField()

    fun getSnackbarText(): String {
        return snackbarText.get()
    }

}
