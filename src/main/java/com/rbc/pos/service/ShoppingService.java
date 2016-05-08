package com.rbc.pos.service;

import com.rbc.pos.entity.Item;
import com.rbc.pos.entity.ShoppingBasket;

import java.math.BigDecimal;

/**
 * Created by hardev on 5/8/2016.
 */
public interface ShoppingService {

    /**
     * Returns cost of shopping basket
     *
     * @return
     */
    BigDecimal getCost();

    /**
     * Adds item to the shopping basket
     *
     * @param item
     */
    void addItem(Item item);

    /**
     * Returns shopping basket
     *
     * @return
     */
    ShoppingBasket getShoppingBasket();
}
