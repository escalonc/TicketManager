package com.cejteam.core;

/**
 * Created by Christopher Escalon on 5/21/2017.
 */

public interface LoginInteractorContract {
    boolean isValidUserLogin(String username, String password);
}
