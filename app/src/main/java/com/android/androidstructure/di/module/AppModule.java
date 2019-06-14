package com.android.androidstructure.di.module;

import android.content.Context;

import com.android.androidstructure.R;
import com.android.androidstructure.app.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private MyApplication mApplication;
    private Context mContext;

    public AppModule(MyApplication application, Context context) {
        this.mApplication = application;
        this.mContext = context;
    }

    @Singleton
    @Provides
    MyApplication provideApplication() {
        return mApplication;
    }

    @Singleton
    @Provides
    Context provideContext() { return mContext; }

    @Singleton
    @Provides
    String provideAppName(Context context) {
        return context.getResources().getString(R.string.app_name);
    }
}
