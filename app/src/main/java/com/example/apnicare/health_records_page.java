package com.example.apnicare;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.example.apnicare.HealthRecords.clinicaldocs;


public class health_records_page extends Fragment {
    Button clincaldocs,vacreport;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_health_records_page, container, false);

        clincaldocs = view.findViewById(R.id.clinicaldocs);
        clincaldocs.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), clinicaldocs.class);
            startActivity(intent);

        });

        vacreport = view.findViewById(R.id.vacreports);
        vacreport.setOnClickListener(view1 -> {
            Toast.makeText(getContext(), "Available Soon", Toast.LENGTH_SHORT).show();

        });


        return view;
    }
}