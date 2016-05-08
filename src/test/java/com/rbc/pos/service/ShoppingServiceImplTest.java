package com.rbc.pos.service;

import com.rbc.pos.entity.Country;
import com.rbc.pos.entity.FruitType;
import com.rbc.pos.entity.Item;
import com.rbc.pos.util.FruitBuilder;
import org.junit.*;

import java.math.BigDecimal;

/**
 * Created by hardev on 5/7/2016.
 */
public class ShoppingServiceImplTest {

    private ShoppingService underTest;
    private Item apple;
    private Item anotherApple;
    private Item mango;
    private Item anotherMango;
    private Item strawberry;

    @Before
    public void setUp() throws Exception {
        underTest = new ShoppingServiceImpl();
        apple = new FruitBuilder().buildFruit().withType(FruitType.APPLE).withBarCode("876543")
                .withOriginOfCountry(Country.ENGLAND).withPrice(new BigDecimal("0.29"))
                .withQuantity(5).build();
        mango = new FruitBuilder().buildFruit().withType(FruitType.MANGO).withBarCode("123456")
                .withOriginOfCountry(Country.BRAZIL).withPrice(new BigDecimal("0.99"))
                .withQuantity(1).build();
        strawberry = new FruitBuilder().buildFruit().withType(FruitType.STRAWBERRY).withBarCode("1234567")
                .withOriginOfCountry(Country.SPAIN).withPrice(new BigDecimal("1.39"))
                .withQuantity(2).build();
        anotherApple = new FruitBuilder().buildFruit().withType(FruitType.APPLE).withBarCode("876543")
                .withOriginOfCountry(Country.ENGLAND).withPrice(new BigDecimal("0.29"))
                .withQuantity(4).build();
        anotherMango = new FruitBuilder().buildFruit().withType(FruitType.MANGO).withBarCode("123456")
                .withOriginOfCountry(Country.BRAZIL).withPrice(new BigDecimal("0.99"))
                .withQuantity(2).build();
    }

    @Test
    public void shouldCalculateCostOfShoppingBasket() throws Exception {

        underTest.addItem(apple);
        underTest.addItem(mango);
        underTest.addItem(strawberry);
        BigDecimal basketCost = underTest.getCost();
        Assert.assertEquals("The basket cost: ", new BigDecimal("5.22"), basketCost);
    }

    @Test
    public void shouldCalculateCostOfEmptyShoppingBasket() throws Exception {

        BigDecimal basketCost = underTest.getCost();
        Assert.assertEquals("The basket cost: ", new BigDecimal(0), basketCost);
    }

    @Test
    public void shouldAddItemInBasket() {

        underTest.addItem(apple);
        int noOfItems = underTest.getShoppingBasket().getItems().size();
        Assert.assertEquals("No of items in shopping basket: ",
                1, noOfItems);
    }

    @Test
    public void shouldNotAddItemExistingItem() {

        underTest.addItem(apple);
        underTest.addItem(anotherApple);
        int noOfItems = underTest.getShoppingBasket().getItems().size();
        Assert.assertEquals("No of items in shopping basket: ",
                1, noOfItems);
    }

    @Test
    public void shouldIncreaseTheQuantityOfExistingItemWhenSameItemAddedAgain() {

        underTest.addItem(mango);
        underTest.addItem(anotherMango);
        Assert.assertEquals("Quantity of mangoes in basket: ", 3,
                underTest.getShoppingBasket().getItems().get(0).getQuantity());
    }

    @Test
    public void shouldNotAddInvalidItemInBasket() {

        Item apple = new FruitBuilder().buildFruit().withType(FruitType.APPLE).withBarCode("876543")
                .withOriginOfCountry(Country.ENGLAND).withPrice(new BigDecimal("0.29"))
                .withQuantity(0).build();
        underTest.addItem(apple);
        Assert.assertEquals("Items in basket: ",
                0, underTest.getShoppingBasket().getItems().size());

    }
}