package com.android_project_framework.net;

import com.android_project_framework.net.ResponseResult;
import com.android_project_framework.bean.ErrorBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by xiaolong.wei on 2017/9/18.
 */

public abstract class ResponseCallBack<T extends ResponseResult> implements Callback<T> {
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        T t = ((T) response.body());
        if (response.raw().code() == 200){
            if (t.isSuccess()){
                onSuccess(t);
            }else {
                if (t.getError() != null && t.getError().size() != 0){
                    onFailure(((ErrorBean) t.getError().get(0)).getMsg());
                }else {
                    onFailure("参数错误");
                }

            }
        }else {
            onNoResponse(response.raw().code() , response.message());
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onFailure(t.getMessage());
    }


    public abstract  void onSuccess(T t);

    public abstract void onFailure(String msg);

    public abstract void onNoResponse(int code , String msg);
}
