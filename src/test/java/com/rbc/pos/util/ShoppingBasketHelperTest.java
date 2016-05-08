package com.rbc.pos.util;

import com.rbc.pos.entity.Country;
import com.rbc.pos.entity.FruitType;
import com.rbc.pos.entity.Item;
import com.rbc.pos.entity.ShoppingBasket;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Collections;

import static org.mockito.Mockito.when;

/**
 * Created by hardev on 5/8/2016.
 */
public class ShoppingBasketHelperTest {

    @Mock private ShoppingBasket shoppingBasket;
    private Item mango;
    private Item anotherMango;
    private Item strawBerry;
    private Item apple;
    private Item invalidItem;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mango = new FruitBuilder().buildFruit().withType(FruitType.MANGO).withBarCode("123456")
                .withOriginOfCountry(Country.BRAZIL).withPrice(new BigDecimal("0.99"))
                .withQuantity(1).build();
        anotherMango = new FruitBuilder().buildFruit().withType(FruitType.MANGO).withBarCode("123456")
                .withOriginOfCountry(Country.BRAZIL).withPrice(new BigDecimal("0.99"))
                .withQuantity(2).build();
        strawBerry = new FruitBuilder().buildFruit().withType(FruitType.STRAWBERRY).withBarCode("1234567")
                .withOriginOfCountry(Country.SPAIN).withPrice(new BigDecimal("1.39"))
                .withQuantity(2).build();
        apple = new FruitBuilder().buildFruit().withType(FruitType.APPLE).withBarCode("876543")
                .withOriginOfCountry(Country.ENGLAND).withPrice(new BigDecimal("0.29"))
                .withQuantity(2).build();
        invalidItem = new FruitBuilder().buildFruit().withType(FruitType.APPLE).withBarCode("876543")
                .withOriginOfCountry(Country.ENGLAND).withPrice(new BigDecimal("0.29"))
                .withQuantity(0).build();

    }

    @Test
    public void shouldIncreaseTheQuantityOfItemWhenAddedAgain() throws Exception {

        when(shoppingBasket.getItems()).thenReturn(Collections.singletonList(mango));
        ShoppingBasketHelper.increaseQuantityForItem(shoppingBasket, anotherMango);
        Assert.assertEquals("Item quantity should be: ",
                3, shoppingBasket.getItems().get(0).getQuantity());
    }

    @Test
    public void shouldShowItemAlreadyPresentWhenAddedAgain() throws Exception {

        when(shoppingBasket.getItems()).thenReturn(Collections.singletonList(mango));
        boolean isItemAlreadyPresent = ShoppingBasketHelper.itemAlreadyPresent(shoppingBasket, mango);
        Assert.assertTrue("Item present in basket: ",
                isItemAlreadyPresent);
    }

    @Test
    public void shouldNotShowItemAlreadyPresentWhenAdded() throws Exception {

        when(shoppingBasket.getItems()).thenReturn(Collections.singletonList(mango));
        boolean isItemAlreadyPresent = ShoppingBasketHelper.itemAlreadyPresent(shoppingBasket, strawBerry);
        Assert.assertFalse("Item not present in basket: ",
                isItemAlreadyPresent);
    }

    @Test
    public void shouldFailForValidityToAddWhenInValidItemAdded() throws Exception {

        boolean validItemToAdd = ShoppingBasketHelper.isValidItemToAdd(invalidItem);
        Assert.assertFalse("Item is invalid to add to Shopping basket: ",
                validItemToAdd);
    }

    @Test
    public void shouldPassForValidityToAddWhenValidItemAdded() throws Exception {

        boolean validItemToAdd = ShoppingBasketHelper.isValidItemToAdd(apple);
        Assert.assertTrue("Item is valid to add to Shopping basket: ",
                validItemToAdd);

    }
}