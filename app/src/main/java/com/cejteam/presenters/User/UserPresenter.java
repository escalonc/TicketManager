package com.cejteam.presenters.User;

import com.cejteam.core.User.UserInteractor;
import com.cejteam.data.entities.User;

/**
 * Created by Christopher Escalon on 6/21/2017.
 */

public class UserPresenter {
    UserInteractor userInteractor;

    public UserPresenter(UserInteractor userInteractor) {
        this.userInteractor = userInteractor;
    }

    public void create(User user){
        this.userInteractor.create(user);
    }
}
