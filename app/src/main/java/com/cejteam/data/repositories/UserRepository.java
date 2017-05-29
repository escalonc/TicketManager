package com.cejteam.data.repositories;

import com.cejteam.data.entities.User;

import java.util.ArrayList;

/**
 * Created by Christopher Escalon on 5/21/2017.
 */

public class UserRepository implements BaseRepository<User> {
    private static ArrayList<User> users = new ArrayList<>();

    public UserRepository()
    {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("supersecreto");

        this.users.add(user);
    }

    @Override
    public ArrayList<User> getAll(){
        return this.users;
    }

    @Override
    public void add(User user) {
        this.users.add(user);
    }

    @Override
    public void remove(User user) {

    }

    @Override
    public void update(User user) {

    }

    public User get(String username){
        return search(username, this.users.size() - 1);
    }

    private User search(String username, int position)
    {

        if (this.users.get(position).getUsername().equals(username)){
            return  this.users.get(position);
        }else if (position > 0){
            return search(username, --position);
        }else{
            return null;
        }
    }
}
