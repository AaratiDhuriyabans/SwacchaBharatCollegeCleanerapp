package com.example.collegecleanerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class main_regis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_regis);
    }

    public void studentregistration(View view) {
        Intent i1=new Intent(this, stud_regis.class);
        startActivity(i1);
        setResult(RESULT_OK,i1);
        finish();

    }

    public void Peonregistration(View view) {
        Intent i2=new Intent(this,peon_regis.class);
        startActivity(i2);
        setResult(RESULT_OK,i2);
        finish();

    }
}
