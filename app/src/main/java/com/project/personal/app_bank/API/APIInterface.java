package com.project.personal.app_bank.API;

import com.project.personal.app_bank.models.LoginRequest;
import com.project.personal.app_bank.models.User;
import com.project.personal.app_bank.models.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface {
//    @FormUrlEncoded
//    @POST("/login")   //endpoint with
//
//    Call<User> login(
//            @Field("user") String email,
//            @Field("password") String password
//    );

    @POST("login")
    Call<UserResponse> createPost(@Body LoginRequest loginRequest);
}
