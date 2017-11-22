package io.khasang.training_hotel.service.impl;

import io.khasang.training_hotel.dao.CatDao;
import io.khasang.training_hotel.entity.Cat;
import io.khasang.training_hotel.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CatService")
public class CatServiceImpl implements CatService {
    @Autowired
    private CatDao catDao;

    @Override
    public List<Cat> getAllCats() {
        return catDao.getList();
    }

    @Override
    public Cat getCatById(long id) {
        return catDao.getById(id);
    }

    @Override
    public Cat addCat(Cat cat) {
        return catDao.add(cat);
    }

    @Override
    public Cat updateCat(Cat cat) {
        return catDao.update(cat);
    }

    @Override
    public List<Cat> getCatsByName(String name) {
        return catDao.getCatsByName(name);
    }
}
