package com.example.apnicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.apnicare.AllAdapters.CategoryRecycleAdapter;
import com.example.apnicare.ModelResponses.CategoryResponse.CategoryResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllCategoriesActivity extends AppCompatActivity {
    RecyclerView recycle;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);
        recycle =findViewById(R.id.recycle);
        progressBar=findViewById(R.id.pbarAllCategory);
        progressBar.getProgress();
//        LinearLayoutManager llm =new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
//        recycle.setLayoutManager(llm);
        listingdata();
    }

    public void listingdata() {

        Call<CategoryResponse> call=RetrofitClient.getInstance().getApi().getdata();
        call.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                CategoryResponse categoryResponse=response.body();
//                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()){
                    if (!categoryResponse.getData().isEmpty()){
                        progressBar.setVisibility(View.GONE);
                        CategoryRecycleAdapter adapter =new CategoryRecycleAdapter(AllCategoriesActivity.this,categoryResponse.getData());
                        recycle.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
                        recycle.setAdapter(adapter);
                    }

                }
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Check Internet",Toast.LENGTH_SHORT).show();

            }
        });
    }
}