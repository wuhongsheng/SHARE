package com.hd.data.remote;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by whs on 2017/2/17
 * Retrofit 接口
 */

public interface RetrofitService {

    //登陆
    @GET("/FireServices.asmx/Login")
    Observable<String> Checklogin(@Query("userName") String username, @Query("passWord") String password, @Query("ClientID") String clientid);

    /**
     * 上传坐标
     * @param sbh 设备号
     * @param lon
     * @param lat
     * @param pointstate 0过程点 1起点 2终点2
     * @param userid 用户ID
     * @return
     */
    @GET("/FireServices.asmx/UPLonLat")
    Observable<String> upLoction(@Query("SBH") String sbh, @Query("LON") String lon, @Query("LAT") String lat, @Query("POINTSTATE") String pointstate, @Query("RANGERID") String userid);

    /**
     * 绑定设备信息
     * @param username
     * @param psd
     * @param sbh
     * @param devicename 设备名称
     * @param xlh  设备序列号
     * @param devicebrand 设备品牌
     * @param phonenum 电话号码
     * @return
     */
    @GET("/FireServices.asmx/BindDevice")
    Observable<String> bindDevice(@Query("userName") String username, @Query("passWord") String psd, @Query("SBH") String sbh, @Query("SBMC") String devicename, @Query("XLH") String xlh, @Query("BRAND") String devicebrand, @Query("SBPHONE") String phonenum);




}
