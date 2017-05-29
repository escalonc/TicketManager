package com.cejteam.data.repositories;

import java.util.ArrayList;

/**
 * Created by Christopher Escalon on 5/21/2017.
 */

public interface BaseRepository<Entity> {

    void add(Entity entity);
    void remove(Entity entity);
    void update(Entity entity);
    ArrayList<Entity> getAll();
}
