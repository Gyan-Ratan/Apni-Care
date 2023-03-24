package com.example.apnicare.AllProducts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
import com.example.apnicare.address_page.EditAddress;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectAddressActivity extends AppCompatActivity {
    Button editaddress;
    View addaddress;
    Toolbar toolbar;
    SharedPrefManager sharedPrefManager;
    RecyclerView addressrecycleview;
    FloatingActionButton floatingActionButton;

    int order_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectaddress);
        sharedPrefManager=new SharedPrefManager(this);
        addressrecycleview=findViewById(R.id.addressrecycleview2);
        floatingActionButton=findViewById(R.id.Addaddressbtn1);
        toolbar=findViewById(R.id.selectAdd_backbtn);
        addaddress=findViewById(R.id.Addaddressbtn);

        toolbar.setVisibility(View.VISIBLE);
//        floatingActionButton.setVisibility(View.VISIBLE);
        addressrecycleview.setVisibility(View.VISIBLE);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                toolbar.setVisibility(View.GONE);
//                floatingActionButton.setVisibility(View.GONE);
//                addressrecycleview.setVisibility(View.GONE);
                // Get the FragmentManager
                FragmentManager fragmentManager = getSupportFragmentManager();

                // Create a new Fragment instance
                EditAddress fragment = new EditAddress();

                // Add the Fragment to a container within the Activity layout
                fragmentManager.beginTransaction().replace(R.id.selectAddress, fragment).addToBackStack(null).commit();
            }
        });


        //backbtn
        toolbar.setNavigationOnClickListener(view1 ->{
            finish();
        } );
        addressrecycleview.setHasFixedSize(true);
        addressrecycleview.setLayoutManager(new LinearLayoutManager(this));
        Intent intent=getIntent();
        order_id= intent.getIntExtra("order_id",0);

        address();


        /*addaddress.setOnClickListener(view -> {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.edit_address,new EditAddress());
            fragmentTransaction.commit();
        });*/
    }
    private void address() {
        Call<AddressResponse> call= RetrofitClient.getInstance().getApi().getData1("Bearer "+sharedPrefManager.getData().getAccessToken());
        Toast.makeText(SelectAddressActivity.this,"response.toString()",Toast.LENGTH_SHORT).show();

        call.enqueue(new Callback<AddressResponse>() {
            @Override
            public void onResponse(Call<AddressResponse> call, Response<AddressResponse> response) {
                AddressResponse addressResponse= response.body();
                Toast.makeText(SelectAddressActivity.this,response.toString(),Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()){
                    SelectAddressAdapter adapter =new SelectAddressAdapter(SelectAddressActivity.this,addressResponse.getAddressdata(),order_id);
                    addressrecycleview.setAdapter(adapter);
                    Toast.makeText(SelectAddressActivity.this,response.toString(),Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<AddressResponse> call, Throwable t) {

                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}