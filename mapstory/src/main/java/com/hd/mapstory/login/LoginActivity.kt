package com.hd.mapstory.login

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatDelegate
import com.hd.mapstory.BaseActivity
import com.hd.mapstory.R
import com.hd.util.ActivityUtils
import com.hd.util.ViewModelHolder

@SuppressLint("Registered")
/**
 * Created by hanyw on 2017/9/13/013.
 * 登录
 */

class LoginActivity : BaseActivity() {

    private var mViewModel: LoginViewModel? = null
    private var mFragment: LoginFragment? = null

    companion object {
        val LOGIN_VIEWMODEL_TAG = "LOGIN_VIEWMODEL_TAG"
        //矢量支持
        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        setContentView(R.layout.activity_login)
        mFragment = findOrCreateViewFragment()
        mViewModel = findOrCreateViewModel()
        mFragment!!.setViewModel(mViewModel)


    }

    override fun findOrCreateViewFragment(): LoginFragment {
        var fragment: LoginFragment? = supportFragmentManager.findFragmentById(R.id.content_frame) as LoginFragment
        if (fragment == null) {
            fragment = LoginFragment.newInstance()
            ActivityUtils.addFragmentToActivity(supportFragmentManager, fragment, R.id.content_frame)
        }
        return fragment!!
    }

    override fun findOrCreateViewModel(): LoginViewModel {
        val holder = supportFragmentManager
                .findFragmentByTag(LOGIN_VIEWMODEL_TAG) as ViewModelHolder<*>
        if (holder.viewmodel == null) {
            val viewModel = LoginViewModel(mContext, mFragment)
            ActivityUtils.addFragmentToActivity(supportFragmentManager, ViewModelHolder.createContainer(viewModel), LOGIN_VIEWMODEL_TAG)
            return viewModel
        }
        return holder.getViewmodel() as LoginViewModel
    }


}
