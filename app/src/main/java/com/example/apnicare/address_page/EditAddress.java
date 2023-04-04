package com.example.apnicare.address_page;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.apnicare.AllAdapters.SelectAddressAdapter;
import com.example.apnicare.ModelResponses.Address.Datum;
import com.example.apnicare.ModelResponses.EditAddress.EditAddressResponse;
import com.example.apnicare.R;
import com.example.apnicare.RetrofitClient;
import com.example.apnicare.SharedPrefManager;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EditAddress extends AppCompatActivity {
    TextInputEditText name,address1,address2,phone,pincode,city,state;
    Button save;
    Toolbar toolbar;
    SharedPrefManager sharedPrefManager;
    private RequestQueue mRequestQueue;
    String district,state1;
    FloatingActionButton floatingActionButton;
    SelectAddressAdapter selectAddressAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_edit_address);
        name=findViewById(R.id.recipientsname);
        sharedPrefManager=new SharedPrefManager(getApplicationContext());

        toolbar=findViewById(R.id.NewAddtoolbar);
        address1=findViewById(R.id.addressLine1);
        city=findViewById(R.id.citydropmenu);
        state=findViewById(R.id.statedropmenu);
        address2=findViewById(R.id.addressLine2);
        pincode=findViewById(R.id.pincode123);
        phone=findViewById(R.id.phoneNumber);
        save=findViewById(R.id.saveaddress);
        mRequestQueue = Volley.newRequestQueue(getApplicationContext());


        /*adapteritems = new ArrayAdapter<String>(getApplicationContext(),R.layout.dropmenu_list,items);
        state.setAdapter(adapteritems);*/


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pincode1 = pincode.getText().toString();
//                getDataFromPinCode(pincode1);
                if (!TextUtils.isEmpty(pincode1)) {
                    addAddress(pincode1);
                }
            }
        });
        toolbar.setNavigationOnClickListener(view1 -> {
            finish();
        });

    }

    private void addAddress(String pincode1) {
        String name1 = name.getText().toString();
        String phone1 = phone.getText().toString();
        String address11 = address1.getText().toString();
        String address21 = address2.getText().toString();


        try {
            if (phone1.isEmpty()) {
                phone.requestFocus();
                phone.setError("please enter number");
                Toast.makeText(getApplicationContext(), "enter correct number", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!Patterns.PHONE.matcher(phone1).matches()) {
                phone.requestFocus();
                phone.setError("please enter a valid number");
                Toast.makeText(getApplicationContext(), "enter correct number", Toast.LENGTH_SHORT).show();
                return;
            }


            Call<EditAddressResponse> call = RetrofitClient.getInstance().getApi()
                    .editaddress("Bearer " + sharedPrefManager.getData().getAccessToken(), name1, phone1, address11, address21, "Hirdaipur Madaula", "Uttar Pradesh", pincode1, pincode1,28.855450,77.607803,true);
            call.enqueue(new Callback<EditAddressResponse>() {
                @Override
                public void onResponse(Call<EditAddressResponse> call, Response<EditAddressResponse> response) {
                    EditAddressResponse editAddressResponse =response.body();
//                    Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    if (response.isSuccessful()){
                        Toast.makeText(getApplicationContext(), "Address added", Toast.LENGTH_SHORT).show();

                    }

                }

                @Override
                public void onFailure(Call<EditAddressResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),""+ t.getMessage(), Toast.LENGTH_SHORT).show();


                }
            });
        } catch (Exception f) {
            System.out.println("some error at EditAddress.java" + f);
        }
    }

        private void getDataFromPinCode(String pinCode) {

            // clearing our cache of request queue.
            mRequestQueue.getCache().clear();

            // below is the url from where we will be getting
            // our response in the json format.
            String url = "http://www.postalpincode.in/api/pincode/" + pinCode;

            // below line is use to initialize our request queue.
            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

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
                            Toast.makeText(getApplicationContext(), "Pincode is not valid", Toast.LENGTH_SHORT).show();
                        } else {
                            // if the status is success we are calling this method
                            // in which we are getting data from post office object
                            // here we are calling first object of our json array.
                            JSONObject obj = postOfficeArray.getJSONObject(0);

                            // inside our json array we are getting district name,
                            // state and country from our data.
                            district = obj.getString("District");
                            state1 = obj.getString("State");
                            Toast.makeText(getApplicationContext(), state1, Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(getApplicationContext(), "Pincode is not valid", Toast.LENGTH_SHORT).show();

                    }
                }
            }, new  com.android.volley.Response.ErrorListener()  {
                @Override
                public void onErrorResponse(VolleyError error) {
                    // below method is called if we get
                    // any error while fetching data from API.
                    // below line is use to display an error message.
                    Toast.makeText(getApplicationContext(), "Pin code is not valid.", Toast.LENGTH_SHORT).show();
//                    pinCodeDetailsTV.setText("Pin code is not valid");
                }
            });
            // below line is use for adding object
            // request to our request queue.
            queue.add(objectRequest);
        }


}