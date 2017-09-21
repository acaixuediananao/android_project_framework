package com.android_project_framework.app;


import com.android_project_framework.AndroidApplication;
import com.android_project_framework.MainActivity;
import com.android_project_framework.module.AppModule;
import com.android_project_framework.module.NetWorkModule;
import com.android_project_framework.module.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by xiaolong.wei on 2017/9/14.
 */

@Singleton
@Component(modules = {ServiceModule.class,AppModule.class, NetWorkModule.class})
public interface ModuleInjector {

    void inject(AndroidApplication androidApplication);

    void inject(MainActivity mainActivity);
}
