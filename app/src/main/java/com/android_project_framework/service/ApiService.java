package com.android_project_framework.service;

import com.android_project_framework.bean.DataBean;
import com.android_project_framework.net.ResponseResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by xiaolong.wei on 2017/9/13.
 */

public interface ApiService {

    @GET("account/membership/exchange")
    Call<ResponseResult<DataBean>> getData(@Header("t") String t);
}
