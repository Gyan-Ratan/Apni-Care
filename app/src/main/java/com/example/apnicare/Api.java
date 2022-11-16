package com.example.apnicare;




import com.example.apnicare.ModelResponses.LoginResponse;
import com.example.apnicare.ModelResponses.RegisterResponse;
import com.example.apnicare.myCart.CartItemDeleteResponse;
import com.example.apnicare.myCart.CartResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {
    @FormUrlEncoded
    @POST("auth/otp_login")
    Call<RegisterResponse> register(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("auth/verify")
    Call<LoginResponse> login(@Field("phone") String phone, @Field("otp") int otp);

    @GET("cart/")
    Call<CartResponse> getData(@Header("Authorization") String token);


    @DELETE("/cart/{id}")
    Call<CartItemDeleteResponse> getData(@Path("id") int id,@Header("Authorization") String token);
}
