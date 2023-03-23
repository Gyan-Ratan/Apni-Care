package com.example.apnicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.apnicare.ModelResponses.OrdersStatusResponse.Item;
import com.example.apnicare.Upload_Prescription.prescription_cam;
import com.example.apnicare.myCart.CartActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    BottomNavigationView bottomNavigationItemView;
    private Long exitTime=0L;
    private Toast backToast;
    String ROOT_FRAGMENT="root_fragment";
    Button searchView;
    SharedPrefManager sharedPrefManager;
    AppBarLayout appBarLayout;
    MaterialToolbar topAppBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        searchView=findViewById(R.id.search_view22);
        appBarLayout=findViewById(R.id.homeappbar);


        NestedScrollView nestedScrollView = findViewById(R.id.home_nestedScrollView);

        searchView=findViewById(R.id.homesearch_view);
        sharedPrefManager=new SharedPrefManager(getApplicationContext());
        topAppBar=findViewById(R.id.home_user_phn);
        topAppBar.setSubtitle(sharedPrefManager.getData().getPhone());

        searchView.setOnClickListener(view1 -> {
            Intent intent = new Intent(MainActivity.this, SearchActivity.class);
            startActivity(intent);
        });


        MenuItem menuItem = topAppBar.getMenu().findItem(R.id.search);
        searchView.setVisibility(View.VISIBLE);

// Load the animators
        Animator fadeInAnimator = AnimatorInflater.loadAnimator(this, R.animator.fade_in);
        Animator fadeOutAnimator = AnimatorInflater.loadAnimator(this, R.animator.fade_out);

// Set the targets
        fadeInAnimator.setTarget(searchView);
        fadeOutAnimator.setTarget(searchView);


        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {

            boolean isVisible = true;
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > oldScrollY) {
                    menuItem.setVisible(true);
                    // User is scrolling down
                    if (isVisible)  {
                            isVisible = false;
                            fadeOutAnimator.start();
                        fadeOutAnimator.addListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                searchView.setVisibility(View.GONE);
                            }
                        });
                        }
                } else if (scrollY==0){
                    menuItem.setVisible(false);
                    // User is scroll to up
                    if (!isVisible) {
                        isVisible = true;
                        searchView.setVisibility(View.VISIBLE);
                        fadeInAnimator.start();
                    }
                }
            }
        });
                //Topbar
        topAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        topAppBar.setOnMenuItemClickListener(item -> {

            if(item.getItemId()==R.id.cart) {
                Intent intent = new Intent(getApplicationContext(), CartActivity.class);
                startActivity(intent);
            }
            else if(item.getItemId() == R.id.search) {

                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
                /*FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                search_medicine fragment = new search_medicine();
                fragmentTransaction.replace(R.id.mainpage, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                return true;*/
            }
            else
                Toast.makeText(MainActivity.this, "WORKING ON IT", Toast.LENGTH_LONG).show();

            return true;
        });

        bottomNavigationItemView=findViewById(R.id.bottomNavigationView);
        replace(new homepage(),true);
        bottomNavigationItemView.setOnItemSelectedListener(item -> {

            if(item.getItemId()==R.id.Home){
                    replace(new homepage(),true);
                appBarLayout.setVisibility(View.VISIBLE);
            }
            else if(item.getItemId()== R.id.User) {
                appBarLayout.setVisibility(View.GONE);
                replace(new account_page(), true);
            }
//                case R.id.orderviewpager:
//                    uploadpre();
//                    break;
             else if (item.getItemId()==R.id.report) {
                replace(new health_records_page(), true);
                appBarLayout.setVisibility(View.GONE);
            }
            else if(item.getItemId()==R.id.Search) {
                Intent intent = new Intent(this, SearchActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
//                case R.id.fab_upload:
//                    prescription_cam();
//                    System.out.println("HELLO");
//                    break;
            else
                    Toast.makeText(this, "WORKING ON IT", Toast.LENGTH_LONG).show();

            return true;

        });
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