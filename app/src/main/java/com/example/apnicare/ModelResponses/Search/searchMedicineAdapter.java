package com.example.apnicare.ModelResponses.Search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apnicare.R;

import java.util.List;

public class searchMedicineAdapter extends RecyclerView.Adapter<searchMedicineAdapter.ViewHolder>{
    private Context context;
    private List<items> Items;

    public searchMedicineAdapter(Context context, List<items> items) {
        this.context = context;
        Items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        items searchresponse=Items.get(position);

        holder.name.setText(Items.get(position).getName());
        holder.price.setText(Items.get(position).getMrp().toString());
    }



    @Override
    public int getItemCount() {
        return Items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this::onClick);
            name=itemView.findViewById(R.id.name_medicine);
            price=itemView.findViewById(R.id.price);

        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context,"success",Toast.LENGTH_SHORT).show();
        }
    }
}
