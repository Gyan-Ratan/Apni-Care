package com.example.apnicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.apnicare.AllAdapters.ConfirmOrderAdapter;
import com.example.apnicare.AllProducts.OrderBookedActivity;
import com.example.apnicare.ModelResponses.OrderCart.CartBookingResponse;
import com.example.apnicare.YourOrders.YourOrderConfirmedActivity;
import com.example.apnicare.myCart.CartActivity;
import com.example.apnicare.myCart.CartItemAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Confirm_Order_Activity extends AppCompatActivity {
    int order;
    RecyclerView recyclerView;
    Button confirm;
    SharedPrefManager sharedPrefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        recyclerView=findViewById(R.id.recy);
        confirm=findViewById(R.id.confirm_button);
        sharedPrefManager=new SharedPrefManager(this);
        Intent intent=getIntent();
//        int id= Integer.parseInt(intent.getStringExtra("id"));
        order= intent.getIntExtra("order",0);
        confirmOrder();
        confirm.setOnClickListener(view -> {
            Intent intent1 = new Intent(getApplicationContext(), YourOrderConfirmedActivity.class);
            startActivity(intent1);
        });

    }

    private void confirmOrder() {
        Call<CartBookingResponse> call=RetrofitClient.getInstance().getApi().getOrder(order,"Bearer "+sharedPrefManager.getData().getAccessToken());
        call.enqueue(new Callback<CartBookingResponse>() {
            @Override
            public void onResponse(Call<CartBookingResponse> call, Response<CartBookingResponse> response) {
                CartBookingResponse cartBookingResponse=response.body();
                Toast.makeText(Confirm_Order_Activity.this,response.toString(),Toast.LENGTH_SHORT).show();
                if (response.isSuccessful()){

                ConfirmOrderAdapter adapter =new ConfirmOrderAdapter(Confirm_Order_Activity.this,cartBookingResponse.getOrder().getDetail());
                recyclerView.setLayoutManager((new LinearLayoutManager(getApplicationContext())));
                recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<CartBookingResponse> call, Throwable t) {

            }
        });
    }
}