package com.example.apnicare;




import com.example.apnicare.ModelResponses.Address.AddressResponse;
import com.example.apnicare.ModelResponses.DeleteAddress.DeleteAddressResponse;
import com.example.apnicare.ModelResponses.EditAddress.EditAddressResponse;
import com.example.apnicare.ModelResponses.LoginResponse;
import com.example.apnicare.ModelResponses.RegisterResponse;
import com.example.apnicare.myCart.AddItemResponse;
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

    @POST("cart/")
    Call<AddItemResponse> additemtocart(@Field("drug_id") String id,@Header("Authorization") String token);

    @GET("user/address/")
    Call<AddressResponse> getData1(@Header("Authorization") String token);

    @FormUrlEncoded
    @POST("user/address/")
    Call<EditAddressResponse> editaddress(@Header("Authorization") String token, @Field("name") String name, @Field("phone") String phone,
                                          @Field("address1")String address1, @Field("address2")String address2, @Field("city")String city,
                                          @Field("state")String state, @Field("pincode")String pincode, @Field("default")boolean defaultaddress);
    @DELETE("user/address/{id}")
    Call<DeleteAddressResponse> deleteaddress(@Path("id") int id,@Header("Authorization") String token);

}
