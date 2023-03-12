package com.example.apnicare.HealthRecords;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Toast;

import com.example.apnicare.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class clinicaldocs extends AppCompatActivity {

FloatingActionButton newdocs;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinicaldocs);
        newdocs=findViewById(R.id.newdocument);
        toolbar=findViewById(R.id.docbackbtn);
        newdocs.setOnClickListener(view -> {
            Toast.makeText(clinicaldocs.this, "", Toast.LENGTH_SHORT).show();
        });

        //backbtn
        toolbar.setNavigationOnClickListener(view1 ->{
            finish();
        } );
    }
}