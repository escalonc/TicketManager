package com.cejteam.data.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Christopher Escalon on 5/21/2017.
 */

public class User {
    protected String name;
    protected String username;
    protected String password;
    protected int age;
    protected String id;
    private UserType userType;

    public User(String name, String username, String password, UserType userType) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.id = UUID.randomUUID().toString();
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public enum UserType {
        LIMITATED(0),
        ADMIN(1);

        private int value;
        private static Map map = new HashMap<>();

        private UserType (int value){
            this.value = value;
        }

        static {
            for (UserType userType : UserType.values()) {
                map.put(userType.getValue(), userType);
            }
        }

        public static UserType valueOf(int type) {
            return (UserType) map.get(type);
        }

        public int getValue() {
            return value;
        }
    }


}
