package com.example.collegecleanerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class stud_feedback extends AppCompatActivity {
EditText f1,f2,f3,f4,f5;
Button sf1;
String rollno,name,mobno,suggestions,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud_feedback);
        f1=findViewById(R.id.f1);
        f2=findViewById(R.id.f2);
        f3=findViewById(R.id.f3);
        f4=findViewById(R.id.f4);
        f5=findViewById(R.id.f5);
        sf1=findViewById(R.id.sf1);
        sf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollno=f1.getText().toString();
                name=f2.getText().toString();
                mobno=f3.getText().toString();
                suggestions=f4.getText().toString();
                email=f5.getText().toString();
                if (f1.getText().toString().isEmpty()) {
                    f1.setError("Please Enter valid Roll Number*");
                }
                else if (f2.getText().toString().isEmpty()) {
                    f2.setError("Name cannot be empty*");
                }
                else if (!(f3.getText().length() == 10)) {
                    f3.setError("MobNo. must be 10 characters");
                }

                else if (f4.getText().toString().isEmpty()&&f4.getText().toString().equals(" ")) {
                    f4.setError("invalid suggestion*");
                }
                else if (!email.matches("([\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Za-z]{0,9})")) {
                      f5.setError("invalid Email");
                     }
                else {
                    studentsend(view);

                }
            }

        });
    }
    public void studentsend(View view) {
        Intent i1=new Intent(this,Main2Activity.class);
        try {

            DbManager db = new DbManager(this);
            String str = db.studentsend(f1.getText().toString() ,f2.getText().toString(),f3.getText().toString() ,f4.getText().toString() ,f5.getText().toString());
            Toast.makeText( this,str, Toast.LENGTH_LONG).show();
            //Toast.makeText(this,"record added successfully....", Toast.LENGTH_LONG).show();
        }
        catch (Exception ee){ }
startActivity(i1);
        setResult(RESULT_OK,i1);
        finish();

    }

    public void studentshare(View view) {
        Intent i=new Intent(Intent.ACTION_SEND);
        String s=f1.getText().toString();
        String s2=f2.getText().toString();
        String s3=f3.getText().toString();
        String s4=f4.getText().toString();
        String s5=f5.getText().toString();
        String finalstring="\n*****Student Feedback*****\nRollno:"+s+"\nName:"+s2+"\nMobile Number:"+s3+"\nSuggestions:"+s4+"\nEmail:"+s5;
        i.setType("text/plain/images/.jpg");
        i.putExtra(Intent.EXTRA_TEXT,finalstring);
        startActivity( Intent.createChooser(i,"share via"));

    }

    public void backfeedback(View view) {
        Intent ii=new Intent(this,Main2Activity.class);
        startActivity(ii);
    }
}
