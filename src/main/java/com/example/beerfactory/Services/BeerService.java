package com.example.beerfactory.Services;

import com.example.beerfactory.bo.Beer;
import com.example.beerfactory.dal.BeerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerService implements BeerServiceInterface{
    @Autowired
    BeerDAO beerDAO;

    @Override
    public Beer findByid(Long id) {
        return beerDAO.findById(id);
    }

    @Override
    public List<Beer> findAll() {
        return beerDAO.findAll();
    }

    @Override
    public List<Beer> getByFactoryId(Long idFactory) {
        return beerDAO.getByFactoryId(idFactory);
    }

    @Override
    public Beer getByName(String name) {
        return beerDAO.getByName(name);
    }

    @Override
    public Beer getByType(String type) {
        return beerDAO.getByType(type);
    }
}
