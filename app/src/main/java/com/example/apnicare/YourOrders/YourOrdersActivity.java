package com.example.apnicare.YourOrders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Toast;

import com.example.apnicare.ModelResponses.OrdersStatusResponse.OrderStatusResponse;
import com.example.apnicare.R;
import com.example.apnicare.RetrofitClient;
import com.example.apnicare.SharedPrefManager;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YourOrdersActivity extends AppCompatActivity {
    Orderviewpager viewPagerFragmentAdapter;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    RecyclerView recyclerView;
    SharedPrefManager sharedPrefManager;
    Toolbar toolbar;
    private String[] titles= new String[]{"Delivered","Pending","Confirmed"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_orders);
        sharedPrefManager=new SharedPrefManager(YourOrdersActivity.this);
        toolbar=findViewById(R.id.myorderbackbtn);
        recyclerView=findViewById(R.id.StatusOrderView);
//        tabLayout=findViewById(R.id.tabLayout);

//        viewPager2=findViewById(R.id.orderviewpager);
//        viewPagerFragmentAdapter=new Orderviewpager(this);
//        viewPager2.setAdapter(viewPagerFragmentAdapter);
//        new TabLayoutMediator(tabLayout,viewPager2,((tab, position) -> tab.setText(titles[position]))).attach();

        // backbtn
        toolbar.setNavigationOnClickListener(view1 ->{
            finish();
        } );
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(YourOrdersActivity.this));
            getOrder();

    }

    private void getOrder() {
        Call<OrderStatusResponse> call= RetrofitClient.getInstance().getApi().orderStatus(1,"Bearer "+sharedPrefManager.getData().getAccessToken());
//        Toast.makeText(YourOrdersActivity.this, "function", Toast.LENGTH_SHORT).show();
       call.enqueue(new Callback<OrderStatusResponse>() {
           @Override
           public void onResponse(Call<OrderStatusResponse> call, Response<OrderStatusResponse> response) {
               Toast.makeText(YourOrdersActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
               OrderStatusAdapter orderStatusAdapter=new OrderStatusAdapter(response.body().getData().getItems(),YourOrdersActivity.this);
               recyclerView.setAdapter(orderStatusAdapter);
           }

           @Override
           public void onFailure(Call<OrderStatusResponse> call, Throwable t) {
               Toast.makeText(YourOrdersActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
           }
       });
    }

}