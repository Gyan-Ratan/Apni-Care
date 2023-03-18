package com.example.apnicare.address_page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apnicare.ModelResponses.Address.AddressAdapter;
import com.example.apnicare.ModelResponses.Address.AddressResponse;
import com.example.apnicare.R;
import com.example.apnicare.RetrofitClient;
import com.example.apnicare.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class address_book extends Fragment {

   Button editaddress;
   View addaddress;
   Toolbar toolbar;
   SharedPrefManager sharedPrefManager;
   RecyclerView addressrecycleview;
   TextView noAddress;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_address_book, container, false);
        editaddress=view.findViewById(R.id.editaddress);
        sharedPrefManager=new SharedPrefManager(getContext());
        addaddress=view.findViewById(R.id.Addaddressbtn);
        toolbar=view.findViewById(R.id.addbook_toolbar);
        noAddress=view.findViewById(R.id.noAddress);
        //backbtn
        toolbar.setNavigationOnClickListener(view1 ->{
            requireActivity().onBackPressed();
        } );
        addressrecycleview=view.findViewById(R.id.addressrecycleview);
        addressrecycleview.setHasFixedSize(true);
        addressrecycleview.setLayoutManager(new LinearLayoutManager(getContext()));
        address();
        addaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    NavHostFragment.findNavController(address_book.this)
                            .navigate(R.id.action_address_book_to_edit_address);
                }catch (Exception e){
                    System.out.println("some error at Address_Book.java" + e);
                }

            }
        });

        toolbar.setNavigationOnClickListener(view1 -> {
            requireActivity().onBackPressed();
        });

        return view;

    }
    private void address() {
        Call<AddressResponse> call= RetrofitClient.getInstance().getApi().getData1("Bearer "+sharedPrefManager.getData().getAccessToken());

        call.enqueue(new Callback<AddressResponse>() {
            @Override
            public void onResponse(Call<AddressResponse> call, Response<AddressResponse> response) {
                AddressResponse addressResponse= response.body();
                try {
                    if (response.isSuccessful()){
                        if (!addressResponse.getAddressdata().isEmpty()){
                            noAddress.setVisibility(View.GONE);
                            AddressAdapter adapter =new AddressAdapter(getContext(),addressResponse.getAddressdata());
                            addressrecycleview.setAdapter(adapter);
                        }

//                    Toast.makeText(getContext(),response.toString(),Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    System.out.println("some error at Address_Book.java" + e);
                }


            }

            @Override
            public void onFailure(Call<AddressResponse> call, Throwable t) {

//                Toast.makeText(getContext(),t.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}