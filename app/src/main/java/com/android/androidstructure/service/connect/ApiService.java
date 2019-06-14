package com.android.androidstructure.service.connect;

import com.android.androidstructure.service.pojo.POJOConfigure;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/v1/application/mobile-app/configure")
    Observable<Response<POJOConfigure>> incomingConfigure();
}
