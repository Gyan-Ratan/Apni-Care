package com.example.apnicare.AllProducts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.apnicare.CartPref;
import com.example.apnicare.ModelResponses.Search.SearchResponse;
import com.example.apnicare.ModelResponses.Search.searchMedicineAdapter;
import com.example.apnicare.R;
import com.example.apnicare.RetrofitClient;
import com.example.apnicare.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllProductsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SharedPrefManager sharedPrefManager;
    Button next,prev;
    ProgressBar progressBar;
    LinearLayout linearLayout;

    CartPref cartPref;
    int page=1;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);
        sharedPrefManager=new SharedPrefManager(getApplicationContext());
        next=findViewById(R.id.next);
        progressBar=findViewById(R.id.pbarAllProducts);
        linearLayout=findViewById(R.id.noMedicine);
        linearLayout.setVisibility(View.GONE);
        prev=findViewById(R.id.prev);
        Intent intent = getIntent();
        id= intent.getStringExtra("categorySlug");
        cartPref=new CartPref(getApplicationContext());



//        if (id.isEmpty()){
//            id="";
//        }
        try{
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (page>1) {
//                    progressBar.setVisibility(View.VISIBLE);
                    page=page-1;
                    listall(page,id);
                }
            }
        });}catch (Exception e){
            System.out.println("some error at ");
        }
        try {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                progressBar.setVisibility(View.VISIBLE);
                page=page+1;
                listall(page,id);
            }
        });}catch (Exception e){
            System.out.println("some error at ");
        }
        recyclerView=findViewById(R.id.allproductrecycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(AllProductsActivity.this));
        recyclerView.setVisibility(View.VISIBLE);

        listall(page,id);

    }

    private void listall(int page,String category) {
        try {
            Call<SearchResponse> call = RetrofitClient
                    .getInstance()
                    .getApi()
                    .search(page, "", category, sharedPrefManager.getData().getAccessToken());

            call.enqueue(new Callback<SearchResponse>() {
                @Override
                public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
//                Toast.makeText(search_medicine.this,"response aa rha h"+response.toString(),Toast.LENGTH_SHORT).show();
                    SearchResponse searchResponse = response.body();

                    if (response.isSuccessful()) {
                        if (!searchResponse.getData().getItems().isEmpty()){
                            progressBar.setVisibility(View.GONE);
                            recyclerView.setVisibility(View.VISIBLE);
//                            Toast.makeText(AllProductsActivity.this, ""+searchResponse.getData().getItems().toString(), Toast.LENGTH_SHORT).show();
                            searchMedicineAdapter adapter = new searchMedicineAdapter(getApplicationContext(), searchResponse.getData().getItems(),cartPref);
                            recyclerView.setAdapter(adapter);
                            linearLayout.setVisibility(View.GONE);
                        }
                        else {
                            progressBar.setVisibility(View.GONE);
                            linearLayout.setVisibility(View.VISIBLE);
                            recyclerView.setVisibility(View.GONE);
                        }

//                    Toast.makeText(getContext(),response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<SearchResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage() + "failure", Toast.LENGTH_SHORT).show();

                }
            });
        }catch (Exception e){
            System.out.println("some error at ");
        }
    }
}