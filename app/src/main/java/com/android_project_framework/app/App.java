package com.android_project_framework.app;

import android.app.Activity;
import com.android_project_framework.AndroidApplication;

/**
 * Created by xiaolong.wei on 2017/9/14.
 */

public class App {

    public static <T extends Activity> ModuleInjector cmpt(T activity){
        return ((AndroidApplication) ((Activity) activity).getApplication()).component();
    }
}
