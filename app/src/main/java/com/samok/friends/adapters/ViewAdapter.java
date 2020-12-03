package com.samok.friends.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.samok.friends.R;
import com.samok.friends.models.ViewActivityModel;
import com.samok.friends.views.DetailsActivity;

import java.util.ArrayList;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolderAdapter> {
    Context context;
    ArrayList<ViewActivityModel> viewActivityModels;

    public ViewAdapter(Context context, ArrayList<ViewActivityModel> viewActivityModels1){
        this.context = context;
        this.viewActivityModels = viewActivityModels1;

    }



    public class ViewHolderAdapter extends RecyclerView.ViewHolder{
        TextView tvFriendName, tvFriendLocation;
        Button btnSee;
        public ViewHolderAdapter(@NonNull View itemView){
            super(itemView);

            tvFriendName = itemView.findViewById(R.id.nameProperty);
            tvFriendLocation = itemView.findViewById(R.id.locationProperty);
            btnSee = itemView.findViewById(R.id.seeMore);
        }
    }

    @NonNull
    @Override
    public ViewAdapter.ViewHolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.friends_item, parent, false);
        ViewAdapter.ViewHolderAdapter viewHolderAdapter = new ViewAdapter.ViewHolderAdapter(v); //new instance
        return viewHolderAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter.ViewHolderAdapter holder, int position) {
    ViewActivityModel viewActivityModel = viewActivityModels.get(position);

    holder.tvFriendName.setText(viewActivityModel.getFriendName());
    holder.tvFriendLocation.setText(viewActivityModel.getFriendLocation());
    holder.btnSee.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("name", viewActivityModels.get(position).getFriendName());
            intent.putExtra("email_property", viewActivityModels.get(position).getEmail());
            intent.putExtra("phone_property", viewActivityModels.get(position).getPhone());
            intent.putExtra("description_property", viewActivityModels.get(position).getFriendDesc());
            intent.putExtra("location_property", viewActivityModels.get(position).getFriendLocation());
            intent.putExtra("period_property", viewActivityModels.get(position).getFriendPeriod());
            intent.putExtra("image_property", viewActivityModels.get(position).getFriendPhoto());
        }
    });
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
