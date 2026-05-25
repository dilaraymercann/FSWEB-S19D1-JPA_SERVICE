package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/fruit")
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> findAllAsc() {
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Fruit findById(@PathVariable Long id) {
        return fruitService.getById(id);
    }

    @GetMapping("/desc")
    public List<Fruit> findAllDesc() {
        return fruitService.getByPriceDesc();
    }

    @PostMapping
    public Fruit save(@RequestBody Fruit fruit) {
        return fruitService.save(fruit);
    }

    @GetMapping("/name/{name}")
    public List<Fruit> findByName(@PathVariable String name) {
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable Long id) {
        return fruitService.delete(id);
    }
}