package com.example.MAD_Hotel.hotel_management;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BILLING extends AppCompatActivity {
    EditText E;
    Button B,b1;
    int h=0;
    DATABASE_GUEST BILL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);
        E=(EditText)findViewById(R.id.EE1);
        B=(Button)findViewById(R.id.BB1);
        b1=(Button)findViewById(R.id.smsbutton);
        BILL=new DATABASE_GUEST(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor res=BILL.getALLData();
                String x=E.getText().toString();
                if(res.getCount()==0)
                {showMessage("ERROR","NOTHING FOUND");
                }


                while(res.moveToNext())
                {   StringBuffer buffer=new StringBuffer();



                    if(x.equals(res.getString(0))) {


                    h=1;
                    if((res.getString(6)).equals("GOLD")) {
                        buffer.append("ID :" + res.getString(0) + "\n");
                        buffer.append("NAME :" + res.getString(1) + "\n");
                        int days=0;
                        int b=0;
                        if(Integer.parseInt(res.getString(4))>Integer.parseInt(res.getString(3))){
                            days=Integer.parseInt(res.getString(4))-Integer.parseInt(res.getString(3));
                            b=(Integer.parseInt(res.getString(4))-Integer.parseInt(res.getString(3)))*2000;}
                        else{
                            days=30+Integer.parseInt(res.getString(4))-Integer.parseInt(res.getString(3));
                            b=(30+Integer.parseInt(res.getString(4))-Integer.parseInt(res.getString(3)))*2000;}

                        buffer.append("BILL :₹" + b + "\n Number of days:"+days+"\n\n");


                        String ph="+91"+res.getString(2);
                        String message=buffer.toString();
                        SmsManager mms=SmsManager.getDefault();
                        mms.sendTextMessage(ph, null, message, null,null );
                        Toast.makeText(getApplicationContext(), "SMS sent",Toast.LENGTH_LONG).show();

                    }
                    else

                    {

                        buffer.append("ID :" + res.getString(0) + "\n");
                        buffer.append("NAME :" + res.getString(1) + "\n");
                        int b=0;
                        int days=0;
                        if(Integer.parseInt(res.getString(4))>Integer.parseInt(res.getString(3)))
                        {
                            days=Integer.parseInt(res.getString(4))-Integer.parseInt(res.getString(3));
                            b=(Integer.parseInt(res.getString(4))-Integer.parseInt(res.getString(3)))*1000;}
                        else{
                            days=30+Integer.parseInt(res.getString(4))-Integer.parseInt(res.getString(3));
                            b=(30+Integer.parseInt(res.getString(4))-Integer.parseInt(res.getString(3)))*1000;}
                        buffer.append("BILL :₹" + b + "\n Number of days:"+days+ "\n\n");

                        String ph="+91"+res.getString(2);
                        String message=buffer.toString();
                        SmsManager mms=SmsManager.getDefault();
                        mms.sendTextMessage(ph, null, message, null,null );
                        Toast.makeText(getApplicationContext(), "SMS sent",Toast.LENGTH_LONG).show();


                    }

                }

                }
                if(h==0)
                {   showMessage("ERROR","NOTHING FOUND");


                }
                else
                {
                    Toast.makeText(BILLING.this,"SMS sent",Toast.LENGTH_LONG).show();
                }

              /*  String ph="+918660143336";
                String message="hello 1231";
                SmsManager mms=SmsManager.getDefault();
                mms.sendTextMessage(ph, null, message, null,null );
                Toast.makeText(getApplicationContext(), "SMS sent",Toast.LENGTH_LONG).show();*/
            }
        });
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //retrieving info from database
                Cursor res=BILL.getALLData();
                String x=E.getText().toString();
                if(res.getCount()==0)
                {showMessage("ERROR","NOTHING FOUND");
                }

                StringBuffer buffer=new StringBuffer();
                while(res.moveToNext())
                {   if(x.equals(res.getString(0))) {


                    h=1;
                    if((res.getString(6)).equals("GOLD")) {
                        buffer.append("ID :" + res.getString(0) + "\n");
                        buffer.append("NAME :" + res.getString(1) + "\n");
                        int days=0;
                        int b=0;
                        if(Integer.parseInt(res.getString(4))>Integer.parseInt(res.getString(3))){
                            days=Integer.parseInt(res.getString(4))-Integer.parseInt(res.getString(3));
                            b=(Integer.parseInt(res.getString(4))-Integer.parseInt(res.getString(3)))*2000;}
                        else{
                            days=30+Integer.parseInt(res.getString(4))-Integer.parseInt(res.getString(3));
                            b=(30+Integer.parseInt(res.getString(4))-Integer.parseInt(res.getString(3)))*2000;}

                        buffer.append("BILL :₹" + b + "\n Number of days:"+days+"\n\n");
                    }
                    else

                        {

                            buffer.append("ID :" + res.getString(0) + "\n");
                            buffer.append("NAME :" + res.getString(1) + "\n");
                            int b=0;
                            int days=0;
                            if(Integer.parseInt(res.getString(4))>Integer.parseInt(res.getString(3)))
                            {
                                days=Integer.parseInt(res.getString(4))-Integer.parseInt(res.getString(3));
                                b=(Integer.parseInt(res.getString(4))-Integer.parseInt(res.getString(3)))*1000;}
                            else{
                                days=30+Integer.parseInt(res.getString(4))-Integer.parseInt(res.getString(3));
                                b=(30+Integer.parseInt(res.getString(4))-Integer.parseInt(res.getString(3)))*1000;}
                            buffer.append("BILL :₹" + b + "\n Number of days:"+days+ "\n\n");

                        }

                }

                }
                if(h==0)
                {   showMessage("ERROR","NOTHING FOUND");


                }
                else
                {
                  Toast.makeText(BILLING.this,buffer.toString(),Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    public void showMessage(String title,String Message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
