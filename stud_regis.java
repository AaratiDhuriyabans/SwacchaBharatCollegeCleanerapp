package com.example.collegecleanerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class stud_regis extends AppCompatActivity  implements  AdapterView.OnItemSelectedListener {

    RadioButton rr1, rr2;
    RadioGroup rg;
    String s1;
    Spinner ss;
    Button stb1, stb2, stb3, stb4;
    String s[] = {"BBA","BCA","MCS","MCA"};
    EditText rs1, rs2, rs3, rs4, rs5,rs6,rs7,rs8,rs9;
    boolean flag = true;
    String radiostr1="";
    String rollno,name,username,password,confirmpassword,gender,cls,division,department,mobno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud_regis);
        rr1 = findViewById(R.id.r1);
        rr2 = findViewById(R.id.r2);
      //  rg = findViewById(R.id.rg);
        ss = findViewById(R.id.sp);
        rs1 = findViewById(R.id.rs1);
        rs2 = findViewById(R.id.rs2);
        rs3 = findViewById(R.id.rs3);
        rs4 = findViewById(R.id.rs4);
        rs5 = findViewById(R.id.rs5);
        rs6=findViewById(R.id.rs6);
        rs7=findViewById(R.id.rs7);
        rs8=findViewById(R.id.rs8);
        //rs9=findViewById(R.id.rs9);
        ss.setOnItemSelectedListener(this) ;
        ArrayAdapter a = new ArrayAdapter(this, android.R.layout.simple_spinner_item, s);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ss.setAdapter(a);
       // searchdata();
        stb1=findViewById(R.id.stb1);
        stb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollno=rs1.getText().toString();
                name=rs2.getText().toString();
                username=rs3.getText().toString();
                password=rs4.getText().toString();
                confirmpassword=rs5.getText().toString();
                cls=rs6.getText().toString();
                division=rs7.getText().toString();
                mobno=rs8.getText().toString();
                if (rs1.getText().toString().trim().isEmpty()) {
                    rs1.setError("Please Enter valid Roll Number*");
                }
                else if (rs2.getText().toString().isEmpty()) {
                    rs2.setError("Name cannot be empty*");
                }
                else if (rs3.getText().toString().isEmpty()) {
                    rs3.setError("invalid UserName*");
                }
                else if (rs4.getText().toString().equals(" ")!=rs5.getText().toString().equals("")) {
                    rs4.setError("password and confirm password should be same*");
                    rs5.setError("please enter same*");
                }
                else if (rs6.getText().toString().isEmpty()) {
                    rs6.setError("Please enter class*");
                }
                else if (rs7.getText().toString().isEmpty()) {
                    rs7.setError("invalid Division*");
                }
                else if (!(rs8.getText().length() == 10)) {
                    rs8.setError("MobNo. must be 10 characters");
                }

              ///  else if (!email.matches("([\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Za-z]{0,9})")) {
                 //   e3.setError("invalid Email");
               //  }
                                else {
                    addRecord(view);

                }
            }

        });

    }




    public void onItemSelected (AdapterView < ? > av, View v,int position1, long index1)
    {

    }
    public void onNothingSelected (AdapterView < ? > av)
    {

    }

    public void addRecord(View view) {

            try {

            DbManager db = new DbManager(this);
            String str = db.addRecord(rs1.getText().toString() ,rs2.getText().toString(),rs3.getText().toString() ,rs4.getText().toString() ,rs5.getText().toString(),radiostr1,rs6.getText().toString(),rs7.getText().toString(),ss.getSelectedItem().toString() ,rs8.getText().toString());
                Toast.makeText( this,str, Toast.LENGTH_LONG).show();
            Toast.makeText(this,"record added successfully....", Toast.LENGTH_LONG).show();
        }
        catch (Exception ee){ }

        Intent i1=new Intent(this,stud_login.class);
        startActivity(i1);
        setResult(RESULT_OK,i1);
        finish();


    }

    public void upRecord(View view) {


        try
        {
            DbManager db= new DbManager(this);
            String str = db.upRecord(rs1.getText().toString(),rs2.getText().toString(),rs3.getText().toString(),rs4.getText().toString(),rs5.getText().toString(), radiostr1 ,rs6.getText().toString(),rs7.getText().toString(),ss.getSelectedItem().toString(),rs8.getText().toString());
            Toast.makeText(this,str, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Updated Successfully.....", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) { }
        Intent i2=new Intent(this,stud_login.class);
        startActivity(i2);

    }
  /*  public void searchdata()
    {
        DbManager db=new DbManager(this);
        Cursor c=db.searchRecord();
        if(c.getCount()==0)
        {
            Toast.makeText(this, "Not found", Toast.LENGTH_SHORT).show();
        }
        else
            while ((c.moveToNext()))
            {
                rs1.setText(c.getString(0));
                rs2.setText(c.getString(1));
                rs3.setText(c.getString(2));
                rs4.setText(c.getString(3));
                rs5.setText(c.getString(4));
               // rg.setSelected(c.getString(4));
                rs6.setText(c.getString(6));
              rs7.setText(c.getString(7));
               // ss.dispatchSetSelected( c.getString(7));

                rs8.setText(c.getString(8));


            }
    }*/

    public void delRecord(View view) {
        try{
            DbManager d=new DbManager(this);
            String str=d.delRecord(rs1.getText().toString());
            Toast.makeText(this,str,Toast.LENGTH_LONG).show();

        }catch(Exception e){}

Intent i3=new Intent(this,Main2Activity.class);
        startActivity(i3);
    }
    public void studentcancel(View view)
    {
        Intent i4=new Intent(this,Main2Activity.class);
        startActivity(i4);
    }

    public void radioClicked(View view) {
        switch (view.getId()) {
            case R.id.r1:
                radiostr1 = rr1.getText().toString();

                Toast.makeText(this, radiostr1, Toast.LENGTH_SHORT).show();
                break;
            case R.id.r2:
                radiostr1=rr2.getText().toString();
                Toast.makeText(this, radiostr1, Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
