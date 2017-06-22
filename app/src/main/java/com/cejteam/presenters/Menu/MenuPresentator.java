package com.cejteam.presenters.Menu;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.cejteam.data.entities.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Christopher Escalon on 6/21/2017.
 */

public class MenuPresentator {

    Context context;
    public MenuPresentator(Context context) {
        this.context = context;
    }

    ArrayList<MenuModel> menuItems = new ArrayList<MenuModel>(
            Arrays.asList(
                    new MenuModel(1,"Users", User.UserType.ADMIN),
                    new MenuModel(2,"Events", User.UserType.LIMITATED),
                    new MenuModel(3,"Reports", User.UserType.LIMITATED),
                    new MenuModel(4,"Log out", User.UserType.LIMITATED)
            )
    );

    public ArrayList<MenuModel> getItems(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        User.UserType userType = User.UserType.valueOf(prefs.getInt("user_type", 0));

        ArrayList<MenuModel> items = new ArrayList<>();
        for(MenuModel item : this.menuItems){
            if (userType == User.UserType.LIMITATED && item.getUserType() == User.UserType.LIMITATED){
                items.add(item);
            }else if (userType == User.UserType.ADMIN && item.getUserType() == User.UserType.ADMIN){
                items.add(item);
            }else if (userType == User.UserType.ADMIN && item.getUserType() == User.UserType.LIMITATED){
                items.add(item);
            }
        }

        return items;
    }

}
