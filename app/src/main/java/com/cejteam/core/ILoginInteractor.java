package com.cejteam.core;

import com.cejteam.data.entities.User;

/**
 * Created by Christopher Escalon on 5/21/2017.
 */

public interface ILoginInteractor {
    boolean isValidUserLogin(User user);
}
