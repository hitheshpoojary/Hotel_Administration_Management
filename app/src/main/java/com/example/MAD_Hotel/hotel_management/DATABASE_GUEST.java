package com.example.MAD_Hotel.hotel_management;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DATABASE_GUEST extends SQLiteOpenHelper {
    public static final String Database_name="Guest_database.db";
    public static final String table_name="Guest_table";
    public static final String table2_name="OLD_Guest_table";
    public static final String col1_name="Guest_ID";
    public static final String col2_name="Guest_Name";
    public static final String col3_name="G_mobile_no";
    public static final String col4_name="Check_in_date";
    public static final String col9_name="Check_out_date";
    public static final String col5_name="Room_no";
    public static final String col6_name="Room_type";
    public static final String col7_name="Services1";
    public static final String col8_name="Services2";
    public DATABASE_GUEST(Context context)

    {
        super(context,Database_name,null,1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+table_name+"(Guest_ID INTEGER PRIMARY KEY AUTOINCREMENT,Guest_Name Text,G_mobile_no integer,Check_in_date integer,Check_out_date integer,Room_no Integer,Room_type Text,Services1 Text,Services2 Text )");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+table_name);
        onCreate(db);

    }
    public  boolean insertData(String Guest_Name,String G_mobile_no,String Check_in_date,String Check_out_date,String Room_no,String Room_type,String Services1,String Services2)
    {
        SQLiteDatabase db=DATABASE_GUEST.this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2_name,Guest_Name);
        contentValues.put(col3_name,G_mobile_no);
        contentValues.put(col4_name,Check_in_date);
        contentValues.put(col9_name,Check_out_date);
        contentValues.put(col5_name,Room_no);
        contentValues.put(col6_name,Room_type);
        contentValues.put(col7_name,Services1);
        contentValues.put(col8_name,Services2);
        long result=db.insert(table_name,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
    public Cursor getALLData()
    {
        SQLiteDatabase db=DATABASE_GUEST.this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+table_name,null);
        return res;

    }
    public boolean updatedata(String Guest_Name,String G_mobile_no,String Check_in_date,String Check_out_date,String Room_no,String Room_type,String Services1,String Services2)
    {
        SQLiteDatabase db=DATABASE_GUEST.this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2_name,Guest_Name);
        contentValues.put(col3_name,G_mobile_no);
        contentValues.put(col4_name,Check_in_date);
        contentValues.put(col9_name,Check_out_date);
        contentValues.put(col5_name,Room_no);
        contentValues.put(col6_name,Room_type);
        contentValues.put(col7_name,Services1);
        contentValues.put(col8_name,Services2);
        //all update are done based on the user name
        db.update(table_name,contentValues,"Guest_Name=?",new String[]{Guest_Name});
        return true;

    }
    public Integer deletefunc(String G_Name)
    {SQLiteDatabase db=DATABASE_GUEST.this.getWritableDatabase();
    //user info is deleted based on the user name
        return db.delete(table_name,"Guest_Name=?",new String[] {G_Name});

    }
}
