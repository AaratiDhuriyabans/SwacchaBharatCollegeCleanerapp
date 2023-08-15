package com.example.collegecleanerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class viewrecord extends AppCompatActivity {
    DbManager db;
    EditText c1,c2,c3,c4,c5,c6;
    Button cb1,cb2,cb3;
    Boolean flag =true;
    DatePicker picker;
    TextView textview1;

    String s[] = {"BBA","BCA","MCS","MCA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewrecord);
        db=new DbManager(this);
        c1=findViewById(R.id.cc1);
        c2=findViewById(R.id.cc2);
        c3=findViewById(R.id.cc3);
        c4=findViewById(R.id.cc4);
         c5=findViewById(R.id.cc5);
        cb1=findViewById(R.id.Cb1);
        cb2=findViewById(R.id.Cb2);
        // cb3=findViewById(R.id.Cb3);
        textview1=findViewById(R.id.textView2);
        viewdata();
    }
    public void viewdata()
    {
        Cursor c=db.viewuploadRecord();
        if (c.getCount()==0)
        {
            Toast.makeText(this, "No have any data", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while((c.moveToNext()))
            {
                c1.setText(c.getInt(0)+"");
                c2.setText(c.getString(1));
                c3.setText(c.getString(2));
                c4.setText(c.getString(3));
                c5.setText(c.getString(4));
                textview1.setText(c.getString(5));

            }


        }
    }

    public void logout(View view) {
        Intent i2=new Intent(this,Main2Activity.class);
        startActivity(i2);
    }


    public void back(View view) {
        Intent iii=new Intent(this,viewcomplain.class);
        startActivity(iii);
    }
}

