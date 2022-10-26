package com.example.apnicare;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.apnicare.address_page.AddressActivity;


public class account_page extends Fragment {

    TextView order,family,addresspage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_account_page, container, false);
        order=view.findViewById(R.id.account_orders);
        family=view.findViewById(R.id.account_family);
        addresspage=view.findViewById(R.id.account_addressbook);
       
        addresspage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddressActivity.class);
                startActivity(intent);
            }
        });

        return view;

    }
}