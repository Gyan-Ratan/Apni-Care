package com.example.apnicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.apnicare.AllAdapters.CategoryRecycleAdapter;
import com.example.apnicare.ModelResponses.CategoryResponse.CategoryResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllCategoriesActivity extends AppCompatActivity {
    RecyclerView recycle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);
        recycle =findViewById(R.id.recycle);
        LinearLayoutManager llm =new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recycle.setLayoutManager(llm);
        listingdata();
    }

    private void listingdata() {
        Call<CategoryResponse> call=RetrofitClient.getInstance().getApi().getdata();
        call.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                CategoryResponse categoryResponse=response.body();
                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()){
                    CategoryRecycleAdapter adapter =new CategoryRecycleAdapter(AllCategoriesActivity.this,categoryResponse.getData());
                    recycle.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}