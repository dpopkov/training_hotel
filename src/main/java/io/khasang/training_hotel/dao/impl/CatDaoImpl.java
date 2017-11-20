package io.khasang.training_hotel.dao.impl;

import io.khasang.training_hotel.dao.CatDao;
import io.khasang.training_hotel.entity.Cat;

public class CatDaoImpl extends BasicDaoImpl<Cat> implements CatDao {
    public CatDaoImpl(Class<Cat> entityClass) {
        super(entityClass);
    }
}
