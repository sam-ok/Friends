package com.samok.friends;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    /** Duration of wait for friends_logo screen.**/
    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Handler.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

//  New intent.
                Intent intent = new Intent(SplashActivity.this, IntroSlider.class);
                startActivity(intent);

            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}