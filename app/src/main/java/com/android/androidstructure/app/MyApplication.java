package com.android.androidstructure.app;

import android.app.Application;
import android.content.Context;

import com.android.androidstructure.R;
import com.android.androidstructure.helper.FontsOverride;

public class MyApplication extends Application {

    public static final String TAG = MyApplication.class.getSimpleName();

    private static MyApplication sAppInstance;
    private Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sAppInstance = this;
        mContext = getApplicationContext();
        setFonts();
    }

    private void setFonts() {
        FontsOverride.establishFonts(mContext,
                mContext.getResources().getStringArray(R.array.fontsdefault)[1],
                "fonts/ProximaNova-Regular.ttf");
    }

    public static synchronized MyApplication getInstance() {
        if (sAppInstance == null) {
            sAppInstance = new MyApplication();
        }
        return sAppInstance;
    }
}
