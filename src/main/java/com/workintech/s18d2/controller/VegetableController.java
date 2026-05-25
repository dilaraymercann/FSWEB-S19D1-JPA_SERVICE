package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/workintech/vegetables")
public class VegetableController {

    private final VegetableService vegetableService;

    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> findAllAsc() {
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Vegetable findById(@PathVariable Long id) {
        return vegetableService.getById(id);
    }

    @GetMapping("/desc")
    public List<Vegetable> findAllDesc() {
        return vegetableService.getByPriceDesc();
    }

    @PostMapping
    public Vegetable save(@RequestBody Vegetable vegetable) {
        if (vegetable.getId() != null) {
            return vegetableService.update(vegetable);
        }
        return vegetableService.save(vegetable);
    }

    @PostMapping("/{name}")
    public List<Vegetable> findByName(@PathVariable String name) {
        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable Long id) {
        return vegetableService.delete(id);
    }
}