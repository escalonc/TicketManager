package com.cejteam.core;

import android.content.Context;
import android.content.SharedPreferences;

import com.cejteam.data.entities.User;
import com.cejteam.data.repositories.BaseRepository;
import com.cejteam.data.repositories.UserRepository;

/**
 * Created by Christopher Escalon on 5/21/2017.
 */

public class LoginInteractor implements LoginInteractorContract {

    BaseRepository<User> userRepository;
    Context context;
    public LoginInteractor(BaseRepository<User> userRepository, Context context) {
        this.userRepository = userRepository;
        this.context = context;
    }

    @Override
    public boolean isValidUserLogin(String username, String password)
    {
        UserRepository repository = (UserRepository)userRepository;
        User user = repository.get(username);
        if (user == null){
            return false;
        }else  if (user.getUsername().equals(username) && user.getPassword().equals(password))
        {
            initSession(user);
            return true;
        }

        return false;
    }

    @Override
    public void initSession(User user) {
        SharedPreferences preferences = context.getSharedPreferences("Session", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user_id", user.getId());
        editor.putString("username", user.getUsername());
        editor.putString("display_name", user.getName());
        editor.commit();
    }


}
