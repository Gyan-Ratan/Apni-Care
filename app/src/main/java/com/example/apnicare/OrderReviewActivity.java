package com.example.apnicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apnicare.AllAdapters.ConfirmOrderAdapter;
import com.example.apnicare.AllProducts.SelectAddressActivity;
import com.example.apnicare.ModelResponses.ComfirmOrder.ConfirmResponse;
import com.example.apnicare.ModelResponses.OrderCart.CartBookingResponse;
import com.example.apnicare.YourOrders.YourOrderConfirmedActivity;
import com.example.apnicare.myCart.AddItemResponse;
import com.example.apnicare.myCart.CartActivity;
import com.example.apnicare.myCart.CartItemAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderReviewActivity extends AppCompatActivity {
    int order;
    RecyclerView recyclerView;
    TextView abc;
    Button confirm;
    SharedPrefManager sharedPrefManager;
    CartPref cartPref;
    ArrayList<CartManager> cartManagerArrayList;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        recyclerView=findViewById(R.id.recy);
        confirm=findViewById(R.id.confirm_button);
        sharedPrefManager=new SharedPrefManager(this);
        cartPref=new CartPref(this);
        abc=findViewById(R.id.abc);
        Intent intent=getIntent();
        id= intent.getIntExtra("id",0);
//        order= intent.getIntExtra("order",0);
//        confirmOrder();

        showConfirmItems();

        confirm.setOnClickListener(view -> {
                Toast.makeText(OrderReviewActivity.this,""+id,Toast.LENGTH_SHORT).show();

//            placeconfirm();
            for (int i =0;i<cartManagerArrayList.size();i++){
                addtocart(cartManagerArrayList.get(i).slug,cartManagerArrayList.get(i).qty);
            }
            Initiateorder();
//            placeconfirm();


        });

    }

    private void showConfirmItems() {
        cartManagerArrayList=cartPref.loadData();
        if (cartManagerArrayList==null || cartManagerArrayList.isEmpty()){
            abc.setText("No data");
        }
        else {
            abc.setText("");
            int a=0;
            ConfirmOrderAdapter adapter =new ConfirmOrderAdapter(OrderReviewActivity.this,cartPref.loadData());
            recyclerView.setLayoutManager((new LinearLayoutManager(getApplicationContext())));
            recyclerView.setAdapter(adapter);

        }

    }

    private void placeconfirm() {
        Call<ConfirmResponse> call=RetrofitClient.getInstance().getApi().getconfirm(order,"Bearer "+sharedPrefManager.getData().getAccessToken(),id,id);
        call.enqueue(new Callback<ConfirmResponse>() {
            @Override
            public void onResponse(Call<ConfirmResponse> call, Response<ConfirmResponse> response) {
                ConfirmResponse confirmResponse=response.body();
                Toast.makeText(OrderReviewActivity.this,response.toString(),Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()){
//                    Toast.makeText(OrderReviewActivity.this,id,Toast.LENGTH_SHORT).show();
                    cartPref.clearCart();
                    Intent intent1 = new Intent(getApplicationContext(),YourOrderConfirmedActivity.class);
//                    placeconfirm();
                    startActivity(intent1);
                }
                else{
                    Toast.makeText(OrderReviewActivity.this,"Please Contact Admin",Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<ConfirmResponse> call, Throwable t) {
                Toast.makeText(OrderReviewActivity.this,"faulure",Toast.LENGTH_SHORT).show();

            }
        });
    }

//    private void confirmOrder() {
//        Call<CartBookingResponse> call=RetrofitClient.getInstance().getApi().getOrder(order,"Bearer "+sharedPrefManager.getData().getAccessToken());
//        call.enqueue(new Callback<CartBookingResponse>() {
//            @Override
//            public void onResponse(Call<CartBookingResponse> call, Response<CartBookingResponse> response) {
//                CartBookingResponse cartBookingResponse=response.body();
//                Toast.makeText(OrderReviewActivity.this,response.toString(),Toast.LENGTH_SHORT).show();
//                if (response.isSuccessful()){
//
//                ConfirmOrderAdapter adapter =new ConfirmOrderAdapter(OrderReviewActivity.this,cartBookingResponse.getOrder().getDetail());
//                recyclerView.setLayoutManager((new LinearLayoutManager(getApplicationContext())));
//                recyclerView.setAdapter(adapter);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<CartBookingResponse> call, Throwable t) {
//
//            }
//        });
//    }

    private void addtocart(String id,int qty) {
        Call<AddItemResponse> call= RetrofitClient.getInstance().getApi().additemtocart(id,qty,"Bearer "+sharedPrefManager.getData().getAccessToken());
        call.enqueue(new Callback<AddItemResponse>() {
            @Override
            public void onResponse(Call<AddItemResponse> call, Response<AddItemResponse> response) {
//                Toast.makeText(context,response.toString(),Toast.LENGTH_SHORT).show();
                if (response.isSuccessful()){
//                    Toast.makeText(OrderReviewActivity.this,"item added to cart",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AddItemResponse> call, Throwable t) {

            }
        });

    }// function to make api call

    private void Initiateorder() {
//        Toast.makeText(getContext(),"function",Toast.LENGTH_SHORT).show();

        Call<CartBookingResponse> call=RetrofitClient.getInstance().getApi().book("cart","customer","Bearer "+sharedPrefManager.getData().getAccessToken());
        call.enqueue(new Callback<CartBookingResponse>() {
            @Override
            public void onResponse(Call<CartBookingResponse> call, Response<CartBookingResponse> response) {
//                        Toast.makeText(CartActivity.this,response.toString(),Toast.LENGTH_SHORT).show();
                CartBookingResponse cartBookingResponse=response.body();
                if (response.isSuccessful()){
                    Toast.makeText(OrderReviewActivity.this,"order Initited",Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(getApplicationContext(), SelectAddressActivity.class);
//                    intent.putExtra("order_id",cartBookingResponse.getOrder().getId());
                    order=cartBookingResponse.getOrder().getId();
//                    startActivity(intent);
                    placeconfirm();

                }
            }
            @Override
            public void onFailure(Call<CartBookingResponse> call, Throwable t) {
                Toast.makeText(OrderReviewActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}