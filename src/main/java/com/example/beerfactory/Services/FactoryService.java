package com.example.beerfactory.Services;

import com.example.beerfactory.bo.Factory;
import com.example.beerfactory.dal.FactoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FactoryService implements FactoryServiceInterface{
    @Autowired
    private FactoryDAO factoryDAO;
    @Override
    public Factory findById(Long id) {
        return factoryDAO.findById(id);
    }

    @Override
    public List<Factory> findAll() {
        return factoryDAO.findAll();
    }

    @Override
    public Factory getByAddress(String address) {
        return factoryDAO.getByAddress(address);
    }

    @Override
    public List<Factory> getOpenFactory() {
        return factoryDAO.getOpenFactory();
    }

    @Override
    public List<Factory> getSupThanOpenedDate(LocalDate date) {
        return factoryDAO.getSupThanOpenedDate(date);
    }

    @Override
    public Factory getByNom(String name) {
        return factoryDAO.getByNom(name);
    }
}
