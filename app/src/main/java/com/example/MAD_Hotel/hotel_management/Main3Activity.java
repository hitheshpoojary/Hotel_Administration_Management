package com.example.MAD_Hotel.hotel_management;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
  CardView c1,c2,c3,c4;
  Button b1,b2,b3,b4;int c=0;int rooms=10;
    DATABASE_GUEST p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main3);
      c1 = (CardView) findViewById(R.id.chkin);
      c2 = (CardView) findViewById(R.id.chkout);
      c3 = (CardView) findViewById(R.id.viewg);
      c4 = (CardView) findViewById(R.id.billg);
      c1.setOnClickListener(this);
      c2.setOnClickListener(this);
      c3.setOnClickListener(this);
      c4.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
      p=new DATABASE_GUEST(this);
      switch (view.getId()){
        //if user wants to check in
        case R.id.chkin:
          Intent i5;
          i5 = new Intent(Main3Activity.this,GUEST_INSERT_INFO.class);
          startActivity(i5);
          break;
        case R.id.chkout:
 // rooms available
          c=0;
          Cursor res=p.getALLData();
          StringBuffer buffer=new StringBuffer();
          while(res.moveToNext())
          {   if(res.getString(0).equals(""))
          {}
          else
          {
            c++; //calculating number of users
          }
          }

          if(c==10) //when number of occupied room=10
          {
            buffer.append("  0 ROOMS  \n");shoMessage("NO ROOMS AVAILABLE",buffer.toString());

          }
          else {
            buffer.append((rooms-c)+"   \n");  //less than 10 rooms. Then decrement rooms - occupied room
            shoMessage("ROOMS AVAILABLE", buffer.toString());

          }
          break;
        case R.id.viewg:
          //to view all the customers
          Cursor res1=p.getALLData();
          if(res1.getCount()==0)  //no guest
          {shoMessage("ERROR","NOTHING FOUND");
            return ;
          }

          StringBuffer buffer1=new StringBuffer();
          while(res1.moveToNext())
          {
            buffer1.append("ID :"+res1.getString(0)+"\n");
            buffer1.append("NAME :"+res1.getString(1)+"\n");
            buffer1.append("mobile no :"+res1.getString(2)+"\n\n");


          }
          shoMessage("DATA",buffer1.toString());
          break;
        case R.id.billg:
          //billing
          Intent i6;

          i6 = new Intent(Main3Activity.this,BILLING.class);
          startActivity(i6);
      }
    }
    public void shoMessage(String title,String Message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


}
