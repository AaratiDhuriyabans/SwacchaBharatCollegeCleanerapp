package com.example.collegecleanerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class viewcomplain extends AppCompatActivity {
    EditText tt1;
    TextView tt2;
    Button vb1;
    String id;
    String rollno,name,block,classroom,dept,date;
    DbManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcomplain);
      //tt2=findViewById(R.id.tt);
      vb1=findViewById(R.id.vb1);
      tt1=findViewById(R.id.tt1);
      //DbManager db;
        db=new DbManager(this);




    }

    public void uploadRecord1(View view) {
        DbManager db= new DbManager(this);
        String name = tt1.getText().toString();
        Intent ii=new Intent(this,viewrecord.class);
        startActivity(ii);
       }

  /*  public void deleteComplain(View view) {
        try{
            DbManager d=new DbManager(this);
            String str=d.delComplain(tt1.getText().toString());
            Toast.makeText(this,str,Toast.LENGTH_LONG).show();
          //  Toast.makeText(this, "complain deleted successfully.....", Toast.LENGTH_LONG).show();

        }catch(Exception e){}

        Intent i3=new Intent(this,viewcomplain.class);
        startActivity(i3);
        setResult(RESULT_OK,i3);
        finish();
          <Button
                    android:id="@+id/vb4"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="DELETE"
                    android:textColor="#E91E36"
                    android:textStyle="bold"
                    android:layout_below="@+id/vb1"
                    android:layout_marginTop="20dp"
                    android:textSize="20dp"
                    android:onClick="deleteComplain">
                </Button>


    }*/

    public void viewreport(View view) {
        DbManager db = new DbManager(this);

        SQLiteDatabase sq = db.getReadableDatabase();
        Cursor c = sq.rawQuery("select * from comp_table", null);
        if (c.getCount() != 0)
            c.moveToFirst();
        do {
            //    String s="";
            for (int i = 0; i < c.getColumnCount(); i++)
                rollno = "Rollno:" + c.getString(0);
            name = "Name:" + c.getString(1);
            block = "Block:" + c.getString(2);
            classroom = "Classroom:" + c.getString(3);
            dept = "Department:" + c.getString(4);
            date = "Date:" + c.getString(5);
            tt1.setText(tt1.getText()+"\n"+rollno+"\n"+name+"\n"+block+"\n"+classroom+"\n"+dept+"\n"+date+"\n"+"-----------------------");
           // tt2.setText(c.getString(2));
        }while(c.moveToNext());
       // Intent i4 = new Intent(this, complainreport.class);
      //  startActivity(i4);
    }

    public void searchRecord(View view) {

        Cursor c=db.searchRecord(Integer.parseInt(tt1.getText().toString())+" ");
        if(c.getCount()==0)
        {
            Toast.makeText(this, "Not Found*", Toast.LENGTH_SHORT).show();
        }
        else
            while(c.moveToNext())
            {
                tt1.setText(c.getString(0));
                tt1.setText(c.getString(1));
                tt1.setText(c.getString(2));
                tt1.setText(c.getString(3));
                tt1.setText(c.getString(4));
                tt1.setText(c.getString(5));
            }
    }

    public void backview(View view) {
        Intent i =new Intent(this,Main2Activity.class);
        startActivity(i);
    }
}
