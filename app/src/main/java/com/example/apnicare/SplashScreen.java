package com.example.apnicare;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(() -> {
                    Intent intent=new Intent(getApplicationContext(),IntroActivity.class);
                    startActivity(intent);
                    finish();
        }, 2000);
    }
}

