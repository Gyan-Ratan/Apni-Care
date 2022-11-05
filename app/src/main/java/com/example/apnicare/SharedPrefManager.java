package com.example.apnicare;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.apnicare.ModelResponses.Data;

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
        editor.putString("access_token", data.getAccess_token());
        editor.putString("phone", data.getPhone());
        editor.putInt("otp", data.getOtp());
        editor.putString("refresh_token", data.getRefresh_token());
        editor.putBoolean("logged",true);
        editor.apply();

    }
    boolean isLoggedIn(){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("logged",false);

    }
    public Data getData(){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return new Data(sharedPreferences.getString("access_token",null),
                sharedPreferences.getString("phone",null),
                sharedPreferences.getInt("otp",-1),
                sharedPreferences.getString("refresh_token",null));

    }
    void logOut(){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor= sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }


}
