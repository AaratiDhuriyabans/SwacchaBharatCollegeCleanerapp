package com.example.collegecleanerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class complain extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {
    EditText c1,c2,c3,c4,c5;
    Button cb1,cb2,cb3;
    Boolean flag =true;
    DatePicker picker;
    TextView textview1;
    Spinner cs;
    String rollno,name,block,classroom;

    String s[] = {"BBA","BCA","MCS","MCA"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);
        c1=findViewById(R.id.c1);
        c2=findViewById(R.id.c2);
        c3=findViewById(R.id.c3);
        c4=findViewById(R.id.c4);
        // c5=findViewById(R.id.c5);
        cb1=findViewById(R.id.Cb1);
        cb2=findViewById(R.id.Cb2);
        // cb3=findViewById(R.id.Cb3);
        cs = findViewById(R.id.cs);
        cs.setOnItemSelectedListener(this);
        ArrayAdapter a = new ArrayAdapter(this, android.R.layout.simple_spinner_item, s);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cs.setAdapter(a);
        textview1=(TextView)findViewById(R.id.textView1);
        picker=(DatePicker)findViewById(R.id.datePicker);
        textview1.setText("Current Date: "+getCurrentDate());
        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollno=c1.getText().toString();
                name=c2.getText().toString();
                block=c3.getText().toString();
                classroom=c4.getText().toString();
                if (c1.getText().toString().isEmpty()) {
                    c1.setError("Please Enter valid Roll Number*");
                }
                else if (c2.getText().toString().isEmpty()) {
                    c2.setError("Name cannot be empty*");
                }
                else if (c3.getText().toString().isEmpty()) {
                    c3.setError("invalid block*");
                }
                else if (c4.getText().toString().isEmpty()) {
                    c4.setError("Please enter classroom*");
                }

                else {
                    loadRecord(view);

                }
            }

        });

    }

    public String getCurrentDate() {
        StringBuilder builder=new StringBuilder();;
        builder.append((picker.getMonth() + 1)+"/");//month is 0 based
        builder.append(picker.getDayOfMonth()+"/");
        builder.append(picker.getYear());
        return builder.toString();
    }

    public void onItemSelected (AdapterView< ? > av, View v, int position1, long index1)
    {

    }
    public void onNothingSelected (AdapterView < ? > av)
    {

    }

    public void loadRecord(View view) {

        try {

            DbManager db = new DbManager(this);
            String str = db.loadRecord(c1.getText().toString() ,c2.getText().toString(),c3.getText().toString() ,c4.getText().toString() ,cs.getSelectedItem().toString(),textview1.getText().toString());
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
            Toast.makeText(this,"record added successfully", Toast.LENGTH_LONG).show();
        }
        catch (Exception e){ }


        Intent i1=new Intent(this,Main2Activity.class);
       startActivity(i1);
        Toast.makeText(this, " logout sucessfully", Toast.LENGTH_LONG).show();
        setResult(RESULT_OK,i1);
        finish();

    }

    public void logout(View view) {
        Intent i2=new Intent(this,Main2Activity.class);
        startActivity(i2);
        setResult(RESULT_OK,i2);
        finish();

    }


    public void complainshare(View view) {
        Intent i=new Intent(Intent.ACTION_SEND);
        String s=c1.getText().toString();
        String s2=c2.getText().toString();
        String s3=c3.getText().toString();
        String s4=c4.getText().toString();
        String s5=cs.getSelectedItem().toString();
        String s6=textview1.getText().toString();
        String finalstring="\n*****Complaint*****\nRoll No :"+s+"\nName :"+s2+"\nBlock :"+s3+"\nClassroom :"+s4+"\nDepartment :"+s5+"\n"+s6;
        i.setType("text/plain/images/.jpg");
        i.putExtra(Intent.EXTRA_TEXT,finalstring);
        startActivity( Intent.createChooser(i,"share via"));

    }
}

