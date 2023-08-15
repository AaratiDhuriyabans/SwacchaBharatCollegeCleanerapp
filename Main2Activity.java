package com.example.collegecleanerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
WebView w5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        w5=findViewById(R.id.w5);
        w5.loadUrl("file:///android_asset/home.html");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf=getMenuInflater();
        inf.inflate(R.menu.menubar,menu);
       // return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.home:
                Intent i1=new Intent(this,Main2Activity.class);
                startActivity(i1);
                setResult(RESULT_OK,i1);
                finish();

                Toast.makeText(this, "home*", Toast.LENGTH_LONG).show();break;

            case R.id.registration:
                Intent i2=new Intent(this, main_regis.class);
                startActivity(i2);
                setResult(RESULT_OK,i2);
                finish();

                Toast.makeText(this, "registration*", Toast.LENGTH_LONG).show();break;
            case R.id.login:
                Intent i3=new Intent(this,mainlogin.class);
                startActivity(i3);
                setResult(RESULT_OK,i3);
                finish();

                Toast.makeText(this, "login*", Toast.LENGTH_LONG).show();break;
            case R.id.complainreport:
                Intent i4=new Intent(this,stud_login.class);
                startActivity(i4);
               // setResult(RESULT_OK,i4);
               // finish();

                Toast.makeText(this, "Complain*", Toast.LENGTH_LONG).show();break;
            case R.id.AboutUs:
                Intent i5=new Intent(this,aboutus.class);
                startActivity(i5);
              //  setResult(RESULT_OK,i5);
               // finish();

                Toast.makeText(this, "AboutUs*", Toast.LENGTH_SHORT).show();break;
            case R.id.contactus:
                Intent i6=new Intent(this,contactus.class);
                startActivity(i6);
                setResult(RESULT_OK,i6);
                finish();

                Toast.makeText(this, "ContactUs*", Toast.LENGTH_SHORT).show();break;
            case R.id.feedback:
                Intent i7=new Intent(this,MainFeedback.class);
                startActivity(i7);
                setResult(RESULT_OK,i7);
                finish();

                Toast.makeText(this, "Feedback*", Toast.LENGTH_SHORT).show();break;
            case R.id.logout:
                Intent i8=new Intent(this,mainlogin.class);
                startActivity(i8);
                setResult(RESULT_OK,i8);
                finish();

                Toast.makeText(this, "LogoutSuccessfully.....", Toast.LENGTH_SHORT).show();break;
        }
        return super.onOptionsItemSelected(item);
    }
}
