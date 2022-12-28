package com.example.apnicare.AllAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apnicare.ModelResponses.OrderCart.Detail;
import com.example.apnicare.R;
import com.example.apnicare.myCart.Datum;

import java.util.List;

public class ConfirmOrderAdapter extends RecyclerView.Adapter<ConfirmOrderAdapter.ViewHolder> {
     private Context context;
    private List<Detail> data;

    public ConfirmOrderAdapter(Context context, List<Detail> data) {
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public ConfirmOrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.confirmorder_card,parent,false);
        return new ConfirmOrderAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Detail cartresponse=data.get(position);
        holder.productname.setText(cartresponse.getDrug().getName());
        holder.price.setText("Rs. "+cartresponse.getPrice().toString());
        String qty= String.valueOf(cartresponse.getQuantity());
        holder.quantityNumber.setText(qty);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView productname;
        public TextView price, mrp, quantityNumber;
        Button addQuantity;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mrp = itemView.findViewById(R.id.mrp);
            productname = itemView.findViewById(R.id.productName);
            price = itemView.findViewById(R.id.prodctMRP);
            quantityNumber=itemView.findViewById(R.id.quantitynumber12);
        }
    }
}
