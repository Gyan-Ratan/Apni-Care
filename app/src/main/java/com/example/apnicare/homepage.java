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
import com.example.apnicare.myCart.CartActivity;

import java.util.ArrayList;
import java.util.List;


public class homepage extends Fragment {
    Button upbtn;
    ImageButton cart;
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
        usernumber=view.findViewById(R.id.home_user_phn);
        sharedPrefManager=new SharedPrefManager(getContext());
        usernumber.setText(sharedPrefManager.getData().getPhone());
        ImageSlider imageSlider = view.findViewById(R.id.coursel);

        upbtn.setOnClickListener(view1 -> NavHostFragment.findNavController(homepage.this)
                .navigate(R.id.action_homepage_to_upload_prescription));

        cart.setOnClickListener(view12 -> {
            Intent intent = new Intent(getActivity(), CartActivity.class);
            startActivity(intent);
        });

        //carousel
        ArrayList<SlideModel> mList = new ArrayList<>();
        mList.add(new SlideModel(R.drawable._5487, ScaleTypes.FIT));
        mList.add(new SlideModel(R.drawable._23456,ScaleTypes.FIT));
        mList.add(new SlideModel(R.drawable._014596,ScaleTypes.FIT));
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
        lstpcate.add(new Categoriesdata("Vitamins and Supplements", R.drawable.demoimg2));
        lstpcate.add(new Categoriesdata("Ayurveda", R.drawable.demoimg1));
        lstpcate.add(new Categoriesdata("Healthcare Devices", R.drawable.demoimg3));
        lstpcate.add(new Categoriesdata("Nutritional Drinks", R.drawable.demoimg5));
        lstpcate.add(new Categoriesdata("Skin care", R.drawable.demoimg4));
        lstpcate.add(new Categoriesdata("Homeopathy", R.drawable.ic_launcher_background));
        lstpcate.add(new Categoriesdata("Diabetes Care", R.drawable.ic_launcher_background));
        lstpcate.add(new Categoriesdata("Pain Relief", R.drawable.ic_launcher_background));
        lstpcate.add(new Categoriesdata("Sexual Wellness", R.drawable.ic_launcher_background));
    }
    // popular gridview layout
    private void initRecyclerView(View view){
        RecyclerView recyclerviewpc = view.findViewById(R.id.recyclerview_id1);
        PopularcategoriesRecyclerViewAdapter myAdapter = new PopularcategoriesRecyclerViewAdapter(getActivity(),lstpcate);
        recyclerviewpc.setLayoutManager(new GridLayoutManager(getActivity(),3));
        recyclerviewpc.setAdapter(myAdapter);
    }
}