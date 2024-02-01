package com.example.beerfactory.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.example.beerfactory.Controllers.StringToFactoryConverter;

@Configuration
public class webConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToFactoryConverter());
    }
}

