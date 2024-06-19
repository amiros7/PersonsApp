package com.example.users_library.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.users_library.R;
import com.example.users_library.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> users = new ArrayList<>();
    private AdapterView.OnItemClickListener listener;

    public UserAdapter(List<User> users, AdapterView.OnItemClickListener listener) {
        this.users = users;
        this.listener = listener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.nameTV.setText(user.getFirstName() + " " + user.getLastName());
        holder.birthTV.setText(user.getBirthDate());
        holder.descriptionTV.setText(user.getDescription());
        holder.nationTV.setText(user.getNation());
        Glide.with(holder.image.getContext())
                .load(user.getImageUrl())
                .circleCrop()
                .error(R.drawable.baseline_person_24)
                .into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(null, view, position, -1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView nameTV, birthTV, descriptionTV, nationTV;
        ImageView image;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.name);
            birthTV = itemView.findViewById(R.id.birth);
            descriptionTV = itemView.findViewById(R.id.description);
            nationTV = itemView.findViewById(R.id.nation);
            image = itemView.findViewById(R.id.image);
        }
    }
}
