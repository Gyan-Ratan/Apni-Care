package com.example.apnicare.address_page;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apnicare.ModelResponses.Address.AddressResponse;
import com.example.apnicare.ModelResponses.EditAddress.EditAddressResponse;
import com.example.apnicare.R;
import com.example.apnicare.RetrofitClient;
import com.example.apnicare.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class edit_address extends Fragment {
    EditText name,address1,address2,phone,pincode,city,state;
    Button save;
    SharedPrefManager sharedPrefManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_edit_address, container, false);
        name=view.findViewById(R.id.recipientsname);
        sharedPrefManager=new SharedPrefManager(getContext());

        address1=view.findViewById(R.id.addressLine1);
        address2=view.findViewById(R.id.addressLine2);
        pincode=view.findViewById(R.id.pincode);
        phone=view.findViewById(R.id.phoneNumber);
        save=view.findViewById(R.id.saveaddress);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAddress();
            }
        });

        return view;


    }

    private void addAddress() {
        String name1=name.getText().toString();
        String phone1=phone.getText().toString();
        String address11=address1.getText().toString();
        String address21=address2.getText().toString();
        String pincode1=pincode.getText().toString();

        Call<EditAddressResponse> call= RetrofitClient.getInstance().getApi()
                .editaddress("Bearer "+sharedPrefManager.getData().getAccess_token(),name1,phone1,address11,address21,"New delhi","Delhi",pincode1,true);
        call.enqueue(new Callback<EditAddressResponse>() {
            @Override
            public void onResponse(Call<EditAddressResponse> call, Response<EditAddressResponse> response) {
                Toast.makeText(getContext(),response.toString(),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<EditAddressResponse> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });

    }
}