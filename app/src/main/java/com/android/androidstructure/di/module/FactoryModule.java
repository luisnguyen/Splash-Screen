package com.android.androidstructure.di.module;

import android.app.Application;
import android.content.Context;

import com.android.androidstructure.BuildConfig;
import com.android.androidstructure.app.MyApplication;
import com.android.androidstructure.service.connect.ApiService;
import com.android.androidstructure.service.connect.TrustHtppS;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class FactoryModule {

    private MyApplication mApplication;
    private Context mContext;

    public FactoryModule(MyApplication application, Context context) {
        mApplication = application;
        mContext = context;
    }

    @Singleton
    @Provides
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor();
    }

    @Singleton
    @Provides
    @Named("ok-1")
    OkHttpClient.Builder provideOkHttpClient1(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);
    }

    @Singleton
    @Provides
    @Named("ok-2")
    OkHttpClient.Builder provideOkHttpClient2(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);
    }

    @Singleton
    @Provides
    TrustHtppS provideTrustHtppS(@Named("ok-1") OkHttpClient.Builder client) {
        return new TrustHtppS(client);
    }

    @Singleton
    @Provides
    String provideBaseURL() {
        return BuildConfig.BASE_URL;
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit1(TrustHtppS trustHtppS, @Named("ok-1") OkHttpClient.Builder client, String baseUrl) {
        trustHtppS.intializeCertificate();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    ApiService provideVogoApiService1(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
