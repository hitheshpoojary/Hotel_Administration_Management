package com.example.MAD_Hotel.hotel_management;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    Button guest_info,emp_info,daily_exp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        guest_info=(Button)findViewById(R.id.guest_info);
        emp_info=(Button)findViewById(R.id.emp_info);

        guest_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2= new Intent(Main2Activity.this,Main3Activity.class); //link to main activity 3
                startActivity(i2);
            }
        });
        emp_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(Main2Activity.this,Login.class);  //link to login page
                startActivity(i1);
            }
        });

    }
}
