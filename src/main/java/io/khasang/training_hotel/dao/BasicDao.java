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
     * @param id entity id
     * @return entity with specified id
     */
    T getById(long id);
}
