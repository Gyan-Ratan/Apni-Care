package com.example.apnicare;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apnicare.YourOrders.YourOrdersActivity;
import com.example.apnicare.address_page.AddressActivity;


public class account_page extends Fragment {

    TextView order,family,addresspage,usernumber,logout,needhelp,accountsetting;
    ImageButton userprofile;
    SharedPrefManager sharedPrefManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_account_page, container, false);
        order=view.findViewById(R.id.account_orders);
        needhelp=view.findViewById(R.id.Needhelp);
        userprofile=view.findViewById(R.id.edit_profile);
        family=view.findViewById(R.id.account_family);
        usernumber=view.findViewById(R.id.phoneNumber);
        accountsetting=view.findViewById(R.id.account_setting);
        sharedPrefManager=new SharedPrefManager(getContext());
        usernumber.setText(sharedPrefManager.getData().getFirstName());
        addresspage=view.findViewById(R.id.account_addressbook);
        logout=view.findViewById(R.id.logOut);

        userprofile.setOnClickListener(view0 ->  {
            Intent intent = new Intent(getActivity(), User_Profile.class);
            startActivity(intent);
        });

        family.setOnClickListener(view1 ->  {
            Intent intent = new Intent(getActivity(), family_members.class);
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
                Intent intent = new Intent(getActivity(), Needhelp.class);
                startActivity(intent);
        });

        logout.setOnClickListener(view6 -> {
                sharedPrefManager.logOut();
                Intent intent = new Intent(getContext(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
        });
        return view;

    }
}