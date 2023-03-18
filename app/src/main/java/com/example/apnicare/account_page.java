package com.example.apnicare;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apnicare.HealthRecords.clinicaldocs;
import com.example.apnicare.YourOrders.YourOrdersActivity;
import com.example.apnicare.address_page.AddressActivity;


public class account_page extends Fragment {

    TextView order,family,addresspage,usernumber,username,gender,email,logout,needhelp,accountsetting,referButton;
    ImageButton userprofile;
    SharedPrefManager sharedPrefManager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account_page, container, false);
        order = view.findViewById(R.id.account_orders);
        needhelp = view.findViewById(R.id.Needhelp);
        userprofile = view.findViewById(R.id.edit_profile);
        family = view.findViewById(R.id.account_family);
        usernumber = view.findViewById(R.id.phoneNumber);
        username = view.findViewById(R.id.text_dashboard);
//        email=view.findViewById(R.id.text_email);
        gender=view.findViewById(R.id.text_gender);
        accountsetting = view.findViewById(R.id.account_setting);
        sharedPrefManager = new SharedPrefManager(getContext());
        usernumber.setText(sharedPrefManager.getData().getPhone());
        addresspage = view.findViewById(R.id.account_addressbook);
        logout = view.findViewById(R.id.logOut);
        referButton = view.findViewById(R.id.referButton);
        userprofile.setVisibility(View.GONE);

        /*username.setText(sharedPrefManager.getData().getFirstName().toUpperCase());
        username.setVisibility(sharedPrefManager.getData().getFirstName()==null ? View.GONE : View.VISIBLE);*/

//        email.setText(sharedPrefManager.getData().getEmail());
//        email.setVisibility(sharedPrefManager.getData().getEmail()==null ? View.GONE : View.VISIBLE);

        /*gender.setText(sharedPrefManager.getData().getGender().substring(0,1));
        gender.setVisibility(sharedPrefManager.getData().getGender()==null ? View.GONE : View.VISIBLE);*/

        userprofile.setOnClickListener(view0 ->  {
            Intent intent = new Intent(getActivity(), TempActivity.class);
            startActivity(intent);
        });

        family.setOnClickListener(view1 ->  {
            Intent intent = new Intent(getActivity(), clinicaldocs.class);
            intent.putExtra("newText", "Available Soon");
            startActivity(intent);
        });

        order.setOnClickListener(view2 ->{
                Intent intent = new Intent(getActivity(), YourOrdersActivity.class);
                startActivity(intent);
        });

        addresspage.setOnClickListener(view3 -> {
            Intent intent = new Intent(getActivity(), AddressActivity.class);
            startActivity(intent);
        });

        accountsetting.setOnClickListener(view3 -> {
            Toast.makeText(getActivity(), "Working", Toast.LENGTH_SHORT).show();
            /*Intent intent = new Intent(getActivity(), AddressActivity.class);
            startActivity(intent);*/
        });

        needhelp.setOnClickListener(view5 ->  {
                Intent intent = new Intent(getActivity(), ContactUsActivity.class);
                startActivity(intent);
        });

        logout.setOnClickListener(view6 -> {
                sharedPrefManager.logOut();
                Intent intent = new Intent(getContext(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
        });

        //        REFER ACTION
        referButton.setOnClickListener(view7 -> {
            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String body = "www.apnicare.in";
            String sub = "RANDOM";
            myIntent.putExtra(Intent.EXTRA_SUBJECT, sub);
            myIntent.putExtra(Intent.EXTRA_TEXT, body);
            startActivity(Intent.createChooser(myIntent, "Share Using"));
        });
        return view;

    }
}