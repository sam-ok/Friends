package com.samok.friends.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.samok.friends.R;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }
    public void back2Login(View v){
        Intent intent = new Intent(ForgotPassword.this,LoginActivity.class);
        startActivity(intent);
    }

}