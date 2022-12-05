package com.example.apnicare;




import com.example.apnicare.ModelResponses.Address.AddressResponse;
import com.example.apnicare.ModelResponses.CategoryResponse.CategoryResponse;
import com.example.apnicare.ModelResponses.ContactUs.ContactResponse;
import com.example.apnicare.ModelResponses.DeleteAddress.DeleteAddressResponse;
import com.example.apnicare.ModelResponses.EditAddress.EditAddressResponse;
import com.example.apnicare.ModelResponses.LoginResponse;
import com.example.apnicare.ModelResponses.OrderCart.CartBookingResponse;
import com.example.apnicare.ModelResponses.RegisterResponse;
import com.example.apnicare.ModelResponses.ResendOtp.ResendOtp;
import com.example.apnicare.ModelResponses.Search.SearchResponse;
import com.example.apnicare.myCart.AddItemResponse;
import com.example.apnicare.myCart.CartItemDeleteResponse;
import com.example.apnicare.myCart.CartResponse;

import java.lang.reflect.Array;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    @FormUrlEncoded
    @POST("auth/otp_login")
    Call<RegisterResponse> register(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("auth/verify")
    Call<LoginResponse> login(@Field("phone") String phone, @Field("otp") int otp);

    @FormUrlEncoded
    @POST("auth/resend_otp")
    Call<ResendOtp> resend(@Field("phone") String phone);

    @GET("cart/")
    Call<CartResponse> getData(@Header("Authorization") String token);


    @DELETE("/cart/{id}")
    Call<CartItemDeleteResponse> getData(@Path("id") int id,@Header("Authorization") String token);

    @FormUrlEncoded
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

    @GET("drug/")
    Call<SearchResponse> search(@Query("page") int no, @Query("search") String search_item,@Query("category_id") String category,@Header("authorization") String token);

    @FormUrlEncoded
    @POST("order/")
    Call<CartBookingResponse> book(@Field("order_mode")String mode,@Field("order_type")String type,@Header("Authorization") String token);

    @GET("drug/category")
    Call<CategoryResponse> getdata();

    @FormUrlEncoded
    @POST("contact/")
    Call<ContactResponse> contact(@Field("first_name") String first_name, @Field("last_name") String last_name, @Field("email") String email, @Field("phone") String phone, @Field("subject") String subject, @Field("message") String message);



}
