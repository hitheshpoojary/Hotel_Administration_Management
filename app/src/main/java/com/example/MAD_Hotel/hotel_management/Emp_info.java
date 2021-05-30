package com.example.MAD_Hotel.hotel_management;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Emp_info extends AppCompatActivity {
    EditText ET1,ET2,ET3,ET4;
    Button BT1,BT2,BT3,BT4;
    DATABASE_EMPLOYEE D;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_info);
        ET1=(EditText)findViewById(R.id.et1);
        ET2=(EditText)findViewById(R.id.et2);
        ET3=(EditText)findViewById(R.id.et3);
        ET4=(EditText)findViewById(R.id.et4);

        BT2=(Button)findViewById(R.id.b2);
        BT3=(Button)findViewById(R.id.b3);
        BT4=(Button)findViewById(R.id.b4);
        BT1=(Button)findViewById(R.id.b1);
        D=new DATABASE_EMPLOYEE(this);
        BT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
    //insert employee info
                boolean I = D.insertvalue(ET1.getText().toString(), ET2.getText().toString(), ET3.getText().toString(),ET4.getText().toString());
                if (I == true) {

                    Toast toast = Toast.makeText(Emp_info.this, "Inserted", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(Emp_info.this, "NOT Inserted", Toast.LENGTH_LONG);
                    toast.show();
                }

            }
        });
        BT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=D.getALL();
                if(res.getCount()==0)
                //viewing emplyee details
                {showMessage("ERROR","NOTHING FOUND");
                    return ;
                }

                StringBuffer buffer=new StringBuffer();
                while(res.moveToNext())
                {
                    buffer.append("ID :"+res.getString(0)+"\n");
                    buffer.append("NAME :"+res.getString(1)+"\n");
                    buffer.append("D_Name :"+res.getString(2)+"\n\n");


                }
                showMessage("DATA",buffer.toString());
            }
        });
        BT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //updaating employee details
                boolean is=D.update(ET1.getText().toString(), ET2.getText().toString(), ET3.getText().toString(),ET4.getText().toString());
                if(is==true)
                {
                    Toast toast = Toast.makeText(Emp_info.this, "Updated", Toast.LENGTH_LONG);
                    toast.show();

                }
                else
                {
                    Toast toast = Toast.makeText(Emp_info.this, "NOT Updated", Toast.LENGTH_LONG);
                    toast.show();
                }


            }
        });
        BT4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //deleting emplyees
                Integer deletedrows=D.delete(ET1.getText().toString());
                if(deletedrows>0)
                {
                    Toast toast = Toast.makeText(Emp_info.this, "Deleted", Toast.LENGTH_LONG);
                    toast.show();

                }
                else
                {
                    Toast toast = Toast.makeText(Emp_info.this, "NOT Deleted", Toast.LENGTH_LONG);
                    toast.show();
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
