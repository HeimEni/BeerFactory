package com.example.beerfactory.Services;

import com.example.beerfactory.bo.Beer;

import java.util.List;

public interface BeerServiceInterface {
    Beer findByid(Long id);
    List<Beer> findAll();

    List<Beer> getByFactoryId(Long idFactory);
    Beer getByName(String name);
    Beer getByType(String type);

}
