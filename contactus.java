package com.example.collegecleanerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class contactus extends AppCompatActivity {
WebView w2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        w2=findViewById(R.id.w2);
        w2.loadUrl("file:///android_asset/ContactUs.html");


    }
}
