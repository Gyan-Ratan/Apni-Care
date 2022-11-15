package com.example.apnicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationItemView;
    private Long backPressedTime;
    private Toast backToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationItemView=findViewById(R.id.bottomNavigationView);
        bottomNavigationItemView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.Home:
                    replace(new homepage());

                    break;
                case R.id.User:
                    replace(new account_page());
                    break;
//                case R.id.bottomPrescription:
//                    replace(new upload_prescription());
//                    break;
                case R.id.report:
                    replace(new health_records_page());
                    break;
                case R.id.Search:
                    replace(new search_medicine());
                    break;
            }
            return true;

        });

    }



    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        if( backPressedTime+2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else{
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
            backPressedTime = System.currentTimeMillis();
    }

    public void replace(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment);
        fragmentTransaction.commit();
    }


}