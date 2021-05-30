package com.example.MAD_Hotel.hotel_management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
  EditText e1;
  EditText e2;
  Button b1;
  int flag=0;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    e1=(EditText)findViewById(R.id.editText);
    e2=(EditText)findViewById(R.id.editText2);
    b1=(Button)findViewById(R.id.button);

    b1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String uname=e1.getText().toString().trim();
        String pass=e2.getText().toString().trim();
        if(uname==""||uname==null){
          if(pass==""||pass==null){
            flag=0;          }
          else{
            flag=0;          }}
        else{
          if(pass==""||pass==null){
            flag=0; }
          else{
            if(uname.equals("admin")&&pass.equals("pass")){
              flag=1;}
            else{
              flag=0;}
          }
        }
        if(flag==0){
          Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_SHORT).show();}
        else{
          Intent i=new Intent(getApplicationContext(),Emp_info.class);
          startActivity(i);}
      }
    });
  }
}
