package com.example.apnicare.Upload_Prescription;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.apnicare.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class sprescription extends AppCompatActivity {

    ConstraintLayout layout;
    Button arrowBtn;
    FloatingActionButton btn;
    CardView expandableView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderprescription);
        expandableView = findViewById(R.id.attachView);
        arrowBtn = findViewById(R.id.attach);
        layout = findViewById(R.id.ConstraintLayout);
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

    }
}
