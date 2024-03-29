package com.example.apnicare.AllProducts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.apnicare.AllAdapters.SelectAddressAdapter;
import com.example.apnicare.ModelResponses.Address.AddressResponse;
import com.example.apnicare.R;
import com.example.apnicare.RetrofitClient;
import com.example.apnicare.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectAddressActivity extends AppCompatActivity {
    Button editaddress;
    View addaddress;
    Toolbar toolbar;
    SharedPrefManager sharedPrefManager;
    RecyclerView addressrecycleview;
    int order_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectaddress);
        sharedPrefManager=new SharedPrefManager(this);
        addressrecycleview=findViewById(R.id.addressrecycleview2);
        addressrecycleview.setHasFixedSize(true);
        addressrecycleview.setLayoutManager(new LinearLayoutManager(this));
        Intent intent=getIntent();
        order_id= intent.getIntExtra("order_id",0);

        address();


    }
    private void address() {
        Call<AddressResponse> call= RetrofitClient.getInstance().getApi().getData1("Bearer "+sharedPrefManager.getData().getAccessToken());

        call.enqueue(new Callback<AddressResponse>() {
            @Override
            public void onResponse(Call<AddressResponse> call, Response<AddressResponse> response) {
                AddressResponse addressResponse= response.body();
                if (response.isSuccessful()){
                    SelectAddressAdapter adapter =new SelectAddressAdapter(SelectAddressActivity.this,addressResponse.getAddressdata(),order_id);
                    addressrecycleview.setAdapter(adapter);
//                    Toast.makeText(getContext(),response.toString(),Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<AddressResponse> call, Throwable t) {

                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}