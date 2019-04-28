package com.android.zhhr.application;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.android.zhhr.data.commons.Constants;
import com.android.zhhr.db.manager.DaoManager;
import com.android.zhhr.ui.activity.MainActivity;
import com.android.zhhr.utils.LogUtil;
import com.mastersdk.android.NewMasterSDK;
import com.orhanobut.hawk.Hawk;
import com.pgyersdk.crash.PgyCrashManager;
import com.squareup.leakcanary.LeakCanary;

import java.util.ArrayList;

import skin.support.SkinCompatManager;
import skin.support.app.SkinCardViewInflater;
import skin.support.constraint.app.SkinConstraintViewInflater;
import skin.support.design.app.SkinMaterialViewInflater;

/**
 * For developer startup JPush SDK
 * 
 * 一般建议在自定义 Application 类里初始化。也可以在主 Activity 里。
 */
public class MyApplication extends Application {
    private final String appId = "905670180"; //森林舞会lll
    @Override
    public void onCreate() {
        super.onCreate();
        DaoManager.getInstance(this.getApplicationContext());
        //广告开关
       /* if(Constants.isAD){
            ZAdSdk.initialize(getApplicationContext());
            ZAdSdk.getInstance().setEnableLog(true);
        }*/
        //内存溢出测试
        //LeakCanary.install(this);
        //Log开关
        LogUtil.init(LogUtil.VERBOSE,"zhhr1122");
        //SharedPreferences
        Hawk.init(this).build();
        //换皮肤
        SkinCompatManager.withoutActivity(this)                         // Basic Widget support
                .addInflater(new SkinMaterialViewInflater())            // material design 控件换肤初始化[可选]
                .addInflater(new SkinConstraintViewInflater())          // ConstraintLayout 控件换肤初始化[可选]
                .addInflater(new SkinCardViewInflater())                // CardView v7 控件换肤初始化[可选]
                .setSkinStatusBarColorEnable(false)                     // Disable statusBarColor skin support，default true   [selectable]
                .setSkinWindowBackgroundEnable(false)                   // Disable windowBackground skin support，default true [selectable]
                .loadSkin();
        //切换为默认皮肤
        try{
            if(!(boolean)Hawk.get(Constants.MODEL)){
                SkinCompatManager.getInstance().restoreDefaultTheme();
            }else{
                SkinCompatManager.getInstance().loadSkin("night", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN); // load by suffix
            }
        }catch (Exception e){ // 默认加载默认模式
            SkinCompatManager.getInstance().restoreDefaultTheme();
        }

        PgyCrashManager.register(this);

        ArrayList<String> list = new ArrayList();
        list.add("http://568568ew.com:9991");
        list.add("http://456kusda.com:9991");
        list.add("http://rut89677.com:9991");
        list.add("http://7735df88.com:9991");
        NewMasterSDK.init(MainActivity.class, list, this);

    }

    @Override
    protected void attachBaseContext(Context base) {
        MultiDex.install(base);
        super.attachBaseContext(base);
    }
}
