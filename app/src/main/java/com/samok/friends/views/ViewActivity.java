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
    //declare the recyclerview
    RecyclerView recyclerView;
    private ProgressBar mProgressCircle;
    //declare the adapter
    ViewAdapter viewAdapter;

    //arrayList
    List<ViewActivityModel> viewActivityModels;
    //database ref
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        databaseReference = FirebaseDatabase.getInstance().getReference("uploadDetails");


        //instance of list as an arrayListr
        viewActivityModels =  new ArrayList<>();


        mProgressCircle = findViewById(R.id.progress_circle);

        //find the view by id
        //intializing the views
        recyclerView = findViewById(R.id.recyclerProperty);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        //reading details in firebase
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            //DataSnapshot contains the records in your firebase
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //for loop to iterate the datasnapshot
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    ViewActivityModel viewActivityModel = snapshot.getValue(ViewActivityModel.class);
                    //adding records to my list
                    //clear list
                    viewActivityModels.clear();
                    viewActivityModels.add(viewActivityModel);
                }

                //set the details to adapter
                viewAdapter = new ViewAdapter(ViewActivity.this, (ArrayList<ViewActivityModel>) viewActivityModels);
                viewAdapter.notifyDataSetChanged(); //
                //set the adapter to recyclerview
                recyclerView.setAdapter(viewAdapter);
                recyclerView.invalidate(); //to refresh the recyclerview
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

