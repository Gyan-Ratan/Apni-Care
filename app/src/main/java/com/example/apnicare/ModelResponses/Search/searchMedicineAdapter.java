package com.example.apnicare.ModelResponses.Search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apnicare.R;
import com.example.apnicare.RetrofitClient;
import com.example.apnicare.SharedPrefManager;
import com.example.apnicare.myCart.AddItemResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class searchMedicineAdapter extends RecyclerView.Adapter<searchMedicineAdapter.ViewHolder>{
    private Context context;
    private List<items> Items;
    SharedPrefManager sharedPrefManager;


    public searchMedicineAdapter(Context context, List<items> items) {
        this.context = context;
        this.Items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine_card,parent,false);
        sharedPrefManager=new SharedPrefManager(context);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String phUrl="https://res.cloudinary.com/du8msdgbj/image/upload/w_360,h_360,c_fit,a_ignore,q_60,fl_lossy,f_auto/v1573463739/nherof9d47s0wgmmrrzh.png";
        items searchresponse=Items.get(position);

        holder.name.setText(Items.get(position).getName());
        holder.price.setText(Items.get(position).getMrp().toString());
        boolean otc=searchresponse.getPrescriptionRequired();
        if (otc==true){
            holder.OTC.setText("OTC");
        }
        else {
            holder.OTC.setText("Non-OTC");
        }

        String url =searchresponse.getImage().getOriginalPath();
        if (url==null){
            Toast.makeText(context,"no image",Toast.LENGTH_SHORT).show();

        }
        else {
            Glide.with(context)
                    .load(url)
                    .into(holder.imageView);

        }
    }



    @Override
    public int getItemCount() {
        return Items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView price,OTC;
        Button add;
        ImageView imageView;
        private LinearLayout Quantitybtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            itemView.setOnClickListener(this::onClick);
            name=itemView.findViewById(R.id.name_medicine);
            price=itemView.findViewById(R.id.price);
            add=itemView.findViewById(R.id.addtocartsearchbtn);
            imageView=itemView.findViewById(R.id.searchImage);
            OTC=itemView.findViewById(R.id.searchOTC);
            Quantitybtn=itemView.findViewById(R.id.quantitybtn);
            add.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            String id;
            id=Items.get(getAdapterPosition()).getSlug();
            addtocart(id);
            Quantitybtn.setVisibility(View.VISIBLE);
            add.setVisibility(View.INVISIBLE);

        }

    }

    private void addtocart(String id) {
        Call<AddItemResponse> call= RetrofitClient.getInstance().getApi().additemtocart(id,"Bearer "+sharedPrefManager.getData().getAccess_token());
        call.enqueue(new Callback<AddItemResponse>() {
            @Override
            public void onResponse(Call<AddItemResponse> call, Response<AddItemResponse> response) {
//                Toast.makeText(context,response.toString(),Toast.LENGTH_SHORT).show();
                if (response.isSuccessful()){
                    Toast.makeText(context,"item added to cart",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AddItemResponse> call, Throwable t) {

            }
        });

    }
}
