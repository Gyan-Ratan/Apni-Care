package com.example.apnicare;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.Visibility;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputLayout;

public class Product_card extends Fragment {

    Button button ,minusbtn;
    LinearLayout linearLayout;
    TextInputLayout quantitynumber;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_card, container, false);

        button= view.findViewById(R.id.button5);
        linearLayout=view.findViewById(R.id.quantitybtn);
        minusbtn =view.findViewById(R.id.minusbtn);
        //quantitynumber = view.findViewById(R.id.quantitynumber);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(button.getVisibility()==View.VISIBLE){
                    TransitionManager.beginDelayedTransition(linearLayout, new AutoTransition());
                    linearLayout.setVisibility(View.VISIBLE);
                    button.setVisibility(View.GONE);
                }
                else if (minusbtn.getVisibility() == View.VISIBLE ){
                    minusbtn.setOnClickListener(this::onClick);
                    TransitionManager.beginDelayedTransition(linearLayout, new AutoTransition());
                    linearLayout.setVisibility(View.VISIBLE);
                    minusbtn.setVisibility(View.GONE);
                }

            }
        });
        return view;
    }


}