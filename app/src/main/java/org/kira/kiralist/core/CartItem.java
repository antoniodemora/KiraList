package org.kira.kiralist.core;

import java.io.Serializable;

/**
 * Created by huan on 9/12/15.
 */
public class CartItem implements Serializable {
    private static final long serialVersionUID = 1L;
    private String item;
    private float price;
    private float quantity;

    public CartItem(String item, float price, float quantity){
        this.item = item;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Returns the Item
     * @return String
     */
    public String getItem(){
        return item;
    }

    /**
     * Sets the value for the item's name
     * @param item the name of the item
     */
    public void setItem(String item){
        this.item = item;
    }

    /**
     * Returns the price of the item
     * @return float
     */
    public float getPrice(){
        return price;
    }

    /**
     * Sets the value for the item's price
     * @param price the price of the item
     */
    public void setPrice(float price){
        this.price = price;
    }

    /**
     * Returns the quantity of items to buy
     * @return float
     */
    public float getQuantity(){
        return quantity;
    }

    /**
     * Sets the quantity of items to buy
     * @param quantity
     */
    public void setQuantity(float quantity){
        this.quantity = quantity;
    }

    /**
     * Returns the subtotal for the item
     * @return price times quantity
     */
    public float getSubTotal(){
        return this.price * this.quantity;
    }
}
