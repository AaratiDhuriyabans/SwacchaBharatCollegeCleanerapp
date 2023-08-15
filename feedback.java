package com.example.collegecleanerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class feedback extends AppCompatActivity {
WebView w3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        w3=findViewById(R.id.w3);
        w3.loadUrl("file:///android_asset/Feedback.html");


    }
}
