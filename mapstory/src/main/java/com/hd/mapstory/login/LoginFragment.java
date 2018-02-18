package com.hd.mapstory.login;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hd.mapstory.databinding.FragLoginBinding;


/**
 * Created by hanyw on 2017/9/13/013.
 * 用户登录
 */

public class LoginFragment extends Fragment implements Login {
    private Context mContext;
    private FragLoginBinding mbinding;
    private LoginViewModel loginViewModel;
    private static LoginFragment singleton;

    public static LoginFragment newInstance(){
        if (singleton==null){
            singleton = new LoginFragment();
        }
        return singleton;
    }

    public void setViewModel(LoginViewModel viewModel){
        loginViewModel = viewModel;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mbinding = FragLoginBinding.inflate(inflater,container,false);
        mbinding.setViewmodel(loginViewModel);
        return mbinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        loginViewModel.initData();
    }

    @Override
    public void onNext() {
        /*Intent intent = new Intent(mContext, FunctionChoiceActivity.class);
        startActivity(intent);*/
    }

    @Override
    public void showProgress(boolean islogining) {

    }



}
