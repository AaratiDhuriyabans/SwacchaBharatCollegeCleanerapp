package com.example.collegecleanerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class peon_regis extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    EditText pp1, pp2, pp3, pp4, pp5, pp6;
    Button ptb1, ptb2, ptb3, ptb4;
    Boolean flag = true;
    Spinner sp1;
    String st;
   RadioGroup prg;
    RadioButton rb1, rb2;
    String s[] = {"BBA","BCA","MCS","MCA"};
    String f;
    String radiostr="";
    TextView radiotext;

String id,name,user,pass,conpass,gender,dept,mob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peon_regis);
        rb1 = findViewById(R.id.pr1);
        rb2 = findViewById(R.id.pr2);
        prg = findViewById(R.id.prg);
        pp1 = findViewById(R.id.p1);
        pp2 = findViewById(R.id.p2);
        pp3 = findViewById(R.id.p3);
        pp4 = findViewById(R.id.p4);
        pp5 = findViewById(R.id.p5);
        pp6 = findViewById(R.id.p6);
        ptb1=findViewById(R.id.ptb1);
        sp1 = findViewById(R.id.sp);
        sp1.setOnItemSelectedListener(this);
        ArrayAdapter a = new ArrayAdapter(this, android.R.layout.simple_spinner_item, s);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(a);
        ptb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id=pp1.getText().toString();
                name=pp2.getText().toString();
                user=pp3.getText().toString();
                pass=pp4.getText().toString();
                conpass=pp5.getText().toString();
                mob=pp6.getText().toString();
                if (pp1.getText().toString().isEmpty()) {
                    pp1.setError("Please Enter valid ID*");
                }
                else if (pp2.getText().toString().isEmpty()) {
                    pp2.setError("Name cannot be empty*");
                }
                else if (pp3.getText().toString().isEmpty()) {
                    pp3.setError("invalid UserName*");
                }
                else if (pp4.getText().toString().equals(" ")!=pp5.getText().toString().equals(" ")) {
                    pp4.setError("password and confirm password should be same*");
                    pp5.setError("please enter same*");
                }                else if (!(pp6.getText().length() == 10)) {
                    pp6.setError("MobNo. must be 10 characters");
                }

                ///  else if (!email.matches("([\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Za-z]{0,9})")) {
                //   e3.setError("invalid Email");
                // }
                else {
                    saveRecord(view);

                }
            }

        });

    }
    public void onItemSelected(AdapterView<?> av, View v, int position1, long index1) {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView<?> av) {

    }

    public boolean isCheck() {
        if (pp1.getText().toString().isEmpty() || pp1.getText().toString() == " ") {
            flag = false;
            pp1.setError("Enter your ID*");
        }
        if (pp2.getText().toString().isEmpty() || pp2.getText().toString() == " ") {
            flag = false;
            pp2.setError("Enter your Name*");
        }
        if (pp3.getText().toString().isEmpty() || pp3.getText().toString() == " ") {
            flag = false;
            pp3.setError("Enter UserName*");

        }
        if (pp4.getText().toString().equals("") && pp5.getText().toString().equals("")) {
            //  Toast.makeText(this, "User Login Successfully", Toast.LENGTH_SHORT).show();
            pp4.setError("Re-enter password*");
        }

        if (pp6.getText().toString().isEmpty() || pp6.getText().toString() == " ")
        {
            flag = false;
      //      if (isValid(f))
                Toast.makeText(this, "Valid Number", Toast.LENGTH_SHORT).show();
                //   System.out.println("Valid Number");
        //    else
          //      pp6.setError("Invalid Number");
        }
        pp6.setError("Enter Your Mobile Number*");


        return flag;
    }
    public void saveRecord(View view) {

        try {

            DbManager db = new DbManager(this);
            String str = db.saveRecord(pp1.getText().toString() ,pp2.getText().toString(),pp3.getText().toString() ,pp4.getText().toString() ,pp5.getText().toString(),radiostr,sp1.getSelectedItem().toString() ,pp6.getText().toString());
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
            Toast.makeText(this,"record added successfully....", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){ }

        Intent i1=new Intent(this,peon_login.class);
        startActivity(i1);

    }

    public void updateRecord(View view) {


        try
        {
            DbManager db= new DbManager(this);
            String str = db.updateRecord(pp1.getText().toString(), pp2.getText().toString(),pp3.getText().toString(),pp4.getText().toString(),pp5.getText().toString(),radiostr,sp1.getSelectedItem().toString(), pp6.getText().toString());
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
            Toast.makeText(this,"Users data updated successfully", Toast.LENGTH_LONG).show();
        }
        catch (Exception e) { }
        Intent i2=new Intent(this,peon_login.class);
        startActivity(i2);

    }



    public void deleteRecord(View view) {
        try{
            DbManager d=new DbManager(this);
            String str=d.deleteRecord(pp1.getText().toString());
            Toast.makeText(this,"users data deleted successfully",Toast.LENGTH_LONG).show();

        }catch(Exception e){}
        Intent i3=new Intent(this,Main2Activity.class);
        startActivity(i3);
    }

    public void Cancel(View view) {
        Intent i4=new Intent(this,Main2Activity.class);
        startActivity(i4);

    }

    public void radiobuttonClicked(View view) {
        switch (view.getId()) {
            case R.id.pr1:
                radiostr = rb1.getText().toString();
                Toast.makeText(this, radiostr, Toast.LENGTH_SHORT).show();
                break;
            case R.id.pr2:
                radiostr=rb2.getText().toString();
                Toast.makeText(this, radiostr, Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
