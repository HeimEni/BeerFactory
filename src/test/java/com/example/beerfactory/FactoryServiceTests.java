package com.example.beerfactory;

import com.example.beerfactory.Services.BeerServiceInterface;
import com.example.beerfactory.Services.FactoryServiceInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootTest

public class FactoryServiceTests {
    @Autowired
    FactoryServiceInterface factoryService;

    @Test
    @Transactional
    void FactoryServiceFindAll() {
        assert 1 == factoryService.findAll().size();
    }
    @Test
    @Transactional
    void FactoryServicefindById() {
        assert null != factoryService.findById(1L);
    }
    @Test
    @Transactional
    void FactoryServicegetByAddress() {
        assert null != factoryService.getByAddress("addressFactory");
    }
    @Test
    @Transactional
    void factoryServicegetOpenFactory() {
        assert 1 == factoryService.getOpenFactory().size();
    }
    @Test
    @Transactional
    void factoryServicegetSupThanOpenedDate() {
        assert null != factoryService.getSupThanOpenedDate(LocalDate.parse("1999-01-01"));
    }
}
