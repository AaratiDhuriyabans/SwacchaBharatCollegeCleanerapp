package com.example.collegecleanerapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DbManager extends SQLiteOpenHelper {
    public static final String dbname = "collegecleanerapp.db";
    // public static final String dbname1="peon.db";

    public DbManager(Context context) {
        super(context, dbname, null, 1); }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "create table stud_regis(rollno text,name text,username text,password text,confirm text,gender text,class text,division text,department text,mobno text)";
        db.execSQL(qry);

        String qry1="create table  peon_regis(ID text,name text,username text,password text,confirm text,gender text,department text,mobno text)";
        db.execSQL(qry1);

        String qryslog = "create table stud_login(username text,password text)";
        db.execSQL(qryslog);

        String qryplog="create table  peon_login(username text,password text)";
        db.execSQL(qryplog);

      String qry2="create table comp_table(rollno text,name text,block text,class text,department text ,date text)";
      db.execSQL(qry2);
      String qry3="create table feedback1(rollno text,name text, mobno text,suggestion text,email text)";
      db.execSQL(qry3);
      String qry4="create table feedback2(ID text,name text, mobno text,suggestion text,email text)";
        db.execSQL(qry4);


    }

    public String addRecord(String p1, String p2, String p3, String p4, String p5, String p6, String p7,String p8,String p9,String p10) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("rollno", p1);
        cv.put("name", p2);
        cv.put("userName", p3);
        cv.put("password", p4);
        cv.put("confirm", p5);
        cv.put("gender",p6);
        cv.put("class", p7);
        cv.put("division", p8);
        cv.put("department",p9);
        cv.put("mobno",p10);

        long res = db.insert("stud_regis", null, cv);
        db.close();
        if (res == -1)
            return "fails";
        else
            return "Successful";


    }
    public String saveRecord(String p1, String p2, String p3, String p4, String p5, String p6, String p7,String p8) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ID", p1);
        cv.put("name", p2);
        cv.put("userName", p3);
        cv.put("password", p4);
        cv.put("confirm", p5);
        cv.put("gender",p6);
        cv.put("department",p7);
        cv.put("mobno",p8);

        long res = db.insert("peon_regis", null, cv);
        db.close();
        if (res == -1)
            return "fails";
        else
            return "Successful";


    }
    public String loadRecord(String p1,String p2, String p3,String p4,String p5,String p6)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("rollno",p1);
        cv.put("name",p2);
        cv.put("block",p3);
        cv.put("class",p4);
        cv.put("department",p5);
        cv.put("date",p6);
        long res=db.insert("comp_table",null,cv);
        db.close();
        if(res==-1)
            return "fails";
        else
            return "successful";
    }

    public Cursor viewuploadRecord()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String q="select *from comp_table";
        Cursor c=db.rawQuery(q,null);
        return  c;
    }
    public Cursor searchStudent(String rollno)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String q="select *from stud_regis where id="+rollno ;
        Cursor c=db.rawQuery(q,null);
        return  c;
    }
    public Cursor searchPeon(String rollno)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String q="select *from peon_regis where id="+rollno ;
        Cursor c=db.rawQuery(q,null);
        return  c;
    }


    public Cursor searchRecord(String rollno)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String q="select *from comp_table where id="+rollno ;
        Cursor c=db.rawQuery(q,null);
        return  c;
    }

    public  String sloginRecord(String u,String p)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("username",u);
        cv.put("password",p);
        long res = db.insert("stud_login", null, cv);
        db.close();
        if (res == -1)
            return "fails";
        else
            return "Successful";

    }
    public  String ploginRecord(String u,String p)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("username",u);
        cv.put("password",p);
        long res = db.insert("peon_login", null, cv);
        db.close();
        if (res == -1)
            return "fails";
        else
            return "Successful";

    }
    public String delRecord(String p1) {

        SQLiteDatabase db = this.getWritableDatabase();
        long res = db.delete("stud_regis", "rollno=?", new String[]{p1});
        db.close();
        if (res == -1)

            return "failed";
        else
            return "Deleted Successfully";



    }
    public String deleteRecord(String r1) {
        SQLiteDatabase db = this.getWritableDatabase();

        long res = db.delete("peon_regis", "ID=?", new String[]{r1});
        db.close();
        if (res == -1)

            return "failed";
        else
            return "Deleted Successfully";



    }


    public String upRecord(String p1, String p2, String p3, String p4, String p5, String p6, String p7,String p8,String p9,String p10) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues updatevalues= new ContentValues();
        updatevalues.put("RollNo", p1);
        updatevalues.put("Name", p2);
        updatevalues.put("UserName", p3);
        updatevalues.put("Password", p4);
        updatevalues.put("ConfirmPassword", p5);
        updatevalues.put("Gender",p6);
        updatevalues.put("Class", p7);
        updatevalues.put("Division",p8);
        updatevalues.put("Department",p9);
        updatevalues.put("Mobile Number",p10);

        long  res=db.update("stud_regis",updatevalues ,"rollno=?",new String[]{p1});
        db.close();
        if (res == -1)

            return "not Updated*";
        else
            return "Updated Successfully.....";
    }
    public String updateRecord(String r1, String r2, String r3, String r4, String r5, String r6, String r7,String r8) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues updatevalues= new ContentValues();
        updatevalues.put("ID", r1);
        updatevalues.put("Name", r2);
        updatevalues.put("UserName", r3);
        updatevalues.put("Password", r4);
        updatevalues.put("ConfirmPassword", r5);
        updatevalues.put("Gender",r6);
        updatevalues.put("Department",r7);
        updatevalues.put("Mobile Number",r8);

        long  res=db.update("peon_regis",updatevalues ,"ID=?",new String[]{r1});
        db.close();
        if (res == -1)

            return "not Updated*";
        else
            return "Updated Successfully.....";
    }
    public String updateComplain(String s1,String s2,String s3,String s4,String s5,String s6)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("rollno",s1);
        cv.put("name",s2);
        cv.put("block",s3);
        cv.put("class",s4);
        cv.put("department",s5);
        cv.put("date",s6);
        long res=db.update("comp_table",cv,"rollno=?",new String []{s1});
        db.close();
        if(res==-1)
            return "fails";
        else
            return "successful";

    }

        // long res=db.SELECT *  FROM  comp_table;
         // FOR SEPCIFIC ONE RECORD
        // SELECT * FROM COMP_TABLE WHERE ID=1;

    public String delComplain(String r1) {
        SQLiteDatabase db = this.getWritableDatabase();

        long res = db.delete("comp_table", "rollno=?", new String[]{r1});
        db.close();
        if (res == -1)

            return "failed";
        else
            return "Deleted Successfully";



    }
    public String studentsend(String s1,String s2,String s3,String s4,String s5)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("rollno",s1);
        cv.put("name",s2);
        cv.put("mobno",s3);
        cv.put("suggestion",s4);
        cv.put("email",s5);
        long res = db.insert("feedback1", null, cv);
        db.close();
        if (res == -1)
            return "fails";
        else
            return "Successful";

    }
    public String peonsend(String p1,String p2,String p3,String p4,String p5)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("ID",p1);
        cv.put("name",p2);
        cv.put("mobno",p3);
        cv.put("suggestion",p4);
        cv.put("email",p5);
        long res = db.insert("feedback2", null, cv);
        db.close();
        if (res == -1)
            return "fails";
        else
            return "Successful";


    }

}


