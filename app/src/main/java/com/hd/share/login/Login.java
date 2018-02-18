package com.hd.share.login;


import com.hd.BaseView;

/**
 * Created by whs on 2017/4/23
 * 登陆界面接口
 */

public interface Login extends BaseView {
     /**
      * 跳转
      */
     void  onNext();


     void  showProgress();
     void  stopProgress();

}
