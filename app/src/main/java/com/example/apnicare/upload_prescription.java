package com.example.apnicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apnicare.Upload_Prescription.upload_options_prescription;
import com.example.apnicare.Upload_Prescription.why_prescription;
import com.example.apnicare.Upload_Prescription.why_prescription_2;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class upload_prescription extends AppCompatActivity {

    TextView whatpres,whypres;
    Button upload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_upload_prescription);
        upload=findViewById(R.id.upload);
        whatpres=findViewById(R.id.why_prescription_btn);
        whypres=findViewById(R.id.why_prescription_2_btn);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialogFragment bottomSheetDialogFragment = new upload_options_prescription();
                bottomSheetDialogFragment.show(getSupportFragmentManager(),bottomSheetDialogFragment.getTag());

            }
        });
        whatpres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialogFragment bottomSheetDialogFragment = new why_prescription();
                bottomSheetDialogFragment.show(getSupportFragmentManager(),bottomSheetDialogFragment.getTag());

            }
        });
        whypres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialogFragment bottomSheetDialogFragment = new why_prescription_2();
                bottomSheetDialogFragment.show(getSupportFragmentManager(),bottomSheetDialogFragment.getTag());

            }
        });
    }
}