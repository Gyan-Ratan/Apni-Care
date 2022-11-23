package com.example.apnicare;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.apnicare.AllProducts.AllProductsActivity;
import com.example.apnicare.myCart.CartActivity;

import java.util.ArrayList;
import java.util.List;


public class homepage extends Fragment {
    Button upbtn;
    ImageButton cart,allproducts;
    TextView usernumber;
    SharedPrefManager sharedPrefManager;
    List<Categoriesdata> lstcate ;
    private final List<Categoriesdata> lstpcate = new ArrayList<>() ;

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
        allproducts=view.findViewById(R.id.showallproducts);
        usernumber=view.findViewById(R.id.home_user_phn);
        sharedPrefManager=new SharedPrefManager(getContext());
        usernumber.setText(sharedPrefManager.getData().getPhone());
        ImageSlider imageSlider = view.findViewById(R.id.coursel);
        upbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), upload_prescription.class);
                startActivity(intent);
            }
        });


//

        cart.setOnClickListener(view12 -> {
            Intent intent = new Intent(getActivity(), CartActivity.class);
            startActivity(intent);
        });

        allproducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AllProductsActivity.class);
                startActivity(intent);
            }
        });

        //carousel
        ArrayList<SlideModel> mList = new ArrayList<>();
        mList.add(new SlideModel(R.drawable.oziva_offers_web, ScaleTypes.FIT));
        mList.add(new SlideModel(R.drawable.tejasya,ScaleTypes.FIT));
        mList.add(new SlideModel(R.drawable.eno,ScaleTypes.FIT));
        mList.add(new SlideModel(R.drawable.carousel,ScaleTypes.FIT));
        mList.add(new SlideModel(R.drawable.carousels1, ScaleTypes.FIT));
        mList.add(new SlideModel(R.drawable.carousel2,ScaleTypes.FIT));
        mList.add(new SlideModel(R.drawable.carousel3,ScaleTypes.FIT));
        mList.add(new SlideModel(R.drawable.carousels,ScaleTypes.FIT));
        imageSlider.setImageList(mList,ScaleTypes.FIT);

        lstcate = new ArrayList<>();
        lstcate.add(new Categoriesdata("Order", R.drawable.demoimg2));
        lstcate.add(new Categoriesdata("Consult Doctor", R.drawable.demoimg1));
        lstcate.add(new Categoriesdata("Lab Test", R.drawable.demoimg3));
        lstcate.add(new Categoriesdata("Medicine", R.drawable.demoimg5));
        lstcate.add(new Categoriesdata("Health Products", R.drawable.demoimg4));

        bulidlistPCdata();
        initRecyclerView(view);

        RecyclerView myrv = view.findViewById(R.id.recyclerview_id);
        PopularcategoriesRecyclerViewAdapter myAdapter = new PopularcategoriesRecyclerViewAdapter(getActivity(),lstcate);
        myrv.setLayoutManager(new GridLayoutManager(getActivity(),3));
        myrv.setAdapter(myAdapter);

        return view;
    }
    //popular categories data
    private void bulidlistPCdata(){
        lstpcate.add(new Categoriesdata("Vitamins and Supplements", R.drawable.vitamins));
        lstpcate.add(new Categoriesdata("Ayurveda", R.drawable.ayurveda));
        lstpcate.add(new Categoriesdata("Healthcare Devices", R.drawable.hcdevices));
        lstpcate.add(new Categoriesdata("Nutritional Drinks", R.drawable.ndrinks));
        lstpcate.add(new Categoriesdata("Skin care", R.drawable.skincare));
        lstpcate.add(new Categoriesdata("Homeopathy", R.drawable.hpathy));
        lstpcate.add(new Categoriesdata("Diabetes Care", R.drawable.diabetes));
        lstpcate.add(new Categoriesdata("Pain Relief", R.drawable.painref));
        lstpcate.add(new Categoriesdata("Sexual Wellness", R.drawable.sexualwell));
    }
    // popular gridview layout
    private void initRecyclerView(View view){
        RecyclerView recyclerviewpc = view.findViewById(R.id.recyclerview_id1);
        PopularcategoriesRecyclerViewAdapter myAdapter = new PopularcategoriesRecyclerViewAdapter(getActivity(),lstpcate);
        recyclerviewpc.setLayoutManager(new GridLayoutManager(getActivity(),3));
        recyclerviewpc.setAdapter(myAdapter);
    }
}