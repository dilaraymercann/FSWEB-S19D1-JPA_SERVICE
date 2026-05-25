package com.workintech.s18d2.util;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.FruitException;
import org.springframework.http.HttpStatus;

public class FruitValidation {

    public static void validateId(Long id) {
        if (id == null || id <= 0) {
            throw new FruitException("Id 0'dan büyük olmalıdır: " + id, HttpStatus.BAD_REQUEST);
        }
    }

    public static void validateFruit(Fruit fruit) {
        if (fruit == null) {
            throw new FruitException("Fruit boş olamaz!", HttpStatus.BAD_REQUEST);
        }
        if (fruit.getName() == null || fruit.getName().isBlank()) {
            throw new FruitException("Fruit adı boş olamaz!", HttpStatus.BAD_REQUEST);
        }
        if (fruit.getPrice() == null || fruit.getPrice() <= 0) {
            throw new FruitException("Fruit fiyatı 0'dan büyük olmalıdır!", HttpStatus.BAD_REQUEST);
        }
        if (fruit.getFruitType() == null) {
            throw new FruitException("Fruit tipi boş olamaz!", HttpStatus.BAD_REQUEST);
        }
    }

    public static void validateVegetable(Vegetable vegetable) {
        if (vegetable == null) {
            throw new FruitException("Vegetable boş olamaz!", HttpStatus.BAD_REQUEST);
        }
        if (vegetable.getName() == null || vegetable.getName().isBlank()) {
            throw new FruitException("Vegetable adı boş olamaz!", HttpStatus.BAD_REQUEST);
        }
        if (vegetable.getPrice() == null || vegetable.getPrice() <= 0) {
            throw new FruitException("Vegetable fiyatı 0'dan büyük olmalıdır!", HttpStatus.BAD_REQUEST);
        }
    }
}