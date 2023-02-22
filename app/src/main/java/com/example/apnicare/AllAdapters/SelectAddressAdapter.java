package com.example.apnicare.AllAdapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apnicare.OrderReviewActivity;
import com.example.apnicare.ModelResponses.Address.Datum;
import com.example.apnicare.R;
import com.example.apnicare.SharedPrefManager;

import java.util.List;

public class SelectAddressAdapter extends RecyclerView.Adapter<SelectAddressAdapter.ViewHolder> {
    private Context context;
    private List<Datum> addresses;
    private SharedPrefManager sharedPrefManager;
    private int o_id;

    public SelectAddressAdapter(Context context, List<Datum> addresses, int o_id) {
        this.context = context;
        this.addresses = addresses;
        this.o_id = o_id;
    }

    @NonNull
    @Override
    public SelectAddressAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.address_card,parent,false);
        return new SelectAddressAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectAddressAdapter.ViewHolder holder, int position) {
        Datum addressresponse= addresses.get(position);
        holder.name.setText(addressresponse.getName());
        holder.pincode.setText(addressresponse.getPincode());
        holder.address_line1.setText(addressresponse.getAddress1());
        holder.address_line2.setText(addressresponse.getAddress2());
        holder.edit.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return addresses.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView address_line1,address_line2,pincode;
        //        CheckBox defaultAddress;
        Button edit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.address_name);
            pincode=itemView.findViewById(R.id.pincode);
            address_line1=itemView.findViewById(R.id.address_line1);
            address_line2=itemView.findViewById(R.id.address_line2);
//            defaultAddress=itemView.findViewById(R.id.defaultaddress);
            edit=itemView.findViewById(R.id.editaddress);
            sharedPrefManager=new SharedPrefManager(context);
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id;
                    id=addresses.get(getAdapterPosition()).getId();
//                    deleteaddress(id);


                }
            });

            itemView.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View v) {
            int id1;
            id1=addresses.get(getAdapterPosition()).getId();
            Intent intent = new Intent(context, OrderReviewActivity.class);
            intent.putExtra("id",id1);
//            intent.putExtra("order",o_id);
            context.startActivity(intent);

        }
    }



}
