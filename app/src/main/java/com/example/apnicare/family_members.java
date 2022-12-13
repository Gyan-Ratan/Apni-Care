package com.example.apnicare;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class family_members extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_family_members);
        toolbar=findViewById(R.id.membertoolbar);
        toolbar.setNavigationOnClickListener(view5 -> {
            finish();
        });



    }
}