package com.hd.share

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.Button


/**
 * Created by Administrator on 2016/11/1.
 * 启动界面
 */

class SplashActivity : AppCompatActivity() {


    //是否首次登陆
    private var firstlogin: Boolean? = false
    private var titansp: SharedPreferences? = null

    //延迟3秒
    private val SPLASH_DELAY_MILLIS: Long = 3000
    //
    val PREFS_NAME = "HdPrefsFile"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)
        titansp = this.getSharedPreferences(PREFS_NAME, 0)
        //跳过
        var jump=findViewById(R.id.btn_jump) as Button
        jump.setOnClickListener {
            val intent = Intent()
            //获取intent对象
            intent.setClass(this,HomeActivity::class.java)
            // 获取class是使用::反射
            startActivity(intent)
        }

        // 使用Handler的postDelayed方法，3秒后执行跳转到MainActivity
        Handler().postDelayed({
            if (firstlogin!!) {
                //goHome()
                val intent = Intent()
                //获取intent对象
                intent.setClass(this,HomeActivity::class.java)
                // 获取class是使用::反射
                startActivity(intent)
            }
        }, SPLASH_DELAY_MILLIS)
    }

}

