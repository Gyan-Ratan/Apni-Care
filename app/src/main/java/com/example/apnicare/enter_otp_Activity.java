package com.example.apnicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apnicare.ModelResponses.LoginResponse;
import com.example.apnicare.ModelResponses.ResendOtp.ResendOtp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class enter_otp_Activity extends AppCompatActivity {
    EditText otp1,otp2,otp3,otp4;
    Button submitOtp;
    SharedPrefManager sharedPrefManager;
    String  otp;
    TextView phn_number_otp,resendOtp;

    String phn_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_otp);
        phn_number_otp=findViewById(R.id.phone_Number_otp);
        otp1=findViewById(R.id.code1);
        otp2=findViewById(R.id.code2);
        otp3=findViewById(R.id.code3);
        otp4=findViewById(R.id.code4);
        submitOtp =findViewById(R.id.submit_otp_button);
        resendOtp=findViewById(R.id.resend_otp);
        Intent intent=getIntent();
        phn_number=intent.getStringExtra("Phone");
        phn_number_otp.setText(phn_number);
        sharedPrefManager=new SharedPrefManager(getApplicationContext());
        setUpOtpInputs();

        submitOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otp= otp1.getText().toString()+otp2.getText().toString()+otp3.getText().toString()+otp4.getText().toString();
                userLogin();

            }
        });
        resendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resentOtp();
            }
        });
    }

    private void setUpOtpInputs() {
        otp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty()){
                    otp2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        otp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty()){
                    otp3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        otp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty()){
                    otp4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        otp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty()){
                    otp4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void userLogin() {
        String number=phn_number;
        int ot=Integer.parseInt(otp);

        Call<LoginResponse> call= RetrofitClient.getInstance().getApi().login(number,ot);
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
                Toast.makeText(enter_otp_Activity.this,"Error",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void resentOtp() {
        String number=phn_number;
        Call<ResendOtp> call= RetrofitClient.getInstance().getApi().resend(number);
        call.enqueue(new Callback<ResendOtp>() {
            @Override
            public void onResponse(Call<ResendOtp> call, Response<ResendOtp> response) {
                ResendOtp resendOtp=response.body();
                if(response.isSuccessful()){
                    Toast.makeText(enter_otp_Activity.this,"OTP sended to "+number,Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResendOtp> call, Throwable t) {
                Toast.makeText(enter_otp_Activity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}