package com.example.MAD_Hotel.hotel_management;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME=7000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView image = (ImageView)findViewById(R.id.logo);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.side_slide);
        image.startAnimation(animation1);
        TextView t = (TextView) findViewById(R.id.textView2);
        t.startAnimation(animation1);
      new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {

          Intent mySuperIntent = new Intent(MainActivity.this, Main2Activity.class);
          startActivity(mySuperIntent);
          finish();
        }
      }, SPLASH_TIME);
    }
}
