package com.samok.friends.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.samok.friends.R;

public class UploadActivity extends AppCompatActivity {
    //declare views
//    TextInputEditText name, email, phone, friend_location, friend_desc, friend_period;
//    Spinner friend_nickname;
//    Button chooseImg, submit;
//    //initialize request counter for the image.
//    private static final int PICK_IMAGE_REQUEST = 1;
//    //the path
//    private Uri mImageUri;
//    private ImageView mImageView;
//    private ProgressBar mProgressBar;
//
//    //Firebase database and storage.
//    private StorageReference mStorageRef;
//    private DatabaseReference mDatabaseRef;
//    private StorageTask mUploadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

//        chooseImg = findViewById(R.id.chooseImage);
//        submit = findViewById(R.id.btnSubmit);
//        name = findViewById(R.id.name);
//        email = findViewById(R.id.email);
//        phone = findViewById(R.id.phone);
//        friend_desc = findViewById(R.id.desc_prop);
//        friend_location = findViewById(R.id.location_prop);
//        friend_period = findViewById(R.id.friendPeriod);
//        friend_nickname = findViewById(R.id.friend_nickname); //Spinner.
//        mImageView = findViewById(R.id.image);
//        mProgressBar = findViewById(R.id.progress_bar);
//
//        //populating spinner with items
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.categories, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        friend_nickname.setAdapter(adapter);
//        friend_nickname.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);


        Button view = findViewById(R.id.view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UploadActivity.this,ViewActivity.class);
                startActivity(intent);
            }
        });

//        //Creating the references to my DB.
//        mStorageRef = FirebaseStorage.getInstance().getReference("uploadImages");
//        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploadDetails");
//
//        chooseImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                choose_Img();
//            }
//        });

//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mUploadTask != null && mUploadTask.isInProgress()) {
//                    Toast.makeText(UploadActivity.this, "Upload still in progress", Toast.LENGTH_SHORT).show();
//                } else {
//                    uploadDetails();
//                }
//            }
//        });

    }

    //    Intent to go to gallery to choose the image to be uploaded.
//    private void choose_Img() {
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(intent, PICK_IMAGE_REQUEST);
//    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
//                && data != null && data.getData() != null) {
//            mImageUri = data.getData();
//            //Setting users picked image to imageview display.
//            Glide
//                    .with(this)
//                    .load(mImageUri)
//                    .into(mImageView);
//
//        }
//    }
//
//    private String getFileExtension(Uri uri) {
//        ContentResolver cR = getContentResolver();
//        MimeTypeMap mime = MimeTypeMap.getSingleton();
//        return mime.getExtensionFromMimeType(cR.getType(uri));
//    }

//    private void uploadDetails() {
//        if (mImageUri != null) {
//            StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()
//                    + "." + getFileExtension(mImageUri));
//            //Pushing image to storage.
//            mUploadTask = fileReference.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                    //Delaying the upload details until my image is pushed to bucket.
//                    Handler handler = new Handler();
//                    handler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            mProgressBar.setProgress(0);
//                        }
//                    }, 500);
//                    Toast.makeText(UploadActivity.this, "Photo upload successful!", Toast.LENGTH_LONG).show();
//                    //Uploading the text details to the realtime DB, download url
//                    final String _name, _phone, _email, _friend_location, _friend_period, _friend_desc;
//
//                    _name = name.getText().toString().trim();
//                    _phone = phone.getText().toString().trim();
//                    _email = email.getText().toString().trim();
//                    _friend_location = friend_location.getText().toString().trim();
//                    _friend_period = friend_period.getText().toString().trim();
//                    _friend_desc = friend_desc.getText().toString().trim();
//
//                    //TASK CLASS : download url from my storage bucket
////                    URL to image from the storage.
//                    Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
////                    Checking for the URL.
//                    while (!urlTask.isSuccessful()) ;
////                    URI is submitted to the model.
//                    Uri downloadURL = urlTask.getResult();
//                    //Creating an id for unique identification of records.
//                    String uploadID = mDatabaseRef.push().getKey();
//                    //Creating new instance of the model class and push content according to model constructor.
//                    ViewActivityModel viewActivityModel = new ViewActivityModel(_name, _email, _phone, _friend_location, _friend_desc, _friend_period, downloadURL.toString());
//                    //Pushing details to the DB.
//                    mDatabaseRef.child(uploadID).setValue(viewActivityModel);
//
//                    //clear text
//                    name.setText("");
//                    phone.setText("");
//                    email.setText("");
//                    friend_period.setText("");
//                    friend_desc.setText("");
//                    friend_location.setText("");
//
//
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    Toast.makeText(UploadActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            })
//                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
//                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
//                            mProgressBar.setProgress((int) progress);
//                        }
//                    });
//
//        } else {
//            Toast.makeText(this, "No file selected!", Toast.LENGTH_SHORT).show();
//        }
//    }
}