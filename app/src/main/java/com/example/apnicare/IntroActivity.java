package com.example.apnicare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {
    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;
    Button btnNext, btnContinue,btnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (restorePreData()){
            Intent mainActivity = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(mainActivity);
            finish();
        }

        setContentView(R.layout.activity_intro);

        btnNext = findViewById(R.id.btn_next);
        btnContinue=findViewById(R.id.btn_Continue);
        btnSkip = findViewById(R.id.btn_skip);
        tabIndicator = findViewById(R.id.tab_indicator);

        //Data
        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem(R.string.heading_one, R.string.desc_one, R.drawable.onboardscreen1));
        mList.add(new ScreenItem(R.string.heading_two, R.string.desc_two, R.drawable.onboardscreen2));
        mList.add(new ScreenItem(R.string.heading_three, R.string.desc_three, R.drawable.onboardscreen3));
        mList.add(new ScreenItem(R.string.heading_fourth, R.string.desc_fourth, R.drawable.onboardscreen4));

        //Setup viewPager
        screenPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this, mList);
        screenPager.setAdapter(introViewPagerAdapter);

        //Setup tab indicator

        tabIndicator.setupWithViewPager(screenPager);

        //Button Next
        btnNext.setOnClickListener(view -> screenPager.setCurrentItem(screenPager.getCurrentItem()+1, true));
        //Button Continue
        btnContinue.setOnClickListener(view -> {
            Intent mainActivity = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(mainActivity);
            savePrefsData();
            finish();
        });
        // Button Skip
        btnSkip.setOnClickListener(view -> {
            Intent mainActivity = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(mainActivity);
            savePrefsData();
            finish();
        });

        tabIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()==mList.size()-1){
                    loadLastScreen();
                }
                else {
                    NoLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private boolean restorePreData(){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        return preferences.getBoolean("isIntroOpened", false);
    }

    private void savePrefsData(){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isIntroOpened", true);
        editor.apply();
    }

    private void loadLastScreen(){
            btnNext.setVisibility(View.INVISIBLE);
        btnContinue.setVisibility(View.VISIBLE);
    }
    private void NoLastScreen(){
        btnNext.setVisibility(View.VISIBLE);
        btnContinue.setVisibility(View.INVISIBLE);
    }
}
