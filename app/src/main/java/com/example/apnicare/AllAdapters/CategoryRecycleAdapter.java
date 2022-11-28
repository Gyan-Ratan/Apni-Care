package com.example.apnicare.AllAdapters;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apnicare.AllProducts.AllProductsActivity;
import com.example.apnicare.ModelResponses.CategoryResponse.CategoryResponse;
import com.example.apnicare.R;

import java.util.List;

public class CategoryRecycleAdapter extends RecyclerView.Adapter<CategoryRecycleAdapter.MyViewHolder> {
    // created Constructor for the data
    private Context context;
    private List<CategoryResponse.Datum> list;

    public CategoryRecycleAdapter(Context context, List<CategoryResponse.Datum> contacts) {
        this.context = context;
        this.list = contacts;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categorycardlayout,parent,false);
        MyViewHolder viewHolder= new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//            NOW CONNECTING THE DATA (binding the api data with the layouts)
        holder.category.setText(list.get(position).getName());

    }

    @Override
    public int getItemCount() {
        // return list.size(); //counts the size of the list <LIST>
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        // here defining the layout ids
        TextView category;
        ImageView catimg;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            catimg = itemView.findViewById(R.id.catimg);
            category =itemView.findViewById(R.id.category);
            category.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id;
                    id=list.get(getAdapterPosition()).getSlug();
                    Intent intent = new Intent(context, AllProductsActivity.class);
                    intent.putExtra("categorySlug",id);
                    context.startActivity(intent);


                }
            });
        }
    }
}