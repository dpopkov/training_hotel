package io.khasang.training_hotel.service;

import io.khasang.training_hotel.entity.Cat;

import java.util.List;

public interface CatService {
    /**
     * Method for receiving all cats.
     *
     * @return list of all cats
     */
    List<Cat> getAllCats();

    /**
     * @param id cat id
     * @return Cat with specified id
     */
    Cat getCatById(long id);

    /**
     * @param cat cat that should be added to DB
     * @return cat
     */
    Cat addCat(Cat cat);

    /**
     * @param cat cat that should be updated in DB
     * @return updated cat
     */
    Cat updateCat(Cat cat);

    /**
     * @param name name of cats
     * @return list of cats with specified name
     */
    List<Cat> getCatsByName(String name);

    /**
     * @param id id of the cat to delete
     * @return deleted cat
     */
    Cat deleteCatById(long id);
}
