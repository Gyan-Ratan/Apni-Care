package com.example.apnicare.ModelResponses.Address;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apnicare.ModelResponses.DeleteAddress.DeleteAddressResponse;
import com.example.apnicare.R;
import com.example.apnicare.RetrofitClient;
import com.example.apnicare.SharedPrefManager;
import com.example.apnicare.address_page.address_book;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {

    private Context context;
    private List<Datum> addresses;
    SharedPrefManager sharedPrefManager;

    public AddressAdapter(Context context, List<Datum> addresses) {
        this.context = context;
        this.addresses = addresses;
    }





    @NonNull
    @Override
    public AddressAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.address_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressAdapter.ViewHolder holder, int position) {
        Datum addressresponse= addresses.get(position);
        holder.name.setText(addressresponse.getName());
        holder.address_line1.setText(addressresponse.getAddress1());
        holder.address_line2.setText(addressresponse.getAddress2());
        holder.defaultAddress.setChecked(addressresponse.getDefault());

    }

    @Override
    public int getItemCount() {
        return addresses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView address_line1,address_line2;
        CheckBox defaultAddress;
        Button edit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.address_name);
            address_line1=itemView.findViewById(R.id.address_line1);
            address_line2=itemView.findViewById(R.id.address_line2);
            defaultAddress=itemView.findViewById(R.id.defaultaddress);
            edit=itemView.findViewById(R.id.editaddress);
            sharedPrefManager=new SharedPrefManager(context);

            edit.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View v) {
            int id;
            id=addresses.get(getAdapterPosition()).getId();
            deleteaddress(id);


        }
    }

    private void deleteaddress(int id) {
        Call<DeleteAddressResponse> call= RetrofitClient.getInstance().getApi().deleteaddress(id,"Bearer "+sharedPrefManager.getData().getAccess_token());
        call.enqueue(new Callback<DeleteAddressResponse>() {
            @Override
            public void onResponse(Call<DeleteAddressResponse> call, Response<DeleteAddressResponse> response) {
                DeleteAddressResponse deleteAddressResponse=response.body();
                if (response.isSuccessful()){
                    Toast.makeText(context,response.toString(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DeleteAddressResponse> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }

}
