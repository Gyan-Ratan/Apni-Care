package com.example.apnicare;

import android.content.Intent;
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


public class account_page extends Fragment {

    TextView order,family;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_account_page, container, false);
        order=view.findViewById(R.id.account_orders);
        family=view.findViewById(R.id.account_family);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavHostFragment.findNavController(account_page.this)
//                        .navigate(R.id.action_account_page_to_your_orders);
                Fragment childFragment = new your_orders();
//                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//                transaction.replace(R.id.accountpag, childFragment).commit();
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);

// Replace whatever is in the fragment_container view with this fragment
                transaction.replace(R.id.accountpag,childFragment, null);

// Commit the transaction
                transaction.commit();


            }
        });
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), address_edit.class);
                startActivity(intent);
            }
        });

        return view;

    }
}