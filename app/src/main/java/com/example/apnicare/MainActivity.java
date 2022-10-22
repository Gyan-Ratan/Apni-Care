package com.example.apnicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ClipData;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationItemView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationItemView=findViewById(R.id.bottomNavigation);
        bottomNavigationItemView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.homescreenbutton:
                    replace(new homepage());
                    break;
                case R.id.accountbutton:
                    replace(new account_page());
                    break;
                case R.id.bottomPrescription:
                    replace(new upload_prescription());
                    break;
                case R.id.healthrecordbutton:
                    replace(new health_records_page());
                    break;
                case R.id.homesearchbottom:
                    replace(new search_medicine());
                    break;


            }
            return true;

        });

    }
    private void replace(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment);
        fragmentTransaction.commit();
    }
}