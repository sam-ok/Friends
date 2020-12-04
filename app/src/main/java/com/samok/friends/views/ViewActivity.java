package com.samok.friends.views;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.samok.friends.R;
import com.samok.friends.adapters.ViewAdapter;
import com.samok.friends.models.ViewActivityModel;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {
    //Declare the recyclerview.
    RecyclerView recyclerView;
    private ProgressBar mProgressCircle;
    // Declare the adapter.
    ViewAdapter viewAdapter;

    //ArrayList
    List<ViewActivityModel> viewActivityModels;
    //Database reference.
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        databaseReference = FirebaseDatabase.getInstance().getReference("uploadDetails");

        //Instance of list as an arrayList.
        viewActivityModels =  new ArrayList<>();

        mProgressCircle = findViewById(R.id.progress_circle);

        //Finding the view by id.
        //Initializing the views.
        recyclerView = findViewById(R.id.recyclerProperty);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //Reading details in firebase.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            //DataSnapshot contains the records in my firebase.
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //For loop to iterate the data snapshot.
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    ViewActivityModel viewActivityModel = snapshot.getValue(ViewActivityModel.class);
                    //Adding records to my list.
                    //Clear list.
                    viewActivityModels.clear();
                    viewActivityModels.add(viewActivityModel);
                }
                //Set the details to adapter.
                viewAdapter = new ViewAdapter(ViewActivity.this, viewActivityModels);
                viewAdapter.notifyDataSetChanged(); //
                //Set the adapter to recyclerview.
                recyclerView.setAdapter(viewAdapter);
//                Refreshing the recyclerview.
                recyclerView.invalidate();
                mProgressCircle.setVisibility(View.INVISIBLE);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ViewActivity.this, "Something went wrong try again later " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                mProgressCircle.setVisibility(View.INVISIBLE);
            }
        });

    }
}

