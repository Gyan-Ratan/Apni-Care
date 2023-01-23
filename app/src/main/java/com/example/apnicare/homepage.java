package com.example.apnicare;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.apnicare.AllAdapters.CategoryRecycleAdapter;
import com.example.apnicare.AllProducts.AllProductsActivity;
import com.example.apnicare.ModelResponses.CategoryResponse.CategoryResponse;
import com.example.apnicare.myCart.CartActivity;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class homepage extends Fragment  {
    Button upbtn;
    SearchView searchView;
    ImageButton cart,allproducts;
    TextView usernumber,allCategory;
    SharedPrefManager sharedPrefManager;
    RecyclerView recyclerviewpc;
    ProgressBar progressBar;
    ConstraintLayout constraintLayout;
    BottomNavigationItemView bottomNavigationItemView;
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
//        ImageView searchView = view.findViewById(R.id.imageView);
        cart=view.findViewById(R.id.cartimagebutton);
        constraintLayout=view.findViewById(R.id.HomeLayout);
        progressBar=view.findViewById(R.id.pbarHome);


        upbtn=view.findViewById(R.id.homeupload);
        allproducts=view.findViewById(R.id.showallproducts);
        usernumber=view.findViewById(R.id.home_user_phn);
        allCategory=view.findViewById(R.id.allcategories);
        recyclerviewpc = view.findViewById(R.id.recyclerview_id1);
        sharedPrefManager=new SharedPrefManager(getContext());
        AllCategoriesActivity allCategoriesActivity=new AllCategoriesActivity();

        usernumber.setText(sharedPrefManager.getData().getPhone());
        ImageSlider imageSlider = view.findViewById(R.id.coursel);

//        searchView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment fragment=new search_medicine();
//                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
//                transaction.addToBackStack(null);
//                transaction.replace(R.id.homepage,fragment).commit();
//
//            }
//        });


        // cart badge

        TextView cartBadgeTextView = view.findViewById(R.id.cart_badge_text_view);
        int cartQuantity =0;
        cartBadgeTextView.setText(String.valueOf(cartQuantity));
        cartBadgeTextView.setVisibility(cartQuantity == 0 ? View.GONE : View.VISIBLE);
        upbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), upload_prescription.class);
                startActivity(intent);
            }
        });
        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AllCategoriesActivity.class);
                startActivity(intent);
            }
        });

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

        bulidlistPCdata();
        listingdata();
//        initRecyclerView(view);


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
//    private void initRecyclerView(View view){
//        RecyclerView recyclerviewpc = view.findViewById(R.id.recyclerview_id1);
//        PopularcategoriesRecyclerViewAdapter myAdapter = new PopularcategoriesRecyclerViewAdapter(getActivity(),lstpcate);
//        recyclerviewpc.setLayoutManager(new GridLayoutManager(getActivity(),3));
//        recyclerviewpc.setAdapter(myAdapter);
//    }

    /*@Override
    public void onClick(View view) {
        Fragment fragment = null;
        fragment = new search_medicine();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.homepage, fragment,null);
        transaction.hide(this);
        transaction.addToBackStack(null);
        transaction.commitNow();

        }*/

    public void listingdata() {

        Call<CategoryResponse> call=RetrofitClient.getInstance().getApi().getdata();
        call.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                CategoryResponse categoryResponse=response.body();
//                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()){
                    constraintLayout.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                    if (!categoryResponse.getData().isEmpty()){
                        PopularcategoriesRecyclerViewAdapter myAdapter = new PopularcategoriesRecyclerViewAdapter(getActivity(),categoryResponse.getData() );
                        recyclerviewpc.setLayoutManager(new GridLayoutManager(getActivity(),3));
                        recyclerviewpc.setAdapter(myAdapter);

//                        CategoryRecycleAdapter adapter =new CategoryRecycleAdapter(getContext(),categoryResponse.getData());
//                        recycle.setAdapter(adapter);
                    }

                }
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                Toast.makeText(getContext(),"Check Internet",Toast.LENGTH_SHORT).show();

            }
        });
    }

}