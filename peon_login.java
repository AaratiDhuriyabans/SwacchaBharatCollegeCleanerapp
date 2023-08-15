package com.example.collegecleanerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class peon_login extends AppCompatActivity {
EditText ll1,ll2;
Boolean flag=true;
String user,pass;
Button bb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peon_login);
        ll1=findViewById(R.id.ll1);
        ll2=findViewById(R.id.ll2);
        bb1=findViewById(R.id.peonb1);
        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user=ll1.getText().toString();
                pass=ll2.getText().toString();
                if (ll1.getText().toString().trim().isEmpty()) {
                    ll1.setError("Please Enter valid Username*");
                }
                else if (ll2.getText().toString().trim().isEmpty()) {
                    ll2.setError("Please enter password*");
                }

                else {
                    plogin_Record(view);

                }
            }

        });



    }

    public void plogin_Record(View view) {

        DbManager db = new DbManager(this);



        try{
           // DbManager db = new DbManager(this);
            String str = db.ploginRecord(ll1.getText().toString(),ll2.getText().toString());
            Toast.makeText(this,str, Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) { }


      //  if (ll1.getText().toString().equals("admin") && ll2.getText().toString().equals("admin")) {
        //    Toast.makeText(this, "User Login Successfully", Toast.LENGTH_LONG).show();
       // }


Intent ii=new Intent(this,viewcomplain.class);
        startActivity(ii);

    }


    public void plogin_cancel(View view) {
        Toast.makeText(this, "You  are back", Toast.LENGTH_SHORT).show();
        Intent i2=new Intent(this,Main2Activity.class);
        startActivity(i2);
    }
}
