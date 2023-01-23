package com.example.apnicare.YourOrders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apnicare.ModelResponses.OrdersStatusResponse.Item;
import com.example.apnicare.R;

import java.util.List;

public class OrderStatusAdapter extends RecyclerView.Adapter<OrderStatusAdapter.ViewHolder> {
    private List<Item> items;
    private Context context;

    public OrderStatusAdapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderStatusAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.your_orders_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderStatusAdapter.ViewHolder holder, int position) {
        Item item=items.get(position);
        holder.orderId.setText(item.getOrderNumber());
        holder.status.setText(item.getStatus());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView orderId,status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            orderId=itemView.findViewById(R.id.order_no);
            status=itemView.findViewById(R.id.order_status);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
