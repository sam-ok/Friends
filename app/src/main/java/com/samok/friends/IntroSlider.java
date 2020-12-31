package com.samok.friends;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class IntroSlider extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_slider);

        //populating my frame layout
        //loading a default fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new SliderA()).commit();
        }
    }
    public void skip(View v){
        Intent intent = new Intent(IntroSlider.this,SelectionChoice.class);
        startActivity(intent);

    }

    public void next(View v){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new SliderB()).commit();
    }
//
//    public void next1(View v){
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                new SliderC()).commit();
//    }

}
