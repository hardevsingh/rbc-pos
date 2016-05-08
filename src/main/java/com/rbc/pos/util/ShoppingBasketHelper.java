package com.rbc.pos.util;

import com.rbc.pos.entity.Item;
import com.rbc.pos.entity.ShoppingBasket;

import java.util.Optional;

/**
 * Created by hardev on 5/8/2016.
 */
public final class ShoppingBasketHelper {

    private ShoppingBasketHelper(){}

    public static void increaseQuantityForItem(ShoppingBasket shoppingBasket, Item item) {

        Optional<Item> existingItem = shoppingBasket.getItems()
                .stream()
                .filter(itemFromBasket -> item.getBarCode().equals(itemFromBasket.getBarCode()))
                .findFirst();
        existingItem.get().setQuantity(existingItem.get().getQuantity() + item.getQuantity());

    }

    public static boolean itemAlreadyPresent(ShoppingBasket shoppingBasket, Item item) {

        return shoppingBasket.getItems()
                .stream()
                .filter(itemFromBasket -> item.getBarCode().equals(itemFromBasket.getBarCode()))
                .count() > 0 ? true : false;
    }

    public static boolean isValidItemToAdd(Item item) {
        if (item.getQuantity() <= 0) {
            return false;
        }
        return true;
    }
}
