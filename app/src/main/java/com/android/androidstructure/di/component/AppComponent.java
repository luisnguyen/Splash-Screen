package com.android.androidstructure.di.component;

import com.android.androidstructure.app.MyApplication;
import com.android.androidstructure.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                AppModule.class
        }
)
public interface AppComponent {
    void plus(MyApplication application);
}
