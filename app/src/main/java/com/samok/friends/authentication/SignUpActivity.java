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
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.samok.friends.R;

public class SignUpActivity extends AppCompatActivity {
    //declare views
    //declare my elements
    TextInputEditText email,password,name;
    Button btnCreateAccount;
    ProgressBar progressBar;
    //declare ur firebase auth implementation
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //initialize our firebaseapp
        FirebaseApp.initializeApp(this);
        //initialize our Firebase Auth
        auth = FirebaseAuth.getInstance();

        //find ref
        email = findViewById(R.id.signupEmail);
        password = findViewById(R.id.signUpPass);
        name = findViewById(R.id.signupName);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);
        progressBar = findViewById(R.id.progressBar);

        //here register user to firebase
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpUser();
            }
        });

    }

    private void signUpUser() {
        //get user input
        //pick the users input and store the inputs in variables
        String signed_name = name.getText().toString().trim();
        String signed_email = email.getText().toString().trim();
        String signed_pass = password.getText().toString().trim();

        //validate the entries
        //check if the inputs are there
        if (TextUtils.isEmpty(signed_email)){
            Toast.makeText(this, "Email field cannot be empty", Toast.LENGTH_LONG).show();
        } else {
            run(signed_email,signed_pass);
        }
        if (TextUtils.isEmpty(signed_pass)) {
            Toast.makeText(this, "Password field cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            run(signed_email,signed_pass);

        }

        if (signed_pass.length() < 4){
            Toast.makeText(this, "Password should be four characters or more", Toast.LENGTH_SHORT).show();
        } else {
            run(signed_email,signed_pass);

        }
    }

    private void run(String signed_email, String signed_pass) {
        //if the above checks are satisfied
        //create the user
//        firebase method ,createUserWithEmailAndPassword()
        //show the progress indication
        progressBar.setVisibility(View.VISIBLE);
        //create user
        auth.createUserWithEmailAndPassword(signed_email,signed_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Toast.makeText(SignUpActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
                if (!task.isSuccessful()){
                    Toast.makeText(SignUpActivity.this, "Something went wrong account was not created", Toast.LENGTH_SHORT).show();
                } else {
                    updateUi();
                }
            }
        });

    }

    private void updateUi() {
        Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    public void login(View v){
        Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
        startActivity(intent);
    }

}