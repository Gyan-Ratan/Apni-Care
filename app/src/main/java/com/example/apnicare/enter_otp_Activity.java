package com.example.apnicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apnicare.ModelResponses.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class enter_otp_Activity extends AppCompatActivity {
    EditText phn,otp;
    Button btn2;
    SharedPrefManager sharedPrefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_otp);
        phn=findViewById(R.id.editTextPhone2);
        otp=findViewById(R.id.editTextNumberPassword);
        btn2=findViewById(R.id.button2);
        sharedPrefManager=new SharedPrefManager(getApplicationContext());

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });
    }
    private void userLogin() {
        String number=phn.getText().toString();
        int otp1= Integer.parseInt(otp.getText().toString());
        if(number.isEmpty()){
            phn.requestFocus();
            phn.setError("please enter number");
            Toast.makeText(enter_otp_Activity.this,"enter correct number",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!Patterns.PHONE.matcher(number).matches()){
            phn.requestFocus();
            phn.setError("please enter a valid number");
            Toast.makeText(enter_otp_Activity.this,"enter correct number",Toast.LENGTH_SHORT).show();
            return;
        }
        Call<LoginResponse> call= RetrofitClient.getInstance().getApi().login(number,otp1);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse= response.body();
                if (response.isSuccessful()){

                    sharedPrefManager.saveUser(loginResponse.getData());
                    Intent intent = new Intent(enter_otp_Activity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
}