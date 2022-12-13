package com.example.apnicare.myCart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apnicare.ModelResponses.OrderCart.CartBookingResponse;
import com.example.apnicare.R;
import com.example.apnicare.RetrofitClient;
import com.example.apnicare.SharedPrefManager;

import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartActivity extends AppCompatActivity {

    SharedPrefManager sharedPrefManager;
    RecyclerView recyclerView;
    LinearLayoutCompat proceed;
    CartItemAdapter cartItemAdapter;
    TextView cartTotal,dicount,topay,topay1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView=findViewById(R.id.mycartrecycleview);
        sharedPrefManager=new SharedPrefManager(CartActivity.this);

        proceed=findViewById(R.id.proceedtopay);
        cartTotal=findViewById(R.id.cartTotal);
        dicount=findViewById(R.id.discount);
        topay=findViewById(R.id.topay);
        topay1=findViewById(R.id.topay2);
        recyclerView.setHasFixedSize(true);
        mycartproducts();
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bookorder();
            }
        });

    }

    private void mycartproducts() {
        Call<CartResponse> call= RetrofitClient.getInstance().getApi().getData("Bearer "+sharedPrefManager.getData().getAccessToken());
        call.enqueue(new Callback<CartResponse>() {
            @Override
            public void onResponse(Call<CartResponse> call, Response<CartResponse> response) {
                CartResponse cartResponse=response.body();
                if (response.isSuccessful()){
                    CartItemAdapter adapter =new CartItemAdapter(CartActivity.this,cartResponse.getData(),cartTotal);
                    recyclerView.setLayoutManager((new LinearLayoutManager(CartActivity.this)));
                    recyclerView.setAdapter(adapter);
                    updateTotal(cartResponse);
//                    cartTotal.setText(cartResponse.getData());

                }
//                Toast.makeText(getContext(),response.toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<CartResponse> call, Throwable t) {

            }
        });

    }

            private void bookorder() {
//        Toast.makeText(getContext(),"function",Toast.LENGTH_SHORT).show();

                Call<CartBookingResponse> call=RetrofitClient.getInstance().getApi().book("cart","customer","Bearer "+sharedPrefManager.getData().getAccessToken());
                call.enqueue(new Callback<CartBookingResponse>() {
                    @Override
                    public void onResponse(Call<CartBookingResponse> call, Response<CartBookingResponse> response) {
                        Toast.makeText(CartActivity.this,response.toString(),Toast.LENGTH_SHORT).show();
                        if (response.isSuccessful()){
                            Toast.makeText(CartActivity.this,"order Booked",Toast.LENGTH_SHORT).show();
                            /*Intent intent = new Intent(getActivity(), OrderBookedActivity.class);
                            startActivity(intent);*/

                        }
                    }
                    @Override
                    public void onFailure(Call<CartBookingResponse> call, Throwable t) {
                        Toast.makeText(CartActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });
            }
            private void updateTotal(CartResponse cartResponse) {
                int i;
                double mrp=0,sum=0;
                String su;
                for (i=0;i<cartResponse.getData().size();i++){
                    sum= sum+(cartResponse.getData().get(i).getDrug().getPrice()*cartResponse.getData().get(i).getQuantity());
                    mrp = mrp + (cartResponse.getData().get(i).getDrug().getMrp()*cartResponse.getData().get(i).getQuantity());
                }
                cartTotal.setText("₹ "+new DecimalFormat("##.##").format(mrp));
                dicount.setText("-₹ "+new DecimalFormat("##.##").format(mrp-sum));
                topay.setText("₹ "+new DecimalFormat("##.##").format(sum));
                topay1.setText("₹ "+new DecimalFormat("##.##").format(sum));


            }

}