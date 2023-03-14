package com.example.apnicare;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.apnicare.HealthRecords.clinicaldocs;


public class health_records_page extends Fragment {
    Button clincaldocsbtn,consbtn,testre_btn,hospit_btn,vacreportbtn,billbtn,insur_btn;
    TextView txt;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_health_records_page, container, false);

        clincaldocsbtn = view.findViewById(R.id.clinicaldocsbtn);
        clincaldocsbtn.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), clinicaldocs.class);
            intent.putExtra("newText", "Not Registered");
            startActivity(intent);

        });

        vacreportbtn = view.findViewById(R.id.vacreports);
        vacreportbtn.setOnClickListener(view1 -> {
            Toast.makeText(getContext(), "Available Soon", Toast.LENGTH_SHORT).show();

        });

        consbtn = view.findViewById(R.id.consultationbtn);
        consbtn.setOnClickListener(view1 -> {
            Toast.makeText(getContext(), "Available Soon", Toast.LENGTH_SHORT).show();


        });

        testre_btn = view.findViewById(R.id.testreportsbtn);
        testre_btn.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), clinicaldocs.class);
            intent.putExtra("newText", "Not Registered");
            startActivity(intent);
        });
        hospit_btn = view.findViewById(R.id.hospitbtn);
        hospit_btn.setOnClickListener(view1 -> {
            Toast.makeText(getContext(), "Available Soon", Toast.LENGTH_SHORT).show();


        });

        billbtn = view.findViewById(R.id.billsbtn);
        billbtn.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), clinicaldocs.class);
            intent.putExtra("newText", "Not Registered");
            startActivity(intent);

        });
        insur_btn = view.findViewById(R.id.insurancebtn);
        insur_btn.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), clinicaldocs.class);
            intent.putExtra("newText", "Not Registered");
            startActivity(intent);
        });


        return view;
    }
}