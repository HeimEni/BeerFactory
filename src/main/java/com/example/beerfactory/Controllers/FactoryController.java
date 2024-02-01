package com.example.beerfactory.Controllers;

import com.example.beerfactory.Services.BeerService;
import com.example.beerfactory.Services.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/factory")
public class FactoryController {
    @Autowired
    FactoryService factoryService;
    @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("lstFactories",factoryService.findAll());
        return "view-all-factory";
    }
}
