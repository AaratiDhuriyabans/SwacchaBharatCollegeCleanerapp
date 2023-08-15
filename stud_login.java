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

public class stud_login extends AppCompatActivity {
EditText l1,l2;
Button b1;
Boolean flag=true;
String user,pas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud_login);
        l1=findViewById(R.id.l1);
        l2=findViewById(R.id.l2);
        b1=findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user=l1.getText().toString();
                pas=l2.getText().toString();
                 if (l1.getText().toString().trim().isEmpty()) {
                    l1.setError("Please Enter valid Username*");
                }
                else if (l2.getText().toString().trim().isEmpty()) {
                    l2.setError("Please enter password*");
                }

                else {
                    sloginRecord(view);

                }
            }

        });

    }

    public void sloginRecord(View view) {
int f=0;
        DbManager db = new DbManager(this);

        SQLiteDatabase sq = db.getReadableDatabase();
        Cursor c = sq.rawQuery("select * from stud_regis", null);
        //c.moveToFirst();
        while(c.moveToNext()) {
          //  Toast.makeText(this, c.getString(2) + "   " + l1.getText().toString(), Toast.LENGTH_LONG).show();
            if (l1.getText().toString().equals(c.getString(2))) {
                f = 1;
                break;
            }
        }

           if(f==0)
           {
                           Intent i=new Intent(this,stud_regis.class);
                startActivity(i);
            }
            if(f==1)
            {
                Intent i=new Intent(this,complain.class);
                startActivity(i);

            }

            // c.moveToNext();



        try{
           // DbManager db=new DbManager(this);
            String str=db.sloginRecord(l1.getText().toString(),l2.getText().toString());
           Toast.makeText(this,str,Toast.LENGTH_LONG).show();
        }catch (Exception e){}



    }

    public void scancel(View view) {

            Intent i2 = new Intent(this, Main2Activity.class);
           startActivity(i2);
        setResult(RESULT_OK,i2);
        finish();

    }
}
