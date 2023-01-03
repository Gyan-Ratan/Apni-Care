package com.example.apnicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alan.alansdk.AlanConfig;
import com.alan.alansdk.button.AlanButton;
import com.example.apnicare.Upload_Prescription.prescription_cam;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    BottomNavigationView bottomNavigationItemView;
    private Long exitTime;
    private Toast backToast;
    String ROOT_FRAGMENT="root_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationItemView=findViewById(R.id.bottomNavigationView);
        replace(new homepage(),true);

        bottomNavigationItemView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.Home:
                    replace(new homepage(),true);
                    break;
                case R.id.User:
                    replace(new account_page(),true);
                    break;
                case R.id.orderviewpager:
                    uploadpre();
                    break;
                case R.id.report:
                    replace(new health_records_page(),true);
                    break;
                case R.id.Search:
                    replace(new search_medicine(),true);
                    break;
//                case R.id.fab_upload:
//                    prescription_cam();
//                    System.out.println("HELLO");
//                    break;
                default:
                    Toast.makeText(this, "WORKING ON IT", Toast.LENGTH_LONG).show();
            }
            return true;

        });
//        bottomNavigationItemView.setSelectedItemId(R.id.Home);
        FloatingActionButton myFab = findViewById(R.id.fab_upload);
        myFab.setOnClickListener(v -> prescription_camera());
    }

    public void prescription_camera(){
        Intent intent = new Intent(this, upload_prescription.class);
        startActivity(intent);
    }
    public void uploadpre(){
        Intent intent = new Intent(this, upload_prescription.class);
        startActivity(intent);
    }


    public boolean replace(Fragment fragment,boolean x){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//        if (x){
//            fragmentTransaction.replace(R.id.mainpage,fragment);
////            fragmentManager.popBackStack(null, 0);
////            fragmentTransaction.addToBackStack(null);
//            int count = fragmentManager.getBackStackEntryCount();
//            for(int i = 0; i < count; ++i) {
//                fragmentManager.popBackStack();
//            }
//
//        }
//        else {
//            fragmentTransaction.replace(R.id.mainpage, fragment);
//            fragmentTransaction.addToBackStack(null);
//        }

        fragmentTransaction.replace(R.id.mainpage, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        return true;
    }
    @Override
    public void onBackPressed() {

        if (bottomNavigationItemView.getSelectedItemId()==R.id.Home){
            doExitApp();
        }
        else{
            bottomNavigationItemView.setSelectedItemId(R.id.Home);
        }

}
    public void doExitApp() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, "Press again to exit app", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        }
        else {
            finish();
        }
    }
//    }
    /*



public void onClick2(View view) {
        Fragment2 fragment2 = new Fragment2();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment1, fragment2);
        fragmentTransaction.commit();
        }
 */

}