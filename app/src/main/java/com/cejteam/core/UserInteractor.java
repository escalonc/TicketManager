package com.cejteam.core;

import com.cejteam.data.entities.User;
import com.cejteam.data.repositories.BaseRepository;

/**
 * Created by Christopher Escalon on 6/6/2017.
 */

public class UserInteractor {

    private final BaseRepository<User> userRepository;

    public UserInteractor(BaseRepository<User> userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user){
        this.userRepository.add(user);
    }
}
