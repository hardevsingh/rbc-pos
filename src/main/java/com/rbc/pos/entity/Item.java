package com.rbc.pos.entity;

import java.math.BigDecimal;

/**
 * Created by hardev on 5/8/2016.
 */
public abstract class Item {

    protected String barCode;
    protected BigDecimal price;
    protected int quantity;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
}
