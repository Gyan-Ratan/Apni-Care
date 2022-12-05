package com.example.apnicare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apnicare.ModelResponses.ContactUs.ContactResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactUsActivity extends AppCompatActivity {
    EditText first, last, email, phone, subject, message;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        first = findViewById(R.id.firstName);
        last = findViewById(R.id.lastName);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        subject = findViewById(R.id.subject);
        message = findViewById(R.id.message1);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitrequest();
            }
        });

    }

    private void submitrequest() {
        String first1 = first.getText().toString();
        String last1 = last.getText().toString();
        String email1 = email.getText().toString();
        String phone1 = phone.getText().toString();
        String subject1 = subject.getText().toString();
        String message1 = message.getText().toString();
        Call<ContactResponse> call = RetrofitClient.getInstance().getApi().contact(first1, last1, email1, phone1, subject1, message1);
        call.enqueue(new Callback<ContactResponse>() {
            @Override
            public void onResponse(Call<ContactResponse> call, Response<ContactResponse> response) {
                ContactResponse contactResponse = response.body();
                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), contactResponse.getData().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ContactResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}