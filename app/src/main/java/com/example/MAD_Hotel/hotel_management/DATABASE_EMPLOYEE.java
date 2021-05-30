package com.example.MAD_Hotel.hotel_management;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DATABASE_EMPLOYEE extends SQLiteOpenHelper {
    public static final String DATABASE_name="EMP_database.db";
    //public static final String DATABASE2_name="EP_database.db";
    public static final String table11_name="EMP_table";

    public static final String COL1_name="EMP_ID";
    public static final String COL2_name="E_Name";
    public static final String COL3_name="D_Name";
    public static final String COL4_name="E_mobile";
    public static final String COL5_name="Salary";

    public DATABASE_EMPLOYEE(Context context) {
        super(context,DATABASE_name,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+table11_name+"(EMP_ID INTEGER PRIMARY KEY AUTOINCREMENT,E_Name Text,D_Name Text,E_mobile integer,Salary integer)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+table11_name);
        onCreate(db);
    }
    public  boolean insertvalue(String E_Name,String D_Name,String E_mobile,String Salary)
    {
        SQLiteDatabase db=DATABASE_EMPLOYEE.this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL2_name,E_Name);
        contentValues.put(COL3_name,D_Name);
        contentValues.put(COL4_name,E_mobile);
        contentValues.put(COL5_name,Salary);

        long result=db.insert(table11_name,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }


    public Cursor getALL()
    {
        SQLiteDatabase db=DATABASE_EMPLOYEE.this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+table11_name,null);
        return res;

    }



    public boolean update(String E_Name,String D_Name,String E_mobile,String Salary)
    {
        SQLiteDatabase db=DATABASE_EMPLOYEE.this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL2_name,E_Name);
        contentValues.put(COL3_name,D_Name);
        contentValues.put(COL4_name,E_mobile);

        contentValues.put(COL5_name,Salary);

        db.update(table11_name,contentValues,"E_Name=?",new String[]{E_Name});
        return true;

    }

    public Integer delete(String E_Name)
    {SQLiteDatabase db=DATABASE_EMPLOYEE.this.getWritableDatabase();
        return db.delete(table11_name,"E_Name=?",new String[] {E_Name});

    }

}
