package com.example.apnicare.Upload_Prescription;

import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.apnicare.Confirm_Order_Activity;
import com.example.apnicare.MainActivity;
import com.example.apnicare.R;
import com.example.apnicare.YourOrders.YourOrderConfirmedActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class sprescription extends AppCompatActivity {

    ConstraintLayout layout;
    Button arrowBtn,proceed;
    FloatingActionButton btn;
    CardView expandableView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderprescription);
        expandableView = findViewById(R.id.attachView);
        arrowBtn = findViewById(R.id.attach);
        layout = findViewById(R.id.ConstraintLayout);
        proceed=findViewById(R.id.materialButton);
        btn=findViewById(R.id.floatingActionButton);
        arrowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(layout, new AutoTransition());
                    expandableView.setVisibility(View.VISIBLE);
                    btn.setImageResource(R.drawable.arrow_down);

                } else {
                    TransitionManager.beginDelayedTransition(layout, new AutoTransition());
                    expandableView.setVisibility(View.GONE);
                    btn.setImageResource(R.drawable.arrow_up);
                }
            }
        });
        proceed.setOnClickListener(view -> {
            Intent intent = new Intent(sprescription.this, YourOrderConfirmedActivity.class);
            startActivity(intent);
        });

    }
}
