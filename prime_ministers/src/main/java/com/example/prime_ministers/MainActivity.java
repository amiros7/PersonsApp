package com.example.prime_ministers;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.users_library.User;
import com.example.users_library.activities.BaseUserListActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends BaseUserListActivity {

    @Override
    public String getScreenTitle() {
        return getString(R.string.israeli_prime_ministers);
    }

    @Override
    public List<User> getUsers() {
        try {
            InputStream inputStream = getApplicationContext().getAssets().open("prime_ministers.json");
            InputStreamReader reader = new InputStreamReader(inputStream);
            Type userListType = new TypeToken<List<User>>() {}.getType();
            List<User> users = new Gson().fromJson(reader, userListType);
            reader.close();
            return users;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}