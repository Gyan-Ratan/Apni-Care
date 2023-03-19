package com.example.apnicare.AllAdapters;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_popular_categories,parent,false);
        MyViewHolder viewHolder= new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String phUrl="https://res.cloudinary.com/du8msdgbj/image/upload/w_360,h_360,c_fit,a_ignore,q_60,fl_lossy,f_auto/v1573463739/nherof9d47s0wgmmrrzh.png";
        CategoryResponse.Datum category=list.get(position);
//            NOW CONNECTING THE DATA (binding the api data with the layouts)
        holder.category.setText(list.get(position).getName());
        String url =category.getImage().getOriginalPath();
        if (url==null){
//            Toast.makeText(context,"no image",Toast.LENGTH_SHORT).show();
            Glide.with(context)
                    .load(phUrl)
                    .into(holder.catimg);
        }
        else {
            Glide.with(context)
                    .load(url)
                    .into(holder.catimg);

        }

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
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            catimg = itemView.findViewById(R.id.cate_img_id2);
            category =itemView.findViewById(R.id.cate_title_id2);
            cardView = itemView.findViewById(R.id.cardview_id);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id;
                    id = list.get(getAdapterPosition()).getSlug();
                    Intent intent = new Intent(context, AllProductsActivity.class);
                    intent.putExtra("categorySlug", id);
                    context.startActivity(intent);


                }
            });
        }
        }
    }
