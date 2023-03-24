package com.example.apnicare;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.apnicare.ModelResponses.LoginResponse.Data;




public class SharedPrefManager {

    public static String SHARED_PREF_NAME="thecodingchef";
    private SharedPreferences sharedPreferences;
    Context context;
    private  SharedPreferences.Editor editor;

    public SharedPrefManager(Context context) {
        this.context = context;
    }

    void saveUser(Data data) {
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        editor.putString("accessToken", data.getAccessToken());
        editor.putString("firstName", data.getFirstName());
        editor.putString("lastName",data.getLastName());
        editor.putString("type",data.getType());
        editor.putString("email",data.getEmail());
        editor.putString("phone",data.getPhone());
        editor.putString("gender", data.getGender());
        editor.putBoolean("email_verified", data.getEmailVerified());
        editor.putBoolean("verified", data.getVerified());

        editor.putBoolean("has_password", data.getHasPassword());
        editor.putString("retail", data.getRetail());
        editor.putString("refreshToken", data.getRefreshToken());
        editor.putBoolean("new_user", data.getNewUser());
        editor.putBoolean("logged",true);
        editor.apply();

    }
    void updateUser(com.example.apnicare.ModelResponses.UpdateUser.Data data) {
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        editor.putString("firstName", data.getFirstName());
        editor.putString("lastName",data.getLastName());
        editor.putString("type",data.getType());
        editor.putString("email",data.getEmail());
        editor.putString("phone",data.getPhone());
        editor.putString("gender", data.getGender());
        editor.putBoolean("email_verified", data.getEmailVerified());
        editor.putBoolean("verified", data.getVerified());
        editor.putBoolean("has_password", data.getHasPassword());
        editor.putString("retail", data.getRetail());
        editor.putBoolean("logged",true);
        editor.apply();

    }
    boolean isLoggedIn(){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("logged",false);

    }
    public Data getData(){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return new Data(
                sharedPreferences.getString("accessToken",null),
                sharedPreferences.getString("firstName",""),
                sharedPreferences.getString("lastName",""),
                sharedPreferences.getString("type",null),
                sharedPreferences.getString("email",""),
                sharedPreferences.getString("phone",null),
                sharedPreferences.getString("gender",null),
                sharedPreferences.getBoolean("email_verified",false),
                sharedPreferences.getBoolean("verified",false),
//                sharedPreferences.getString("address",null),
                sharedPreferences.getBoolean("has_password",false),
                sharedPreferences.getString("retail",null),

                sharedPreferences.getString("refreshToken",null),
                sharedPreferences.getBoolean("newUser",false)


                );
    }

    void logOut(){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor= sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }


}
