package com.samok.friends;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.samok.friends.authentication.LoginActivity;
import com.samok.friends.views.ViewActivity;

public class SelectionChoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_choice);
    }
    public void addFriend(View v){
        Intent intent = new Intent(SelectionChoice.this, LoginActivity.class);
        startActivity(intent);
    }

    public void view(View v){
        Intent intent = new Intent(SelectionChoice.this, ViewActivity.class);
        startActivity(intent);
    }

}