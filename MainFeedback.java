package com.example.collegecleanerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainFeedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_feedback);
    }

    public void studentfeedback(View view) {
        Intent i1=new Intent(this,stud_feedback.class);
        startActivity(i1);
    }

    public void peonFeedback(View view) {
        Intent i2=new Intent(this,peon_feedback.class);
        startActivity(i2);
    }
}
