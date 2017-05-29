package com.cejteam.core;

import com.cejteam.data.entities.User;
import com.cejteam.data.repositories.BaseRepository;
import com.cejteam.data.repositories.UserRepository;

import javax.inject.Inject;

/**
 * Created by Christopher Escalon on 5/21/2017.
 */

public class LoginInteractor implements ILoginInteractor {

    BaseRepository<User> userRepository;

    @Inject
    public LoginInteractor(BaseRepository<User> userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValidUserLogin(String username, String password)
    {
        UserRepository repository = (UserRepository)userRepository;
        User user = repository.get(username);
        if (user == null){
            return false;
        }else  if (user.getUsername().equals(username) && user.getPassword().equals(password)){
            return true;
        }

        return false;
    }
}
