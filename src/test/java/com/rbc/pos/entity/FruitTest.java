package com.rbc.pos.entity;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by hardev on 5/8/2016.
 */
public class FruitTest {

    private Fruit underTest;
    private static final int QUANTITY = 1;
    private static final BigDecimal PRICE = new BigDecimal("0.99");
    private static final String BAR_CODE = "123456789";
    private static final FruitType FRUIT_TYPE = FruitType.BANANA;
    private static final Country COUNTRY_OF_ORIGIN = Country.BRAZIL;

    @Before
    public void setUp() throws Exception {
        underTest = new Fruit(QUANTITY, PRICE, BAR_CODE,
                FRUIT_TYPE, COUNTRY_OF_ORIGIN);
    }
    @Test
    public void shouldHaveCorrectQuantityValue() throws Exception {
        assertEquals("Quantity of item: ",
                QUANTITY, underTest.getQuantity());
    }
    @Test
    public void shouldHaveCorrectPriceValue() throws Exception {
        assertEquals("Price of item: ",
                PRICE, underTest.getPrice());
    }
    @Test
    public void shouldHaveCorrectBarCodeValue() throws Exception {
        assertEquals("Barcode of item: ",
                BAR_CODE, underTest.getBarCode());
    }
    @Test
    public void shouldHaveCorrectFruitTypeValue() throws Exception {
        assertEquals("Type of item: ",
                FRUIT_TYPE, underTest.getType());
    }
    @Test
    public void shouldHaveCorrectCountryOfOriginValue() throws Exception {
        assertEquals("Country of origin of item: ",
                COUNTRY_OF_ORIGIN, underTest.getCountryOfOrigin());
    }
}