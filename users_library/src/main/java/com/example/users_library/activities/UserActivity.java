package com.example.users_library.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.users_library.R;
import com.example.users_library.User;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user);
        User user = (User) getIntent().getSerializableExtra("user");
        ImageView imageView = findViewById(R.id.image);
        TextView nameTV = findViewById(R.id.name);
        TextView briefTV = findViewById(R.id.brief);

        Glide.with(this)
                .load(user.getImageUrl())
                .circleCrop()
                .into(imageView);

        nameTV.setText(user.getFirstName() + " " + user.getLastName());
        briefTV.setText(user.getBrief());
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(nameTV.getText());
        toolbar.setNavigationOnClickListener(view -> finish());
    }
}