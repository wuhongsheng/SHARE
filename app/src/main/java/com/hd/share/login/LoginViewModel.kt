package com.hd.share.login

/**
 * Created by Whs on 2016/12/1 0001
 */

import android.content.Context
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.text.TextUtils
import android.util.Log

import com.google.gson.Gson
import com.hd.data.DataRepository
import com.hd.model.UserModel
import com.hd.BaseViewModel
import com.hd.share.HdApplication
import com.hd.share.R
import com.hd.util.NetUtil

class LoginViewModel(context: Context, private val mLogin: Login, dataRepository: DataRepository) : BaseViewModel() {
    //用户名
    var username = ObservableField<String>()
    //密码
    var password = ObservableField<String>()
    //是否记住用户
    var isremember = ObservableBoolean(true)

    init {
        this.mContext = context
        this.mDataRepository = dataRepository
    }

    /**
     * 登录
     */
    fun onLongin() {
        if (NetUtil.onNetChange(mContext)) {
            /* username.set("admin");
            password.set("admin");*/
            if (checkEmpty()) {
                mLogin.showToast(1, mContext!!.getString(R.string.error_loginempty))
                return
            }
            mLogin.showProgress()
            //个推ClientId
            //String cid= PushManager.getInstance().getClientid(mContext);
            val cid = HdApplication.SBH
            //HdApplication.setmUserModel(new Gson().fromJson(data,UserModel.class));
            if (isremember.get()) {
                HdApplication.mSharedPreferences!!.edit().putString(HdApplication.USERNAME, username.get()).apply()
                HdApplication.mSharedPreferences.edit().putString(HdApplication.PSD, password.get()).apply()
            }
            //mLogin.onNext();

            mDataRepository!!.checkLogin(username.get().trim { it <= ' ' }, password.get().trim { it <= ' ' }, cid){
                fun onFailure(info: String) {
                    mLogin.stopProgress()
                    Log.e("login", "登录异常" + info)
                    mLogin.showToast(1, "登陆异常：" + info)
                }

                fun onSuccess(data: String) {
                    mLogin.stopProgress()
                    Log.e("login", "登录成功")
                    //String user=new Gson().toJson(data);
                    //HdApplication.mUserModel=new Gson().fromJson(user,UserModel.class);
                    HdApplication.setUserModel(Gson().fromJson(data, UserModel::class.java))
                    Log.e("userinfo", HdApplication.userModel.toString())
                    //mLogin.showToast("登陆成功"+is,0);
                    if (isremember.get()) {
                        HdApplication.mSharedPreferences.edit().putString(HdApplication.USERNAME, username.get()).apply()
                        HdApplication.mSharedPreferences.edit().putString(HdApplication.PSD, password.get()).apply()
                    }
                    //
                    //bindDevice()
                    //snackbarText.set("登陆成功");
                    //mLogin.onNext();

                }
            })

        } else {
            mLogin.showToast(1, mContext!!.getResources().getString(R.string.error_network))
        }
    }

    /**
     * 记住用户
     */
    fun onCheckRemember() {
        if (checkEmpty()) {
            isremember.set(!isremember.get())
            Log.e("TItan", mContext!!.getString(R.string.error_loginempty))
            mLogin.showToast(1, mContext!!.getString(R.string.error_loginempty))
            //snackbarText.set(mContext.getString(R.string.error_loginempty));
            return
        }
        if (isremember.get()) {
            //mLogin.showToast("用户已记住", 1);
            snackbarText.set("用户已记住")
            isremember.set(true)

        } else {
            snackbarText.set("记住用户已取消")
            //mLogin.showToast("记住用户已取消", 1);
            isremember.set(false)
        }
        HdApplication.mSharedPreferences!!.edit().putBoolean(HdApplication.REMEMBER, isremember.get()).apply()

    }


    /**
     * 初始化
     */
    fun onStart() {
        isremember.set(HdApplication.mSharedPreferences.getBoolean(HdApplication.KEYNAME_REMEMBER, false))
        if (isremember.get()) {
            username.set(HdApplication.mSharedPreferences.getString(HdApplication.KEYNAME_USERNAME, ""))
            password.set(HdApplication.mSharedPreferences.getString(HdApplication.KEYNAME_PSD, ""))
        }
    }



    /**
     * 检查提交内容是否为空
     * @return
     */
    private fun checkEmpty(): Boolean {
        return TextUtils.isEmpty(username.get()) || TextUtils.isEmpty(password.get())
    }

}
