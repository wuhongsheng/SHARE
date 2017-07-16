package com.hd.share

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.tencent.bugly.crashreport.CrashReport

/**
 * Created by Whs on 2016/12/9 0009
 */
class HdApplication : Application() {
    /** 百度位置监听服务  */
    //public LocationService locationService;
    var sharedPreferences: SharedPreferences? = null
    /** 是否首次定位  */
    internal var isfirstlogin = true

    private var context:Context?=null

    private var singleton:HdApplication? =null
    override fun onCreate() {
        super.onCreate()
        context = this.applicationContext
        singleton = this
        /** Bugly SDK初始化
         * 参数1：上下文对象
         * 参数2：APPID，平台注册时得到,注意替换成你的appId
         * 参数3：是否开启调试模式，调试模式下会输出'CrashReport'tag的日志
         * 发布新版本时需要修改以及bugly isbug需要改成false等部分
         */
        CrashReport.initCrashReport(applicationContext, "2178a7e1ce", false)
        /** 百度定位初始化  */
        /*locationService = new LocationService(getApplicationContext());
        //mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
        SDKInitializer.initialize(getApplicationContext());*/
        //intiData();
        //mSharedPreferences = getSharedPreferences(PREFS_NAME, 0)
        /** 获取当前网络状态  */
        netState

    }


    /**
     * 初始化数据
     */
    private fun intiData() {

        // 用户信息存储
        sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE)

    }





    /**
     * 获取网络状态
     * @return
     */
    val netState: Boolean
        get() {
            /*if (NetUtil.getNetworkState(this) === NetUtil.NETWORN_NONE) {
                IntetnetISVisible = false
            } else {
                IntetnetISVisible = true
            }
            return IntetnetISVisible*/
            return true
        }






}
