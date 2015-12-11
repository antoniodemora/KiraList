package org.kira.kiralist.core;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by huan on 9/12/15.
 */
public class ShoppingCart implements Serializable {
    private static final long serialVersionUID = 1L;
    ArrayList<CartItem> items;

    public ShoppingCart(){
        items = new ArrayList<>();
    }

    public ArrayList<CartItem> getItems(){
        return this.items;
    }

    /**
     * Adds an item to the shopping car
     * @param item item to add
     * @param price price of the item
     * @param quantity quantity of items
     */
    public void addToCar(String item, float price, float quantity){
        items.add(new CartItem(item, price, quantity));
    }

    /**
     * Computes the total amount for the shopping
     * @return Float
     */
    public Float getGrandTotal(){
        float total = 0;
        for (CartItem item : items){
            total += item.getSubTotal();
        }
        return total;
    }
}
