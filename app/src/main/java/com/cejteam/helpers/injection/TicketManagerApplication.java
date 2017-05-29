package com.cejteam.helpers.injection;

import android.app.Application;

/**
 * Created by Christopher Escalon on 5/27/2017.
 */

public class TicketManagerApplication extends Application {

    private ApplicationComponent applicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        getApplicationComponent().inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
