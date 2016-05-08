package com.rbc.pos.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hardev on 5/8/2016.
 */
public class ShoppingBasket {

    private List<Item> items = new ArrayList<>(0);

    public List<Item> getItems() {
        return items;
    }
}
