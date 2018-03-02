package com.marko.beerdemo.controller;

import com.marko.beerdemo.db.Beer;
import com.marko.beerdemo.db.BeerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/beers")
@CrossOrigin(origins = "http://localhost:3000")
public class BeerController {

    private BeerRepository beerRepository;

    public BeerController(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @GetMapping(value = "/fetch-all")
    public Collection<Beer> beers() {
        return beerRepository.findAll();
    }

    @PostMapping(value = "/create")
    public Beer create(@RequestBody Beer beer) {
        return beerRepository.saveAndFlush(beer);
    }

    @PostMapping(value = "/update")
    public Beer update(@RequestBody Beer beer) {
        if(beer.getId() == null) return null;
        Beer one = beerRepository.findOne(beer.getId());
        BeanUtils.copyProperties(beer, one);
        return beerRepository.saveAndFlush(one);
    }

    @PostMapping(value = "/delete")
    public Beer delete(@RequestBody Beer beer) {
        Beer one = beerRepository.findOne(beer.getId());
        beerRepository.delete(one);
        return one;
    }
}
