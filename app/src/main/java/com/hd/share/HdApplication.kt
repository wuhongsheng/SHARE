package com.hd.share

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.hd.model.UserModel
import com.tencent.bugly.crashreport.CrashReport
import java.util.*

/**
 * Created by Whs on 2016/12/9 0009
 */
class HdApplication : Application() {
    /** 百度位置监听服务  */
    //public LocationService locationService;

    /** 是否首次定位  */
    internal var isfirstlogin = true

    private var context:Context?=null


    companion  object HdApplication{
        //设备号
        val SBH: String = ""
        //
        val mSharedPreferences: SharedPreferences? = null

        const val USERNAME: String="USERNAME"
        const val PSD: String="PSD"
        const val REMEMBER: String="REMEMBER"

        val usermodel: UserModel? = null


        private val activityList: MutableList<Activity> = ArrayList()

        @JvmField val msharedPreferences: SharedPreferences? = null
        /**
         * 添加已启动的activity
         * @param activity
         */
        @JvmStatic fun addActivity(activity: Activity) {
            activityList.add(activity)
        }
        /**
         * 将list中的activity全部销毁
         */
        @JvmStatic fun exit() {
            for (activity in activityList) {
                activity.finish()
            }
        }

        //fun setUserModel(usermodel: UserModel?):this.usermodel=usermodel


    }

    override fun onCreate() {
        super.onCreate()
        context = this.applicationContext
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

    }

















}
