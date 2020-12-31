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

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolderAdapter> {
    Context context;
    List<ViewActivityModel> viewActivityModels;

    public ViewAdapter(Context context, List<ViewActivityModel> viewActivityModels1){
        this.context = context;
        this.viewActivityModels = viewActivityModels1;

    }

    public class ViewHolderAdapter extends RecyclerView.ViewHolder{
        TextView tvFriendName, tvFriendPhone;
        Button btnSee;
        public ViewHolderAdapter(@NonNull View itemView){
            super(itemView);

            tvFriendName = itemView.findViewById(R.id.nameProperty);
            tvFriendPhone = itemView.findViewById(R.id.phone);
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
    holder.tvFriendPhone.setText(viewActivityModel.getPhone());
    holder.btnSee.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("friendName", viewActivityModels.get(position).getFriendName());
            intent.putExtra("phone", viewActivityModels.get(position).getPhone());
            intent.putExtra("email", viewActivityModels.get(position).getEmail());
            intent.putExtra("friendLocation", viewActivityModels.get(position).getFriendLocation());
            intent.putExtra("friendDesc", viewActivityModels.get(position).getFriendDesc());
            intent.putExtra("friendPeriod", viewActivityModels.get(position).getFriendPeriod());
            intent.putExtra("friendPhoto", viewActivityModels.get(position).getFriendPhoto());
            context.startActivity(intent);
        }
    });
    }

    @Override
    public int getItemCount() {

        return 0;
    }
}
