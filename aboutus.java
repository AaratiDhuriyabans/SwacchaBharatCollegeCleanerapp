package com.example.collegecleanerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class aboutus extends AppCompatActivity {
WebView w1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        w1=findViewById(R.id.w1);
        w1.loadUrl("file:///android_asset/AboutUs.html");

    }
}
