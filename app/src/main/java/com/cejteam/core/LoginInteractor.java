package com.cejteam.core;

import com.cejteam.data.entities.User;
import com.cejteam.data.repositories.BaseRepository;
import com.cejteam.data.repositories.UserRepository;

/**
 * Created by Christopher Escalon on 5/21/2017.
 */

public class LoginInteractor implements ILoginInteractor {

    private BaseRepository<User> useRepository = new UserRepository();

    public LoginInteractor() {


    }

    @Override
    public boolean isValidUserLogin(User user) {
        if ()
    }
}
