package com.samok.friends.views;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.samok.friends.R;

public class DetailsActivity extends AppCompatActivity {
    //variables
    String name,email,phones,friendDesc,friendLocation,friendPeriod, image;
    TextView text_name, text_email, text_phone, text_friend_desc, text_friend_location, text_friend_period;
    ImageView imageView;
    private static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        text_name = findViewById(R.id.name);
        text_email = findViewById(R.id.email);
        text_phone = findViewById(R.id.phone);
        text_friend_desc = findViewById(R.id.friendDesc);
        text_friend_location = findViewById(R.id.friendLocation);
        text_friend_period = findViewById(R.id.friendPeriod);
        imageView = findViewById(R.id.image);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        email = intent.getStringExtra("email_property");
        phones = intent.getStringExtra("phone_property");
        friendDesc = intent.getStringExtra("description_property");
        friendLocation = intent.getStringExtra("location_property");
        friendPeriod = intent.getStringExtra("period_property");
//        image = intent.getStringExtra("image_property");

        //fetch the image
        //u get multimedia files shared using the bundle getExtras method
        Bundle bundle = getIntent().getExtras();
//        check if bundle has image
        if (bundle != null){
            image = bundle.getString("image_property");
            //set image to the imageview
            imageView.setImageResource(Integer.parseInt(image));
        } else {
            Toast.makeText(this, "No shared image ", Toast.LENGTH_SHORT).show();
        }



        //set text
        text_name.setText(name);
        text_friend_period.setText(friendPeriod);
        text_friend_desc.setText(friendDesc);
        text_friend_location.setText(friendLocation);
        text_phone.setText(phones);
        text_email.setText(email);
    }
    public void email(View v){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,"Hello " + name);
        intent.putExtra(Intent.EXTRA_SUBJECT,"PLOT");
        intent.putExtra(Intent.EXTRA_EMAIL,email);
        intent.setType("text/message");
        startActivity(Intent.createChooser(intent,"Choose Email App"));
    }

    public void phone(View v){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            //i need to alert the user to allow the app to make a call
            ActivityCompat.requestPermissions((Activity) this,
                    new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        } else {
            //if the user has allowed app to make a call , launch intent here
            String phone = "tel:" + phones;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(phone)));
//            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(phone)));
        }
    }

}