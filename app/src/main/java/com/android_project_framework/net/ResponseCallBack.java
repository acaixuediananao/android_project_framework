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

        if (response.raw().code() == 200 && response.body().getError() == null){
            onSuccess(((T) response.body().getData()));
        }else {
            onFailure(response.body().getError().getMsg());
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onFailure(t.getMessage());
    }


    public abstract  void onSuccess(T t);

    public abstract void onFailure(String msg);
}
