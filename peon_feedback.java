package com.example.collegecleanerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class peon_feedback extends AppCompatActivity {
EditText pp1,pp2,pp3,pp4,pp5;
Button pbb1;
String id,name,mobno,suggestions,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peon_feedback);
        pp1=findViewById(R.id.pp1);
        pp2=findViewById(R.id.pp2);
        pp3=findViewById(R.id.pp3);
        pp4=findViewById(R.id.pp4);
        pp5=findViewById(R.id.pp5);
        pbb1=findViewById(R.id.pbb1);
        pbb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id=pp1.getText().toString();
                name=pp2.getText().toString();
                mobno=pp3.getText().toString();
                suggestions=pp4.getText().toString();
                email=pp5.getText().toString();
                if (pp1.getText().toString().isEmpty()) {
                    pp1.setError("Please Enter valid ID*");
                }
                else if (pp2.getText().toString().isEmpty()) {
                    pp2.setError("Name cannot be empty*");
                }
                else if (!(pp3.getText().length() == 10)) {
                    pp3.setError("MobNo. must be 10 characters");
                }

                else if (pp4.getText().toString().isEmpty()&&pp4.getText().toString().equals(" ")) {
                    pp4.setError("invalid suggestion*");
                }
                else if (!email.matches("([\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Za-z]{0,9})")) {
                    pp5.setError("invalid Email");
                }
                else {
                    peonsend(view);

                }
            }

        });

    }

    public void peonsend(View view) {
        Intent i1=new Intent(this,Main2Activity.class);

        try {
              DbManager db = new DbManager(this);
            String str = db.peonsend(pp1.getText().toString() ,pp2.getText().toString(),pp3.getText().toString() ,pp4.getText().toString() ,pp5.getText().toString());
            Toast.makeText( this,str, Toast.LENGTH_LONG).show();
            Toast.makeText(this,"record added successfully....", Toast.LENGTH_LONG).show();
        }
        catch (Exception ee){ }
startActivity(i1);
        setResult(RESULT_OK,i1);
        finish();


    }

    public void peonshare(View view) {
        Intent i=new Intent(Intent.ACTION_SEND);
        String s=pp1.getText().toString();
        String s2=pp2.getText().toString();
        String s3=pp3.getText().toString();
        String s4=pp4.getText().toString();
        String s5=pp5.getText().toString();
        String finalstring="\n*****Peon Feedback*****\nID :"+s+"\nName :"+s2+"\nMobile Number :"+s3+"\nSuggestions :"+s4+"\nEmail :"+s5;
        i.setType("text/plain/images/.jpg");
        i.putExtra(Intent.EXTRA_TEXT,finalstring);
        startActivity( Intent.createChooser(i,"share via"));

    }

    public void backpeon(View view) {
        Intent ii=new Intent(this,Main2Activity.class);
        startActivity(ii);
    }
}
