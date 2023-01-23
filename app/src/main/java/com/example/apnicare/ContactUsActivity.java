package com.example.apnicare;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
    private WebView mywebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        myWebView = new WebView(getApplicationContext());
//        setContentView(myWebView);
        setContentView(R.layout.activity_contact_us);
        mywebView=(WebView) findViewById(R.id.web);
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://dev.apnicare.in/terms");
        WebSettings webSettings=mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mywebView.setWebViewClient(new MyWebClient());
//                                   {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                return super.shouldOverrideUrlLoading(view, request);
//            }
//        });




//        WebView myWebView = (WebView) findViewById(R.id.web);
//        myWebView.loadUrl("http://www.google.com");

//
//        first = findViewById(R.id.firstName);
//        last = findViewById(R.id.lastName);
//        email = findViewById(R.id.email);
//        phone = findViewById(R.id.phone);
//        subject = findViewById(R.id.subject);
//        message = findViewById(R.id.message1);
//        submit = findViewById(R.id.submit);
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                submitrequest();
//            }
//        });

    }

//    private void submitrequest() {
//        String first1 = first.getText().toString();
//        String last1 = last.getText().toString();
//        String email1 = email.getText().toString();
//        String phone1 = phone.getText().toString();
//        String subject1 = subject.getText().toString();
//        String message1 = message.getText().toString();
//        Call<ContactResponse> call = RetrofitClient.getInstance().getApi().contact(first1, last1, email1, phone1, subject1, message1);
//        call.enqueue(new Callback<ContactResponse>() {
//            @Override
//            public void onResponse(Call<ContactResponse> call, Response<ContactResponse> response) {
//                ContactResponse contactResponse = response.body();
//                if (response.isSuccessful()) {
//                    Toast.makeText(getApplicationContext(), contactResponse.getData().getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ContactResponse> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }




    public class MyWebClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
            super.onPageStarted(view,url,favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed(){
        if(mywebView.canGoBack()) {
            mywebView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }


}