package com.example.apnicare.myCart;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apnicare.R;
import com.example.apnicare.RetrofitClient;
import com.example.apnicare.SharedPrefManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.ViewHolder> {
    private Context context;
    private List<Datum> data;
    int id;
    SharedPrefManager sharedPrefManager;

    public CartItemAdapter(Context context, List<Datum> data) {
        this.context = context;
        this.data = data;
    }

    //    @NonNull
//    @Override
//    public CartItemAdapter<ViewHolder> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.mycart_card,parent,false);
//        return new ViewHolder(view);
//    }
@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.mycart_card,parent,false);
    return new ViewHolder(view);
}

    @Override
    public int getItemCount() {
        return data.size();
    }



    @Override
    public void onBindViewHolder(@NonNull CartItemAdapter.ViewHolder holder, int position) {

        Datum cartresponse=data.get(position);
        holder.productname.setText(cartresponse.getDrug().getName());
        holder.mrp.setText(cartresponse.getPrice().toString());



    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView productname;
        TextView mrp,delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            itemView.setOnClickListener(this::onClick);
            delete=itemView.findViewById(R.id.deletebtn);
            productname = itemView.findViewById(R.id.productName);
            mrp = itemView.findViewById(R.id.prodctMRP);
            sharedPrefManager=new SharedPrefManager(context);


            mrp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "click on Mrp", Toast.LENGTH_SHORT).show();
                }
            });
            productname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "click on name", Toast.LENGTH_SHORT).show();
                }
            });
           delete.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int id;
            id=data.get(getAdapterPosition()).getId();
            deleteitem(id);
//            Intent refresh = new Intent(context,CartActivity.class);
//            startActivity(refresh);
//            context.finish();
//            Toast.makeText(context, "successful", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteitem(int id) {
        Call<CartItemDeleteResponse> call= RetrofitClient.getInstance().getApi().getData(id,"Bearer "+sharedPrefManager.getData().getAccess_token());
        call.enqueue(new Callback<CartItemDeleteResponse>() {
            @Override
            public void onResponse(Call<CartItemDeleteResponse> call, Response<CartItemDeleteResponse> response) {
                CartItemDeleteResponse cartItemDeleteResponse=response.body();
                if (response.isSuccessful());
                Toast.makeText(context,cartItemDeleteResponse.getData().getMessage().toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<CartItemDeleteResponse> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

    }
}
