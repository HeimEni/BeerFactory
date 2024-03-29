package com.example.beerfactory.dal;

import com.example.beerfactory.bo.Factory;

import java.time.LocalDate;
import java.util.List;

public interface FactoryDAO {
    Factory findById(Long id);
    List<Factory> findAll();
    Factory getByAddress(String address);
    List<Factory> getOpenFactory();
    List<Factory> getSupThanOpenedDate(LocalDate date);
    Factory getByNom(String name);

}
