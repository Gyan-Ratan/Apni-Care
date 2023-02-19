package com.example.apnicare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class TempActivity extends AppCompatActivity {
    EditText name,qty;
    TextView text;
    Button button;
    CartPref cartPref;
    ArrayList<CartManager> cartManagerArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        name=findViewById(R.id.name_temp);
        qty=findViewById(R.id.qty_temp);
        button=findViewById(R.id.temp_id);
        cartPref=new CartPref(TempActivity.this);
        text=findViewById(R.id.te);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                cartPref.saveItem("Harshit","5");
            }
        });

        //        cartManagerArrayList=cartPref.loadData();
        //        if (cartManagerArrayList.isEmpty()){
        //            text.setText("No Data");
        //        }
        //        else {
        //            int a=0;
        //            for (a=0;a<cartManagerArrayList.size();a++){
        //              text.setText(cartManagerArrayList.get(a).itemName);
        //
        //            }
        //        }
    }
}