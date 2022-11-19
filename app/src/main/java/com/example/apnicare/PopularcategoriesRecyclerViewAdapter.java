package com.example.apnicare;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class PopularcategoriesRecyclerViewAdapter extends RecyclerView.Adapter<PopularcategoriesRecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Categoriesdata> mData ;


    public PopularcategoriesRecyclerViewAdapter(Context mContext, List<Categoriesdata> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.fragment_popular_categories,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_cate_title.setText(mData.get(holder.getAdapterPosition()).getTitle());
        holder.img_cate_thumbnail.setImageResource(mData.get(holder.getAdapterPosition()).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new Intent(mContext, Product_card.class);

                // passing data to the book activity
                //intent.putExtra("Title",mData.get(holder.getAdapterPosition()).getTitle());
                // intent.putExtra("Thumbnail",mData.get(holder.getAdapterPosition()).getThumbnail());
                // start the activity
                //mContext.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_cate_title;
        ImageView img_cate_thumbnail;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_cate_title = itemView.findViewById(R.id.cate_title_id2);
            img_cate_thumbnail = itemView.findViewById(R.id.cate_img_id2);
            cardView = itemView.findViewById(R.id.cardview_id);

        }
    }


}
