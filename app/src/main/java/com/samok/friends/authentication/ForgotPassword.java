package com.samok.friends.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.samok.friends.R;

public class ForgotPassword extends AppCompatActivity {
    //Declaring elements
    TextInputEditText forgotEmail;
    Button resetEmail;
    ProgressBar progressBar;
    //Declaring firebase
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        //Initialize authentication.
        auth = FirebaseAuth.getInstance();
        //Referencing our views.
        forgotEmail = findViewById(R.id.resetEmail);
        resetEmail = findViewById(R.id.btnResetPassword);
        progressBar = findViewById(R.id.progressBar);

        resetEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotPassword();
            }
        });
    }

    private void forgotPassword() {
        //Picking users' input.
        String forgot_email = forgotEmail.getText().toString().trim();
        //Check
        if (TextUtils.isEmpty(forgot_email)){
            Toast.makeText(this, "Email Field cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            run(forgot_email);
        }
    }

    private void run(String forgot_email) {
        progressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(forgot_email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(ForgotPassword.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ForgotPassword.this, "Failed to send reset email! Email may not be valid", Toast.LENGTH_SHORT).show();
                }

                progressBar.setVisibility(View.GONE);
            }
        });

    }

    public void back2Login(View v){
        Intent intent = new Intent(ForgotPassword.this,LoginActivity.class);
        startActivity(intent);
    }
}