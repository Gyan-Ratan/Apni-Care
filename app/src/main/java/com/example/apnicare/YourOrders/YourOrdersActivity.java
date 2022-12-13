package com.example.apnicare.YourOrders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.apnicare.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class YourOrdersActivity extends AppCompatActivity {
    Orderviewpager viewPagerFragmentAdapter;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    Toolbar toolbar;
    private String[] titles= new String[]{"Delivered","Pending","Confirmed"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_orders);
        toolbar=findViewById(R.id.toolbar);
        tabLayout=findViewById(R.id.tabLayout);
        viewPager2=findViewById(R.id.orderviewpager);
        viewPagerFragmentAdapter=new Orderviewpager(this);
        viewPager2.setAdapter(viewPagerFragmentAdapter);
        new TabLayoutMediator(tabLayout,viewPager2,((tab, position) -> tab.setText(titles[position]))).attach();
        toolbar.setNavigationOnClickListener(view1 ->{
            finish();
        } );


    }

}