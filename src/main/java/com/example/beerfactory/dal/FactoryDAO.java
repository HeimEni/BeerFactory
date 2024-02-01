package com.example.beerfactory.dal;

import com.example.beerfactory.bo.Factory;

import java.util.List;

public interface FactoryDAO {
    Factory findById(Long id);
    List<Factory> findAll();

}
