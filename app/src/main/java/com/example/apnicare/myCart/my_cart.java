package com.example.apnicare.myCart;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.apnicare.AllProducts.OrderBookedActivity;
import com.example.apnicare.ModelResponses.OrderCart.CartBookingResponse;
import com.example.apnicare.R;
import com.example.apnicare.RetrofitClient;
import com.example.apnicare.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class my_cart extends Fragment {
    SharedPrefManager sharedPrefManager;
    RecyclerView recyclerView;
    Button proceed;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_my_cart, container, false);
        sharedPrefManager=new SharedPrefManager(getContext());
        recyclerView=view.findViewById(R.id.mycartrecycleview);
        proceed=view.findViewById(R.id.proceedtopay);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mycartproducts();
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bookorder();
            }
        });
        
        return view;
    }

    private void bookorder() {
//        Toast.makeText(getContext(),"function",Toast.LENGTH_SHORT).show();

        Call<CartBookingResponse> call=RetrofitClient.getInstance().getApi().book("cart","customer","Bearer "+sharedPrefManager.getData().getAccess_token());
        call.enqueue(new Callback<CartBookingResponse>() {
            @Override
            public void onResponse(Call<CartBookingResponse> call, Response<CartBookingResponse> response) {
                Toast.makeText(getContext(),response.toString(),Toast.LENGTH_SHORT).show();
                if (response.isSuccessful()){
                    Toast.makeText(getContext(),"order Booked",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), OrderBookedActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<CartBookingResponse> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void mycartproducts() {
        Call<CartResponse> call= RetrofitClient.getInstance().getApi().getData("Bearer "+sharedPrefManager.getData().getAccess_token());
        call.enqueue(new Callback<CartResponse>() {
            @Override
            public void onResponse(Call<CartResponse> call, Response<CartResponse> response) {
                CartResponse cartResponse=response.body();
                if (response.isSuccessful()){
                    CartItemAdapter adapter =new CartItemAdapter(getContext(),cartResponse.getData());
                    recyclerView.setAdapter(adapter);

                }
//                Toast.makeText(getContext(),response.toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<CartResponse> call, Throwable t) {

            }
        });

    }
}