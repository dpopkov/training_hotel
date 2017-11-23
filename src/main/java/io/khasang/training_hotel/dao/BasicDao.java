package io.khasang.training_hotel.dao;

import io.khasang.training_hotel.entity.Cat;
import org.hibernate.Session;

import java.util.List;

public interface BasicDao<T> {
    /**
     * @return current hibernate session
     */
    Session getCurrentSession();

    /**
     * Method for receiving all entities.
     *
     * @return list of all entities
     */
    List<T> getList();

    /**
     * Receive entity by id.
     *
     * @param id entity id
     * @return entity with specified id
     */
    T getById(long id);

    /**
     * Add entity.
     *
     * @param entity entity
     * @return added entity
     */
    T add(T entity);

    /**
     * Update entity.
     *
     * @param entity entity
     * @return updated entity
     */
    T update(T entity);

    /**
     * Delete entity by id.
     *
     * @param id id of the entity to delete
     * @return deleted entity
     */
//    T deleteById(long id);

    /**
     * Delete entity.
     *
     * @param entity entity to delete
     * @return deleted entity
     */
    T delete(T entity);
}
