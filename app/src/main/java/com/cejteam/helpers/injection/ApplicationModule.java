package com.cejteam.helpers.injection;

import android.app.Application;
import android.content.Context;

import com.cejteam.core.ILoginInteractor;
import com.cejteam.core.LoginInteractor;
import com.cejteam.data.entities.User;
import com.cejteam.data.repositories.BaseRepository;
import com.cejteam.data.repositories.UserRepository;
import com.cejteam.presenters.LoginPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Christopher Escalon on 5/27/2017.
 */

@Module
public class ApplicationModule {

    private Application app;

    public ApplicationModule(Application app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return app;
    }

    @Provides
    @Singleton
    public BaseRepository<User> provideUserRepository(){
        return new UserRepository();
    }

    @Provides
    @Singleton
    public ILoginInteractor provideLoginInteractor(){
        return new LoginInteractor(new UserRepository());
    }

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter(){
        return new LoginPresenter(new LoginInteractor(new UserRepository()));
    }
}
