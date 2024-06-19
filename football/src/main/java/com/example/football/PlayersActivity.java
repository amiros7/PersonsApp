package com.example.football;
import com.example.users_library.User;
import com.example.users_library.activities.BaseUserListActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class PlayersActivity extends BaseUserListActivity {

    @Override
    public String getScreenTitle() {
        return getString(R.string.football_players);
    }

    @Override
    public List<User> getUsers() {
        try {
            InputStream inputStream = getApplicationContext().getAssets().open("players.json");
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