package com.example.beerfactory;

import com.example.beerfactory.Services.BeerServiceInterface;
import com.example.beerfactory.bo.Factory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class BeerFactoryApplicationTests {
    @Autowired
    BeerServiceInterface beerService;

    @Test
    @Transactional
    void beerServiceFindAll() {
        assert 1 == beerService.findAll().size();
    }
    @Test
    @Transactional
    void beerServiceFindById() {
        assert null != beerService.findByid(1L);
    }
    @Test
    @Transactional
    void beerServiceGetByType() {
        assert null != beerService.getByType("TypeBeer");
    }
    @Test
    @Transactional
    void beerServiceGetByName() {
        assert null != beerService.getByName("nameBeer");
    }
    @Test
    @Transactional
    void beerServiceGetByFactory() {
        assert null != beerService.getByFactoryId(1L);
    }
}
