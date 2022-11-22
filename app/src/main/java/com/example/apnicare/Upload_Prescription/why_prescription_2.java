package com.example.apnicare.Upload_Prescription;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.apnicare.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class why_prescription_2 extends BottomSheetDialogFragment {

  Button next;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_why_prescription_2, container, false);
        next=view.findViewById(R.id.okay);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavHostFragment.findNavController(why_prescription_2.this)
//                        .navigate(R.id.action_why_prescription_2_to_upload_prescription);
            }
        });
        return view;
    }
}