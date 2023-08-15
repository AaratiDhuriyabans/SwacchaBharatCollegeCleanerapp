package com.example.collegecleanerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class mainlogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlogin);
    }


    public void mlb(View view) {
        Intent i1=new Intent(this,stud_login.class);
        startActivity(i1);
    }

    public void mlbb(View view) {
        Intent i2=new Intent(this,peon_login.class);
        startActivity(i2);
    }
}
