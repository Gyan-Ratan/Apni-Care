package com.example.apnicare.Upload_Prescription;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apnicare.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class upload_options_prescription extends BottomSheetDialogFragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_upload_options_prescription, container, false);
        return view;
    }
}