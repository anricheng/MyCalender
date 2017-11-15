package com.example;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface ApiInterface {


    @GET
    Observable<LoginResponse> login(@Body LoginRequest request);

    @GET
    Observable<RegisterResponse> register(@Body RegisterRequest request);

}
