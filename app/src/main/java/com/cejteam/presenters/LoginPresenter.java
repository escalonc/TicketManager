package com.cejteam.presenters;

import com.cejteam.core.ILoginInteractor;

import javax.inject.Inject;

/**
 * Created by Christopher Escalon on 5/21/2017.
 */

public class LoginPresenter {

    ILoginInteractor loginInteractor;

    @Inject
    public LoginPresenter(ILoginInteractor loginInteractor) {
        this.loginInteractor = loginInteractor;
    }

    public boolean login(String username, String password)
    {
        return this.loginInteractor.isValidUserLogin(username, password);
    }
}
