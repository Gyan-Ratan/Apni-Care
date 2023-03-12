package com.example.apnicare.HealthRecords;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toolbar;

import com.example.apnicare.R;

public class vaccinationreports extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccinationreports);

        toolbar=findViewById(R.id.reportsbackbtn);
        //backbtn
        toolbar.setNavigationOnClickListener(view1 ->{
            finish();
        } );
    }
}