package com.example.apnicare.address_page;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.apnicare.ModelResponses.EditAddress.EditAddressResponse;
import com.example.apnicare.R;
import com.example.apnicare.RetrofitClient;
import com.example.apnicare.SharedPrefManager;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class edit_address extends Fragment {
    TextInputEditText name,address1,address2,phone,pincode;
    Button save;
    Toolbar toolbar;
    AutoCompleteTextView city,state;
    SharedPrefManager sharedPrefManager;
    String[] items ={ "GZB","MZN"};
    ArrayAdapter<String> adapteritems;
    private RequestQueue mRequestQueue;
    String district,state1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_edit_address, container, false);

        name=view.findViewById(R.id.recipientsname);
        sharedPrefManager=new SharedPrefManager(getContext());
        toolbar=view.findViewById(R.id.NewAddtoolbar);
        address1=view.findViewById(R.id.addressLine1);
        city=view.findViewById(R.id.citydropmenu);
        state=view.findViewById(R.id.statedropmenu);
        address2=view.findViewById(R.id.addressLine2);
        pincode=view.findViewById(R.id.pincode123);
        phone=view.findViewById(R.id.phoneNumber);
        save=view.findViewById(R.id.saveaddress);
        mRequestQueue = Volley.newRequestQueue(getContext());


        adapteritems = new ArrayAdapter<String>(getContext(),R.layout.dropmenu_list,items);
        state.setAdapter(adapteritems);

        state.setOnItemClickListener((new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    String item = parent.getItemAtPosition(position).toString();
                    Toast.makeText(getActivity(), "Item:"+item, Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    System.out.println("some error at edit_Address.java" + e);
                }

            }
        }));

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pincode1 = pincode.getText().toString();
                getDataFromPinCode(pincode1);
                addAddress(pincode1);

            }
        });
        toolbar.setNavigationOnClickListener(view1 -> {
            requireActivity().onBackPressed();
        });

        return view;


    }

    private void addAddress(String pincode1) {
        String name1 = name.getText().toString();
        String phone1 = phone.getText().toString();
        String address11 = Objects.requireNonNull(address1.getText()).toString();
        String address21 = address2.getText().toString();


        try {
            if (phone1.isEmpty()) {
                phone.requestFocus();
                phone.setError("please enter number");
                Toast.makeText(getContext(), "enter correct number", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!Patterns.PHONE.matcher(phone1).matches()) {
                phone.requestFocus();
                phone.setError("please enter a valid number");
                Toast.makeText(getContext(), "enter correct number", Toast.LENGTH_SHORT).show();
                return;
            }


            Call<EditAddressResponse> call = RetrofitClient.getInstance().getApi()
                    .editaddress("Bearer " + sharedPrefManager.getData().getAccessToken(), name1, phone1, address11, address21, "Hirdaipur Madaula", state1, pincode1, true);
            call.enqueue(new Callback<EditAddressResponse>() {
                @Override
                public void onResponse(Call<EditAddressResponse> call, Response<EditAddressResponse> response) {
//                    Toast.makeText(getContext(), response.toString(), Toast.LENGTH_SHORT).show();

                    if (response.isSuccessful()){
                        Toast.makeText(getContext(), "Address added", Toast.LENGTH_SHORT).show();

                    }

                }

                @Override
                public void onFailure(Call<EditAddressResponse> call, Throwable t) {
                    Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();


                }
            });
        } catch (Exception f) {
            System.out.println("some error at edit_address.java" + f);
        }
    }

        private void getDataFromPinCode(String pinCode) {

            // clearing our cache of request queue.
            mRequestQueue.getCache().clear();

            // below is the url from where we will be getting
            // our response in the json format.
            String url = "http://www.postalpincode.in/api/pincode/" + pinCode;

            // below line is use to initialize our request queue.
            RequestQueue queue = Volley.newRequestQueue(getContext());

            // in below line we are creating a
            // object request using volley.
            JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url,null, new com.android.volley.Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    // inside this method we will get two methods
                    // such as on response method
                    // inside on response method we are extracting
                    // data from the json format.
                    try {
                        // we are getting data of post office
                        // in the form of JSON file.
                        JSONArray postOfficeArray = response.getJSONArray("PostOffice");
                        if (response.getString("Status").equals("Error")) {
                            // validating if the response status is success or failure.
                            // in this method the response status is having error and
                            // we are setting text to TextView as invalid pincode.
//                            pinCodeDetailsTV.setText("Pin code is not valid.");
                            Toast.makeText(getContext(), "Pincode is not valid", Toast.LENGTH_SHORT).show();
                        } else {
                            // if the status is success we are calling this method
                            // in which we are getting data from post office object
                            // here we are calling first object of our json array.
                            JSONObject obj = postOfficeArray.getJSONObject(0);

                            // inside our json array we are getting district name,
                            // state and country from our data.
                            district = obj.getString("District");
                            state1 = obj.getString("State");
                            Toast.makeText(getContext(), state1, Toast.LENGTH_SHORT).show();
                            String country = obj.getString("Country");

                            // after getting all data we are setting this data in
                            // our text view on below line.
//                            pinCodeDetailsTV.setText("Details of pin code is : \n" + "District is : " + district + "\n" + "State : "
//                                    + state + "\n" + "Country : " + country);
                        }
                    } catch (JSONException e) {
                        // if we gets any error then it
                        // will be printed in log cat.
                        e.printStackTrace();
//                        pinCodeDetailsTV.setText("Pin code is not valid");
                        Toast.makeText(getContext(), "Pincode is not valid", Toast.LENGTH_SHORT).show();

                    }
                }
            }, new  com.android.volley.Response.ErrorListener()  {
                @Override
                public void onErrorResponse(VolleyError error) {
                    // below method is called if we get
                    // any error while fetching data from API.
                    // below line is use to display an error message.
                    Toast.makeText(getContext(), "Pin code is not valid.", Toast.LENGTH_SHORT).show();
//                    pinCodeDetailsTV.setText("Pin code is not valid");
                }
            });
            // below line is use for adding object
            // request to our request queue.
            queue.add(objectRequest);
        }


}