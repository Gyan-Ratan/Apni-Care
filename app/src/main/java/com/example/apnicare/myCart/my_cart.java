package com.example.apnicare.myCart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.apnicare.R;
import com.example.apnicare.RetrofitClient;
import com.example.apnicare.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class my_cart extends Fragment {
    SharedPrefManager sharedPrefManager;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_my_cart, container, false);
        sharedPrefManager=new SharedPrefManager(getContext());
        recyclerView=view.findViewById(R.id.mycartrecycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mycartproducts();
        
        return view;
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
                Toast.makeText(getContext(),response.toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<CartResponse> call, Throwable t) {

            }
        });

    }
}