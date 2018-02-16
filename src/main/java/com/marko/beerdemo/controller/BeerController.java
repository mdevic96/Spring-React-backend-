package com.marko.beerdemo.controller;

import com.marko.beerdemo.db.Beer;
import com.marko.beerdemo.db.BeerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BeerController {

    private BeerRepository beerRepository;

    public BeerController(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @GetMapping(value = "/beers")
    public Collection<Beer> beers() {
        return new ArrayList<>(beerRepository.findAll());
    }

    @PostMapping(value = "/beers")
    public Beer create(@RequestBody Beer beer) {
        return beerRepository.saveAndFlush(beer);
    }

    @GetMapping(value = "/beers/{id}")
    public Beer get(@PathVariable Long id) {
        return beerRepository.findOne(id);
    }


    @PutMapping(value = "/beers/{id}")
    public Beer update(@PathVariable Long id, @RequestBody Beer beer) {
        Beer one = beerRepository.findOne(id);
        BeanUtils.copyProperties(beer, one);
        return beerRepository.saveAndFlush(one);
    }

    @DeleteMapping(value = "/beers/{id}")
    public Beer delete(@PathVariable Long id) {
        Beer one = beerRepository.findOne(id);
        beerRepository.delete(one);
        return one;
    }

}
