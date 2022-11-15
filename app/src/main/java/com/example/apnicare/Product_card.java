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
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Product_card extends Fragment {

    Button button ,minusbtn;
    LinearLayout linearLayout;
    TextInputLayout quantitynumber;
    private static final String Title = "title";
    private String mTitle;

    public static Fragment newInstance(String title) {
        Fragment fragment =new Product_card();
        Bundle args = new Bundle();
        args.putString(Title,title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString(Title);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_card, container, false);

        TextView textView = view.findViewById(R.id.text);
        textView.setText(mTitle);

        return view;
    }


}