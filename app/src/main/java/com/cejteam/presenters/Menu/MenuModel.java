package com.cejteam.presenters.Menu;

import com.cejteam.data.entities.User;

/**
 * Created by Christopher Escalon on 6/21/2017.
 */

public class MenuModel {
    private String name;
    private int id;
    private User.UserType userType;

    public MenuModel(int id, String name, User.UserType userType) {
        this.name = name;
        this.id = id;
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public User.UserType getUserType() {
        return userType;
    }
}
