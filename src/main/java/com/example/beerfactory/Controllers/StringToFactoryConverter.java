package com.example.beerfactory.Controllers;

import com.example.beerfactory.Services.FactoryServiceInterface;
import com.example.beerfactory.bo.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToFactoryConverter implements Converter<String, Factory> {
    @Autowired
    private FactoryServiceInterface factoryService;

    @Override
    public Factory convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
        Factory factory = factoryService.findById(Long.parseLong(source));
        return factory;
    }
}
