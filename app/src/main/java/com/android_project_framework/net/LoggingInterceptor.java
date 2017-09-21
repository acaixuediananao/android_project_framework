package com.android_project_framework.net;

import android.icu.text.SymbolTable;
import android.util.Log;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by xiaolong.wei on 2017/9/13.
 */

public class LoggingInterceptor implements Interceptor {
    public static final String TAG = "com.android_project_framwork.net.log:";
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long t1 = System.nanoTime();
        Log.v(TAG,String.format("Sending request %s on %s%n%s",request.url(),chain.connection(),request.headers()));

        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        Log.v(TAG,String.format("Received response for %s in %.1fms%n%s",response.request().url(),(t2-t1) / 1e6d,response.headers()));



        return response;
    }
}
