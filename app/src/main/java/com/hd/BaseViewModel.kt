package com.hd

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.hd.data.DataRepository


/**
 * Created by whs on 2017/5/5
 */

open class BaseViewModel : BaseObservable() {

    var mContext: Context? = null
    var mDataRepository: DataRepository? = null
    //数据加载中
    val dataLoading = ObservableBoolean(false)
    //提示信息
    val snackbarText: ObservableField<String> = ObservableField()

    fun getSnackbarText(): String {
        return snackbarText.get()
    }

}
