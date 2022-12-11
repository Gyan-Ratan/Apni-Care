package com.example.apnicare.Upload_Prescription;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.apnicare.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class upload_options_prescription extends BottomSheetDialogFragment {


    BottomSheetBehavior bottomSheetBehavior;
    LinearLayout camera;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_upload_options_prescription, container, false);
        camera=view.findViewById(R.id.uploadbycamera);
        camera.setOnClickListener(view1 -> prescription_camera());
        return view;

    }
    public void prescription_camera(){
        Intent intent = new Intent(getActivity(),prescription_cam.class);
        startActivity(intent);
    }
}