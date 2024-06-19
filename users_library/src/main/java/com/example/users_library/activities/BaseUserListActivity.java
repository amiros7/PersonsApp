package com.example.users_library.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.users_library.R;
import com.example.users_library.User;
import com.example.users_library.adapters.UserAdapter;

import java.util.List;

public abstract class BaseUserListActivity extends AppCompatActivity {

    private UserAdapter adapter;
    private List<User> users;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getScreenTitle());
        users = getUsers();
        adapter = new UserAdapter(users, new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                onUserClicked(users.get(i));
            }
        });
        recyclerView = getRecyclerView();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(getLayoutManager());
    }

    protected void onUserClicked(User user) {
        Intent intent = new Intent(this, UserActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);

    }

    protected RecyclerView getRecyclerView() {
        return findViewById(R.id.list);
    }

    public abstract String getScreenTitle();

    public abstract List<User> getUsers();

    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(this);
    }

}