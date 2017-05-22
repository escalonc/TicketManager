package com.cejteam.data.repositories;

/**
 * Created by Christopher Escalon on 5/21/2017.
 */

public interface BaseRepository<TEntity> {
    void add(TEntity entity);
    void remove(TEntity entity);
    void update(TEntity entity);
    TEntity get(TEntity entity);
}
