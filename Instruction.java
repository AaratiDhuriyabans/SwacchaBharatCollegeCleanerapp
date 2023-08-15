package com.example.collegecleanerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Instruction extends AppCompatActivity {
WebView w4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
        w4=findViewById(R.id.w4);
        // w1.loadUrl("file:///andriod_assets/AboutUs.html");
        w4.loadUrl("file:///android_asset/AboutUs.html");

    }
}
