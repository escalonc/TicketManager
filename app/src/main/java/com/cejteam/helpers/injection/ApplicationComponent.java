package com.cejteam.helpers.injection;

import com.cejteam.ticketmanager.LoginActivity;
import com.cejteam.ticketmanager.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Christopher Escalon on 5/27/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(TicketManagerApplication activity);
    void inject(LoginActivity loginActivity);
    void inject(MainActivity mainActivity);
}
