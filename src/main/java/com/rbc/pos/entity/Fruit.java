package com.rbc.pos.entity;

import java.math.BigDecimal;

/**
 * Created by hardev on 5/8/2016.
 */
public class Fruit extends Item {

    private Country countryOfOrigin;
    private FruitType type;

    public Fruit(int quantity, BigDecimal price, String barCode, FruitType fruitType,
                 Country countryOfOrigin) {
        this.quantity = quantity;
        this.price = price;
        this.barCode = barCode;
        this.type = fruitType;
        this.countryOfOrigin = countryOfOrigin;
    }

    public Country getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public FruitType getType() {
        return type;
    }
}
