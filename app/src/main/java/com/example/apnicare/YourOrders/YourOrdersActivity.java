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
import android.view.View;
import android.widget.Button;
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
    Button prv,nxt;
    Toolbar toolbar;
    private String[] titles= new String[]{"Delivered","Pending","Confirmed"};
    int page=1;
    OrderStatusResponse orderStatusResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_orders);
        sharedPrefManager=new SharedPrefManager(YourOrdersActivity.this);
        toolbar=findViewById(R.id.toolbar);
        recyclerView=findViewById(R.id.StatusOrderView);
        prv=findViewById(R.id.prv);
        nxt=findViewById(R.id.nxt);
//        tabLayout=findViewById(R.id.tabLayout);

//        viewPager2=findViewById(R.id.orderviewpager);
//        viewPagerFragmentAdapter=new Orderviewpager(this);
//        viewPager2.setAdapter(viewPagerFragmentAdapter);
//        new TabLayoutMediator(tabLayout,viewPager2,((tab, position) -> tab.setText(titles[position]))).attach();
//        toolbar.setNavigationOnClickListener(view1 ->{
//            finish();
//        } );
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(YourOrdersActivity.this));
            getOrder(page);

        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (page<orderStatusResponse.getData().getPages()){
                    page=page+1;
                    getOrder(page);
                }

            }
        });
        prv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (page>1){
                    page=page-1;
                    getOrder(page);
                }
            }
        });

    }

    private void getOrder(int page) {
        Call<OrderStatusResponse> call= RetrofitClient.getInstance().getApi().orderStatus(page,"Bearer "+sharedPrefManager.getData().getAccessToken());
//        Toast.makeText(YourOrdersActivity.this, "function", Toast.LENGTH_SHORT).show();
       call.enqueue(new Callback<OrderStatusResponse>() {
           @Override
           public void onResponse(Call<OrderStatusResponse> call, Response<OrderStatusResponse> response) {
               orderStatusResponse=response.body();
               if (response.isSuccessful()){
                   if (orderStatusResponse.getData()!=null){
                       OrderStatusAdapter orderStatusAdapter=new OrderStatusAdapter(response.body().getData().getItems(),YourOrdersActivity.this);
                       recyclerView.setAdapter(orderStatusAdapter);
                   }
               }
//               Toast.makeText(YourOrdersActivity.this, response.toString(), Toast.LENGTH_SHORT).show();

           }

           @Override
           public void onFailure(Call<OrderStatusResponse> call, Throwable t) {
               Toast.makeText(YourOrdersActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
           }
       });
    }

}