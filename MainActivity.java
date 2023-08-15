package com.example.collegecleanerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loginactivity(View view) {
        Intent i1=new Intent(this,mainlogin.class);
        startActivity(i1);
    }

    public void RegistrationActivity(View view) {
        Intent i2=new Intent(this,main_regis.class);
        startActivity(i2);
    }

    public void complainactivity(View view) {
        Intent i3=new Intent(this,complain.class);
        startActivity(i3);
    }

    public void viewcomplainactivity(View view) {
        Intent i4=new Intent(this,viewcomplain.class);
        startActivity(i4);
    }

    public void ComplainReport(View view) {
        Intent i5=new Intent();
    }

    public void ContactUs(View view) {
        Intent i6=new Intent(this,contactus.class);
        startActivity(i6);
    }

    public void Feedback(View view) {
        //Intent i7=new Intent(this,feedback.class);
       // startActivity(i7);
        Intent i9=new Intent(this,MainFeedback.class);
        startActivity(i9);
    }

    public void AboutUs(View view) {
        Intent i8=new Intent(this,aboutus.class);
        startActivity(i8);
    }
}
