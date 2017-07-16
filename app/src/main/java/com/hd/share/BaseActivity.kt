package com.hd.share

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hd.util.DeviceUtil

/**
 * Created by whs on 2017/5/17
 * 基础Activity
 */

abstract class BaseActivity : AppCompatActivity() {

    protected var mContext: Context?=null

    /** 日志输出标志  */
    protected val TAG = this.javaClass.simpleName
    /** ViewModel标志  */
    protected val VIEWMODEL_TAG = this.javaClass.simpleName

    protected var mViewModel: BaseViewModel? = null


    protected var mFragment: Fragment? = null


    abstract fun findOrCreateViewFragment(): Fragment
    abstract fun findOrCreateViewModel(): BaseViewModel

    /**
     * [页面跳转]
     * @param clz
     */
    fun startActivity(clz: Class<*>) {
        startActivity(Intent(this@BaseActivity, clz))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        //如果是平板使用横屏模式
        if (DeviceUtil.isTablet(mContext as BaseActivity)) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        } else {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }

    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart()")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()")
    }

}
