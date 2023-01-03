package com.example.apnicare.HealthRecords;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.apnicare.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class clinicaldocs extends AppCompatActivity {

FloatingActionButton newdocs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinicaldocs);
        newdocs=findViewById(R.id.newdocument);
        newdocs.setOnClickListener(view -> {
            Toast.makeText(clinicaldocs.this, "", Toast.LENGTH_SHORT).show();
        });
    }
}