package com.example.apnicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.apnicare.ModelResponses.UpdateUser.UpdateUserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class User_Profile extends AppCompatActivity {
    EditText firstName,lastName,Email;
    RadioButton gender;
    Button save;
    SharedPrefManager sharedPrefManager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_user_profile);
        firstName=findViewById(R.id.userfirstName);
        lastName=findViewById(R.id.userlastName);
        Email=findViewById(R.id.emailUser);
        save=findViewById(R.id.saveUser);
        sharedPrefManager=new SharedPrefManager(getApplicationContext());
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveUser();
            }
        });
        //backbtn
        toolbar=findViewById(R.id.profilebackbtn);
        toolbar.setNavigationOnClickListener(view -> {
            finish();
        });
    }

    private void SaveUser() {
        String fName=firstName.getText().toString();
        String lName=lastName.getText().toString();
        String email=Email.getText().toString();
        Call<UpdateUserResponse> call=RetrofitClient.getInstance().getApi().user(fName,lName,"M",email,"Bearer "+sharedPrefManager.getData().getAccessToken());
        call.enqueue(new Callback<UpdateUserResponse>() {
            @Override
            public void onResponse(Call<UpdateUserResponse> call, Response<UpdateUserResponse> response) {
                UpdateUserResponse updateUserResponse=response.body();
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Profile Updated",Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(getApplicationContext(),"Email Already Registerd",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<UpdateUserResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}