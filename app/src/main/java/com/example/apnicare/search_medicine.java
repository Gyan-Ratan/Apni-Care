package com.example.apnicare;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apnicare.ModelResponses.Search.SearchResponse;
import com.example.apnicare.ModelResponses.Search.searchMedicineAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class search_medicine extends Fragment {
    EditText search;
    RecyclerView recyclerView2;
    SharedPrefManager sharedPrefManager;
    Button search_btn;
    SearchView searchView;

// Get data from from search view and the query api to get the results
//    private void SetupSearchView() {
//        final SearchView searchView= getActivity().findViewById(R.id.search_view); // STACKOVERFLOW IS GOD
//
//    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_search_medicine, container, false);
        sharedPrefManager=new SharedPrefManager(getContext());
//        search_btn=view.findViewById(R.id.searchbtn);
        sharedPrefManager=new SharedPrefManager(getContext());
        searchView= view.findViewById(R.id.search_view);
        recyclerView2=view.findViewById(R.id.searchrecyleview);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        searchitems("");


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
//                Toast.makeText(getContext(), "string entered", Toast.LENGTH_SHORT).show();
                searchitems(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
//                searchitems(newText);
//                Toast.makeText(getContext(), "string entered", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        return view;

    }
    private void searchitems(String a) {
        Call<SearchResponse> call= RetrofitClient
                .getInstance()
                .getApi()
                .search(1,a,null,sharedPrefManager.getData().getAccess_token());

        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
//                Toast.makeText(search_medicine.this,"response aa rha h"+response.toString(),Toast.LENGTH_SHORT).show();
                SearchResponse searchResponse= response.body();

                if (response.isSuccessful()){
                    searchMedicineAdapter adapter =new searchMedicineAdapter(getContext(),searchResponse.getData().getItems());
                    recyclerView2.setAdapter(adapter);
//                    Toast.makeText(getContext(),response.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage()+"failure",Toast.LENGTH_SHORT).show();

            }
        });
    }
}