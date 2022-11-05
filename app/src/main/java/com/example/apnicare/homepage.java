package com.example.apnicare;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.apnicare.address_page.AddressActivity;
import com.example.apnicare.myCart.CartActivity;

import java.util.ArrayList;
import java.util.List;


public class homepage extends Fragment {
    Button upbtn;
    ImageButton cart;
    TextView usernumber;
    SharedPrefManager sharedPrefManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_homepage, container, false);
        cart=view.findViewById(R.id.cartimagebutton);
        upbtn=view.findViewById(R.id.homeupload);
        usernumber=view.findViewById(R.id.home_user_phn);
        sharedPrefManager=new SharedPrefManager(getContext());
        usernumber.setText(sharedPrefManager.getData().getAccess_token());
        ImageSlider imageSlider = view.findViewById(R.id.coursel);

        upbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(homepage.this)
                        .navigate(R.id.action_homepage_to_upload_prescription);
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CartActivity.class);
                startActivity(intent);
            }
        });

        //carousel
        ArrayList<SlideModel> mList = new ArrayList<>();
        mList.add(new SlideModel(R.drawable._5487, ScaleTypes.FIT));
        mList.add(new SlideModel(R.drawable._23456,ScaleTypes.FIT));
        mList.add(new SlideModel(R.drawable._014596,ScaleTypes.FIT));
        mList.add(new SlideModel(R.drawable.carousels,ScaleTypes.FIT));
        imageSlider.setImageList(mList,ScaleTypes.FIT);
        return view;
    }
}