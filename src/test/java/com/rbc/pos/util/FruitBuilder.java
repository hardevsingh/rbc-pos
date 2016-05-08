package com.rbc.pos.util;

import com.rbc.pos.entity.Country;
import com.rbc.pos.entity.Fruit;
import com.rbc.pos.entity.FruitType;
import com.rbc.pos.entity.Item;

import java.math.BigDecimal;

/**
 * Created by hardev on 5/7/2016.
 */
public class FruitBuilder {

    private int quantity;
    private BigDecimal price;
    private String barCode;
    private Country originOfCountry;
    private FruitType type;

    private Fruit item;
    private FruitBuilder fruitBuilder;

    public FruitBuilder buildFruit() {
        this.fruitBuilder = new FruitBuilder();
        return fruitBuilder;
    }
    public FruitBuilder withType(FruitType type) {
        this.type = type;
        return this;
    }
    public FruitBuilder withQuantity(int quantity) {
        this.quantity =quantity;
        return this;
    }

    public FruitBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
    public FruitBuilder withBarCode(String barCode) {
        this.barCode = barCode;
        return this;
    }
    public FruitBuilder withOriginOfCountry(Country country) {
        this.originOfCountry = country;
        return this;
    }

    public Item build() {
        Item item = new Fruit(quantity, price, barCode, type, originOfCountry);
        return item;
    }
}








