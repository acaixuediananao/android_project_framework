package com.android_project_framework.module;

import android.content.Context;

import com.android_project_framework.AndroidApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiaolong.wei on 2017/9/14.
 */
@Module
@Singleton
public class AppModule {
    @Provides
    AndroidApplication provideWApp(Context context){
        return ((AndroidApplication) context.getApplicationContext());
    }
}
