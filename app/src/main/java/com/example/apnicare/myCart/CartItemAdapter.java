package com.example.apnicare.myCart;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apnicare.CartManager;
import com.example.apnicare.CartPref;
import com.example.apnicare.ModelResponses.OrderCart.Detail;
import com.example.apnicare.R;
import com.example.apnicare.RetrofitClient;
import com.example.apnicare.SharedPrefManager;
import com.example.apnicare.product_detail;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.ViewHolder> {
    private TextView cartTotal,discount,topay;
    private Context context;
//    private List<Datum> data;
    SharedPrefManager sharedPrefManager;
    CartPref cartPref;
    ArrayList<CartManager> data;

    public CartItemAdapter(Context context, ArrayList<CartManager> data , TextView cartTotal,TextView discount,TextView topay) {
        this.context = context;
        this.data = data;
        this.cartTotal=cartTotal;
        this.discount=discount;
        this.topay=topay;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.mycart_card,parent,false);
        cartPref=new CartPref(context);
        return new ViewHolder(view);
}

    @Override
    public int getItemCount() {
        return data.size();
    }



    @Override
    public void onBindViewHolder(@NonNull CartItemAdapter.ViewHolder holder, int position) {

//        Datum cartresponse=data.get(position);
//        holder.productname.setText(cartresponse.getDrug().getName());
//        holder.price.setText("Rs. " +cartresponse.getPrice().toString());
//        holder.mrp.setText("MRP Rs. "+cartresponse.getDrug().getMrp().toString());
//        holder.quantityNumber.setText(String.valueOf(cartresponse.getQuantity()));
//        holder.delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int id,post;
//                id = cartresponse.getId();
//                holder.deleteitem(id,position);0
//
//            }
//        });

        holder.productname.setText(data.get(position).itemName);
        holder.price.setText("Rs. " +data.get(position).price);
        holder.mrp.setText("MRP Rs. "+data.get(position).qty);
        holder.quantityNumber.setText(String.valueOf(data.get(position).qty));



    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView productname;
        public TextView price, delete, mrp, quantityNumber;
        Button addQuantity,minus;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            itemView.setOnClickListener(this::onClick);
            mrp = itemView.findViewById(R.id.mrp);
            cardView=itemView.findViewById(R.id.cart_cardView);
            delete = itemView.findViewById(R.id.deletebtn);
            productname = itemView.findViewById(R.id.productName);
            price = itemView.findViewById(R.id.prodctMRP);
            quantityNumber = itemView.findViewById(R.id.quantitynumber);
            addQuantity = itemView.findViewById(R.id.addbtn);
            minus=itemView.findViewById(R.id.minusbtn);
            sharedPrefManager = new SharedPrefManager(context);

            addQuantity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cartPref.saveItem(data.get(getAdapterPosition()).itemName,1,data.get(getAdapterPosition()).slug,data.get(getAdapterPosition()).price);
                    data.get(getAdapterPosition()).setQty(data.get(getAdapterPosition()).qty+1);
                    notifyItemChanged(getAdapterPosition());
                    updateTotal();
                }
            });

            price.setOnClickListener(new View.OnClickListener() {
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

            minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cartPref.saveItem(data.get(getAdapterPosition()).itemName,-1,data.get(getAdapterPosition()).slug,data.get(getAdapterPosition()).price);
                    data.get(getAdapterPosition()).setQty(data.get(getAdapterPosition()).qty-1);
                    if (data.get(getAdapterPosition()).qty==0){
                        data.remove(getAdapterPosition());
                        notifyItemRemoved(getAdapterPosition());
                    }
                    else if (data.get(getAdapterPosition()).qty<0){

                    }
                    else {
                        notifyItemChanged(getAdapterPosition());
                    }

                    updateTotal();
                }
            });


        }

        @Override
        public void onClick(View view) {
//            data.remove(getAdapterPosition());
//            data.notify();
//            deleteitem(id, getAdapterPosition());

        }

//        private void addtocart(String id) {
//            Call<AddItemResponse> call = RetrofitClient.getInstance().getApi().additemtocart(id, "Bearer " + sharedPrefManager.getData().getAccessToken());
//            call.enqueue(new Callback<AddItemResponse>() {
//                @Override
//                public void onResponse(Call<AddItemResponse> call, Response<AddItemResponse> response) {
////                Toast.makeText(context,response.toString(),Toast.LENGTH_SHORT).show();
//                    if (response.isSuccessful()) {
//                        data.get(getAdapterPosition()).setQuantity(response.body().getData().getQuantity());
//                        int q = response.body().getData().getQuantity();
//                        notifyItemChanged(getAdapterPosition());
//                        updateTotal();
////                        quantityNumber.setText(String.valueOf(q));
////                        Intent refresh = new Intent(context,CartActivity.class);
////                        refresh.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
////                        context.startActivity(refresh);
//
//                        }
//                }
//
//                @Override
//                public void onFailure(Call<AddItemResponse> call, Throwable t) {
//
//                }
//            });
//
//        }


//        public void deleteitem(int id, int post) {
//            Call<CartItemDeleteResponse> call = RetrofitClient.getInstance().getApi().getData(id, "Bearer " + sharedPrefManager.getData().getAccessToken());
//            call.enqueue(new Callback<CartItemDeleteResponse>() {
//                @Override
//                public void onResponse(Call<CartItemDeleteResponse> call, Response<CartItemDeleteResponse> response) {
//                    CartItemDeleteResponse cartItemDeleteResponse = response.body();
//                    if (response.isSuccessful()) {
//                        data.remove(getAdapterPosition());
//                        notifyItemRemoved(getAdapterPosition());
//                        updateTotal();
//                    }
//
//                }
//
//                @Override
//                public void onFailure(Call<CartItemDeleteResponse> call, Throwable t) {
//                    Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
//
//                }
//
//            });
//            //        context.notifyDataSetChanged();
////        Intent refresh = new Intent(context,CartActivity.class);
////
////        refresh.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
////        context.startActivity(refresh);
////        Toast.makeText(context, "successful", Toast.LENGTH_SHORT).show();
//        }
    }
    private void updateTotal() {
        int i;
        double mrp = 0, sum = 0;
        for (i = 0; i < data.size(); i++) {
            sum = sum + (data.get(i).getPrice() * data.get(i).qty);
//            mrp = mrp + (data.get(i).getDrug().getMrp() * data.get(i).getQuantity());
        }
//        cartTotal.setText("₹ "+new DecimalFormat("##.##").format(mrp));
//        discount.setText("-₹ "+new DecimalFormat("##.##").format(mrp-sum));
        topay.setText("₹ "+new DecimalFormat("##.##").format(sum));


    }

//    private void updateTotal() {
//        int i;
//        double mrp=0,sum=0;
//        if (cartManagerArrayList==null || cartManagerArrayList.isEmpty()){
//            topay.setText("₹ "+"00");
////            topay1.setText("₹ "+"00");
//        }
//        else {
//            for (i=0;i<cartManagerArrayList.size();i++){
//                sum= sum+(cartManagerArrayList.get(i).price*cartManagerArrayList.get(i).qty);
////            mrp = mrp + (cartResponse.getData().get(i).getDrug().getMrp()*cartResponse.getData().get(i).getQuantity());
//            }
////        cartTotal.setText("₹ "+new DecimalFormat("##.##").format(mrp));
////        dicount.setText("-₹ "+new DecimalFormat("##.##").format(mrp-sum));
//            topay.setText("₹ "+new DecimalFormat("##.##").format(sum));
////            topay.setText("₹ "+new DecimalFormat("##.##").format(sum));
//        }
//
//
//
//    }

}
