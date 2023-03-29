package com.example.apnicare;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.apnicare.ModelResponses.UpdateUser.UpdateUserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class User_Profile extends AppCompatActivity {
    EditText firstName,lastName,Email,dob2,PhoneNumber;
    RadioButton gender;
    Button save;
    SharedPrefManager sharedPrefManager;
    Toolbar toolbar;
    AwesomeValidation AwesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_user_profile);
        firstName=findViewById(R.id.userfirstName); // First Name
        lastName=findViewById(R.id.userlastName); // LastName
        Email=findViewById(R.id.emailUser);
        PhoneNumber =findViewById(R.id.phn_number);
        dob2 = findViewById(R.id.dob);
        save=findViewById(R.id.saveUser);
        sharedPrefManager=new SharedPrefManager(getApplicationContext());
        firstName.setText(""+sharedPrefManager.getData().getFirstName());
        lastName.setText(""+sharedPrefManager.getData().getLastName());
        Email.setText(""+sharedPrefManager.getData().getEmail());
    // Form Validation Code
        AwesomeValidation = new AwesomeValidation(BASIC);
        AwesomeValidation.addValidation( this, R.id.userfirstName, RegexTemplate.NOT_EMPTY,R.string.invalidName);
        AwesomeValidation.addValidation( this, R.id.userlastName, RegexTemplate.NOT_EMPTY,R.string.invalidName);
        AwesomeValidation.addValidation( this, R.id.emailUser, Patterns.EMAIL_ADDRESS,R.string.invalidEmail);
        AwesomeValidation.addValidation( this, R.id.phn_number,"[5-9]{1}[0-9]{9}",R.string.invalidNumber);
        AwesomeValidation.addValidation( this, R.id.dob,"(0?[1-9]|1[012]) [/.-] (0?[1-9]|[12][0-9]|3[01]) [/.-] ((19|20)\\\\d\\\\d)",R.string.invalidDOb);
//        AwesomeValidation.addValidation( jis activity me krna hai, jis element pe lagaana hai, kya check krna hai (regex), error message);




        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AwesomeValidation.validate()){
                    Toast.makeText(getApplicationContext(),"Valid Details",Toast.LENGTH_SHORT).show();

                    SaveUser();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Enter Valid Details",Toast.LENGTH_SHORT).show();
                }
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
                    sharedPrefManager.updateUser(updateUserResponse.getDataUser());

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