package com.rbc.pos.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hardev on 5/8/2016.
 */
public class ShoppingBasketTest {

    private ShoppingBasket shoppingBasket;

    @Before
    public void setUp() throws Exception {
        shoppingBasket = new ShoppingBasket();
    }

    @Test
    public void shouldInitialiseShoppingBasketWithNoItems() throws Exception {

        assertEquals("Shopping basket initialised with items: ",
                0, shoppingBasket.getItems().size());
    }
}