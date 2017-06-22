package com.cejteam.presenters;

import com.cejteam.core.LoginInteractorContract;

/**
 * Created by Christopher Escalon on 5/21/2017.
 */

public class LoginPresenter {

    LoginInteractorContract loginInteractor;

    public LoginPresenter(LoginInteractorContract loginInteractor) {
        this.loginInteractor = loginInteractor;
    }

    public boolean login(String username, String password)
    {
        return this.loginInteractor.isValidUserLogin(username, password);


    }
}
