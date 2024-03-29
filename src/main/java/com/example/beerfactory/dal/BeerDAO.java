package com.example.beerfactory.dal;

import com.example.beerfactory.bo.Beer;

import java.util.List;

public interface BeerDAO {
    Beer findById(Long id);
    List<Beer> findAll();
    List<Beer> getByFactoryId(Long idFactory);
    Beer getByName(String name);
    Beer getByType(String type);
}
