package com.example.apnicare;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class upload_prescription extends Fragment {
    TextView whatpres,whypres;
    Button upload;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_upload_prescription, container, false);
        upload=view.findViewById(R.id.upload);
        whatpres=view.findViewById(R.id.why_prescription_btn);
        whypres=view.findViewById(R.id.why_prescription_2_btn);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(upload_prescription.this)
                        .navigate(R.id.action_upload_prescription_to_upload_options);
            }
        });
        whatpres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(upload_prescription.this)
                        .navigate(R.id.action_upload_prescription_to_why_prescription);
            }
        });
        whypres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(upload_prescription.this)
                        .navigate(R.id.action_upload_prescription_to_why_prescription_2);
            }
        });

        return view;
    }
}