package com.hd.mapstory.login;

/**
 * Created by hanyw on 2017/9/13/013.
 * 登录接口
 */

public interface Login {
    //跳转
    void  onNext();
    //是否显示进度
    void  showProgress(boolean islogining);

}
