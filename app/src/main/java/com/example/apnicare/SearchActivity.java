package com.example.apnicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.apnicare.ModelResponses.Search.SearchResponse;
import com.example.apnicare.ModelResponses.Search.searchMedicineAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {
    EditText search;
    ImageView imageView;
    RecyclerView recyclerView2;
    SharedPrefManager sharedPrefManager;
    Button search_btn;
    SearchView searchView;
    ProgressBar progressBar;
    CartPref cartPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        sharedPrefManager=new SharedPrefManager(this);
//        search_btn=view.findViewById(R.id.searchbtn);
        progressBar=findViewById(R.id.pbar);
//        progressBar.getProgress();
        cartPref=new CartPref(this);
        imageView=findViewById(R.id.searchImageView);
        sharedPrefManager=new SharedPrefManager(this);
        searchView= findViewById(R.id.search_view);
        recyclerView2=findViewById(R.id.searchrecyleview);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(SearchActivity.this));
//        searchitems("");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
//                Toast.makeText(getContext(), "string entered", Toast.LENGTH_SHORT).show();
                searchitems(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchitems(newText);
//                Toast.makeText(getContext(), "string entered", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
    private void searchitems(String a) {
        Call<SearchResponse> call= RetrofitClient
                .getInstance()
                .getApi()
                .search(1,a,null,sharedPrefManager.getData().getAccessToken());

        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
//                Toast.makeText(search_medicine.this,"response aa rha h"+response.toString(),Toast.LENGTH_SHORT).show();
                SearchResponse searchResponse= response.body();

                if (response.isSuccessful()){

                    if (!searchResponse.getData().getItems().isEmpty()){
                        progressBar.setVisibility(View.GONE);
                        imageView.setVisibility(View.GONE);
                        searchMedicineAdapter adapter =new searchMedicineAdapter(SearchActivity.this,searchResponse.getData().getItems(),cartPref);
                        recyclerView2.setAdapter(adapter);
                    }

//                    Toast.makeText(getContext(),response.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Toast.makeText(SearchActivity.this,"Server Issue, contact admin",Toast.LENGTH_SHORT).show();

            }
        });
    }

}