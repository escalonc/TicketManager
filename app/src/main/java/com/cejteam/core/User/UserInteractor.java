package com.cejteam.core.User;

import com.cejteam.data.entities.User;
import com.cejteam.data.entities.User.UserType;
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

    public void createDefaultUsers(){
        userRepository.add(new User("Christopher", "chris", "123", UserType.LIMITATED));
        userRepository.add(new User("Inge", "admin", "123", UserType.ADMIN));

        for (int i = 0; i<50 ;i++){
            if (i % 2 == 0){
                userRepository.add(new User("User " + i, "user" + i, "1", UserType.ADMIN));
            }else {
                userRepository.add(new User("User " + i, "user" + i, "1", UserType.LIMITATED));
            }
        }
    }
}
