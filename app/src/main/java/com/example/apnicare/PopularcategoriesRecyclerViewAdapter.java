package com.example.apnicare;

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

import java.util.List;



public class PopularcategoriesRecyclerViewAdapter extends RecyclerView.Adapter<PopularcategoriesRecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<CategoryResponse.Datum> mData ;

    public PopularcategoriesRecyclerViewAdapter(Context mContext, List<CategoryResponse.Datum> mData) {
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
        String phUrl="https://res.cloudinary.com/du8msdgbj/image/upload/w_360,h_360,c_fit,a_ignore,q_60,fl_lossy,f_auto/v1573463739/nherof9d47s0wgmmrrzh.png";

        CategoryResponse.Datum data = mData.get(holder.getAdapterPosition());
        holder.tv_cate_title.setText(data.getName());
        String url =data.getImage().getOriginalPath();
        if (url==null){
//            Toast.makeText(mContext,"no image",Toast.LENGTH_SHORT).show();

        }
        else {
            Glide.with(mContext)
                    .load(url)
                    .into(holder.img_cate_thumbnail);

        }
//        holder.img_cate_thumbnail.setImageResource(data.getThumbnail());

    }

    @Override
    public int getItemCount() {
        return 9;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_cate_title;
        ImageView img_cate_thumbnail;
        CardView cardView ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_cate_title = itemView.findViewById(R.id.cate_title_id2);
            img_cate_thumbnail = itemView.findViewById(R.id.cate_img_id2);
            cardView = itemView.findViewById(R.id.cardview_id);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

//                    Toast.makeText(mContext,"Working",Toast.LENGTH_SHORT).show();
                    // passing data to the book activity
                    //intent.putExtra("Title",mData.get(holder.getAdapterPosition()).getTitle());
                    // intent.putExtra("Thumbnail",mData.get(holder.getAdapterPosition()).getThumbnail());
                    // start the activity
                    //mContext.startActivity(intent);
                    String id;
                    id = mData.get(getAdapterPosition()).getSlug();
                    Intent intent = new Intent(mContext, AllProductsActivity.class);
                    intent.putExtra("categorySlug", id);
                    mContext.startActivity(intent);
                }
            });

        }
    }
}
