package com.example.apnicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apnicare.ModelResponses.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText num;
    Button btn;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        num=findViewById(R.id.editTextPhone);
        btn=findViewById(R.id.button);
        sharedPrefManager=new SharedPrefManager(getApplicationContext());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }
    private void registerUser() {
        String number=num.getText().toString();
        if(number.isEmpty()){
            num.requestFocus();
            num.setError("please enter number");
            Toast.makeText(LoginActivity.this,"enter correct number",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!Patterns.PHONE.matcher(number).matches()){
            num.requestFocus();
            num.setError("please enter a valid number");
            Toast.makeText(LoginActivity.this,"enter correct number",Toast.LENGTH_SHORT).show();
            return;
        }
        Call<RegisterResponse> call= RetrofitClient
                .getInstance()
                .getApi()
                .register(number);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                RegisterResponse registerResponse=response.body();
                if(response.isSuccessful()){

//                    Toast.makeText(LoginActivity.this,"login succes",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, enter_otp_Activity.class);
                    intent.putExtra("Phone", number);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
//                Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        if(sharedPrefManager.isLoggedIn()){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}