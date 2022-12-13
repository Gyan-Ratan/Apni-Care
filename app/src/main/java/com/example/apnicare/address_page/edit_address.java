package com.example.apnicare.address_page;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.apnicare.ModelResponses.EditAddress.EditAddressResponse;
import com.example.apnicare.R;
import com.example.apnicare.RetrofitClient;
import com.example.apnicare.SharedPrefManager;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class edit_address extends Fragment {
    TextInputEditText name,address1,address2,phone,pincode;
    Button save;
    Toolbar toolbar;
    AutoCompleteTextView city,state;
    SharedPrefManager sharedPrefManager;
    String[] items ={ "GZB","MZN"};
    ArrayAdapter<String> adapteritems;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_edit_address, container, false);

        name=view.findViewById(R.id.recipientsname);
        sharedPrefManager=new SharedPrefManager(getContext());
        toolbar=view.findViewById(R.id.NewAddtoolbar);
        address1=view.findViewById(R.id.addressLine1);
        city=view.findViewById(R.id.citydropmenu);
        state=view.findViewById(R.id.statedropmenu);
        address2=view.findViewById(R.id.addressLine2);
        pincode=view.findViewById(R.id.pincode);
        phone=view.findViewById(R.id.phoneNumber);
        save=view.findViewById(R.id.saveaddress);

        adapteritems = new ArrayAdapter<String>(getContext(),R.layout.dropmenu_list,items);
        state.setAdapter(adapteritems);

        state.setOnItemClickListener((new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(), "Item:"+item, Toast.LENGTH_SHORT).show();
            }
        }));

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAddress();
            }
        });
        toolbar.setNavigationOnClickListener(view1 -> {
            requireActivity().onBackPressed();
        });

        return view;


    }

    private void addAddress() {
        String name1=name.getText().toString();
        String phone1=phone.getText().toString();
        String address11= Objects.requireNonNull(address1.getText()).toString();
        String address21=address2.getText().toString();
        String pincode1=pincode.getText().toString();
        if(phone1.isEmpty()){
            phone.requestFocus();
            phone.setError("please enter number");
            Toast.makeText(getContext(),"enter correct number",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!Patterns.PHONE.matcher(phone1).matches()){
            phone.requestFocus();
            phone.setError("please enter a valid number");
            Toast.makeText(getContext(),"enter correct number",Toast.LENGTH_SHORT).show();
            return;
        }

        Call<EditAddressResponse> call= RetrofitClient.getInstance().getApi()
                .editaddress("Bearer "+sharedPrefManager.getData().getAccessToken(),name1,phone1,address11,address21,"New delhi","Delhi",pincode1,true);
        call.enqueue(new Callback<EditAddressResponse>() {
            @Override
            public void onResponse(Call<EditAddressResponse> call, Response<EditAddressResponse> response) {
                Toast.makeText(getContext(),"Address added",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<EditAddressResponse> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });

    }
}