package com.manin.cobasplash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash_gif extends AppCompatActivity {

    public  static  final int TIMER_FLASH = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_gif);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent goToMain =new Intent(Splash_gif.this, MainActivity.class);
                startActivity(goToMain);

                finish();

            }
        },TIMER_FLASH);
    }
}
