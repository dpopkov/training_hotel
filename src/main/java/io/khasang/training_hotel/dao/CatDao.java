package io.khasang.training_hotel.dao;

import io.khasang.training_hotel.entity.Cat;

import java.util.List;

public interface CatDao extends BasicDao<Cat> {
    List<Cat> getCatsByName(String name);
}
