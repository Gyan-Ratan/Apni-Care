package com.example.apnicare;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;

public class CartPref {
    public static String SHARED_PREF_NAME="CART";
    public String key;
    private SharedPreferences sharedPreferences;
    ArrayList<CartManager> cartManagerArray;
    public CartPref(Context context) {
        this.context = context;
    }
    Boolean flag=true;
    Context context;
    private  SharedPreferences.Editor editor;

    public void saveItem(String Name,int Qty,String slug,Double price){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        checkData();
        for (int i=0;i<cartManagerArray.size();i++){
            Toast.makeText(context, cartManagerArray.get(i).slug+"\n"+slug, Toast.LENGTH_SHORT).show();
            String aa=cartManagerArray.get(i).slug;
            if(aa!=slug.toString()){
//                cartManagerArray.get(i).qty=cartManagerArray.get(i).qty+Qty;
                Toast.makeText(context, cartManagerArray.get(i).slug+"@@11", Toast.LENGTH_SHORT).show();
//                flag=false;
            }
            else {
                Toast.makeText(context, ""+i, Toast.LENGTH_SHORT).show();

            }
        }
        if (flag){
            cartManagerArray.add(new CartManager(Name,Qty,slug,price));


        }
//        cartManagerArray.add(new CartManager(Name,Qty,slug,price));

        Gson gson=new Gson();

        String json= gson.toJson(cartManagerArray);
//        key=Name;

        editor.putString("cart_item",json);
        editor.commit();


    }
    public ArrayList<CartManager> loadData(){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        Gson gson=new Gson();
        String json=sharedPreferences.getString("cart_item",null);
        Type type=new TypeToken<ArrayList<CartManager>>(){

        }.getType();
        cartManagerArray=gson.fromJson(json,type);
        return cartManagerArray=gson.fromJson(json,type);
//        if (cartManagerArray.isEmpty()){
//            tvi.setText("No Data");
//        }
//        else {
//            int a=0;
//            for (a=0;a<cartManagerArray.size();a++){
//                tvi.setText(cartManagerArray.get(a).itemName);
//
//            }
//        }
//

    }
    public void checkData(){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        String json1=sharedPreferences.getString("cart_item",null);
        if (json1==null){
            cartManagerArray=new ArrayList<CartManager>();
        }
        else {
            cartManagerArray=loadData();
        }


    }
    public void clearCart(){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor= sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
