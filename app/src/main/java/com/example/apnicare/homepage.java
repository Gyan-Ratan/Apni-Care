package com.example.apnicare;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.apnicare.myCart.CartActivity;

import java.util.ArrayList;
import java.util.List;


public class homepage extends Fragment {
    Button upbtn;
    ImageButton cart;
    TextView usernumber;
    SharedPrefManager sharedPrefManager;
    List<Categoriesdata> lstcate ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_homepage, container, false);
        cart=view.findViewById(R.id.cartimagebutton);
        upbtn=view.findViewById(R.id.homeupload);
        usernumber=view.findViewById(R.id.home_user_phn);
        sharedPrefManager=new SharedPrefManager(getContext());
        usernumber.setText(sharedPrefManager.getData().getPhone());
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

        lstcate = new ArrayList<>();
        lstcate.add(new Categoriesdata("Order", R.drawable.rectangle_1209));
        lstcate.add(new Categoriesdata("Consult Doctor", R.drawable.rectangle_1202));
        lstcate.add(new Categoriesdata("Lab Test", R.drawable.rectangle_1210));
        lstcate.add(new Categoriesdata("Medicine", R.drawable.rectangle_1215));
        lstcate.add(new Categoriesdata("Health Products", R.drawable.rectangle_1214));

        RecyclerView myrv = view.findViewById(R.id.recyclerview_id);
        PopularcategoriesRecyclerViewAdapter myAdapter = new PopularcategoriesRecyclerViewAdapter(getActivity(),lstcate);
        myrv.setLayoutManager(new GridLayoutManager(getActivity(),3));
        myrv.setAdapter(myAdapter);


        return view;
    }
}