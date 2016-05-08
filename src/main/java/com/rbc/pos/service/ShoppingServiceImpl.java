package com.rbc.pos.service;

import java.math.BigDecimal;
import java.util.function.Function;

import com.rbc.pos.entity.*;
import static com.rbc.pos.util.ShoppingBasketHelper.*;

/**
 * Created by hardev on 5/8/2016.
 */
public class ShoppingServiceImpl implements ShoppingService {

    private ShoppingBasket shoppingBasket = null;

    public ShoppingServiceImpl() {
        shoppingBasket = new ShoppingBasket();
    }

    @Override
    public BigDecimal getCost() {

        Function<Item, BigDecimal> totalAccumulator =
                item -> item.getPrice().multiply(new BigDecimal(item.getQuantity()));
        return shoppingBasket.getItems()
                .stream()
                .map(totalAccumulator)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public void addItem(Item item) {

        //add item if valid
        if (isValidItemToAdd(item)) {
            //is item already present in basket
            if (itemAlreadyPresent(shoppingBasket, item)) {
                increaseQuantityForItem(shoppingBasket, item);
            } else {
                shoppingBasket.getItems().add(item);
            }
        }
    }

    @Override
    public ShoppingBasket getShoppingBasket() {
        return shoppingBasket;
    }
}
