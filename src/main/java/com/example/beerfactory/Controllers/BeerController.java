package com.example.beerfactory.Controllers;

import com.example.beerfactory.Services.BeerService;
import com.example.beerfactory.Services.BeerServiceInterface;
import com.example.beerfactory.Services.FactoryServiceInterface;
import com.example.beerfactory.bo.Beer;
import com.example.beerfactory.bo.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/beer")
public class BeerController {
    @Autowired
    private BeerServiceInterface beerService;
    @Autowired
    private FactoryServiceInterface factoryService;
    @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("lstBeers",beerService.findAll());
        return "view-all-beer";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("lstFactories",factoryService.findAll());
        model.addAttribute("beer",new Beer());
        return "view-new-beer";
    }
    @PostMapping("/create")
    public String create(Beer beer, Factory factory, Model model){
        beer.setFactory(factory);
        System.out.println(beer);
        System.out.println(factory);
        return "redirect:/beer/view-all-beer";
    }
}
