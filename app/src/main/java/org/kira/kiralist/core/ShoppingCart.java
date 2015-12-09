package org.kira.kiralist.core;

import java.util.ArrayList;

/**
 * Created by huan on 9/12/15.
 */
public class ShoppingCart{
    ArrayList<CartItem> items;

    public ShoppingCart(){
        items = new ArrayList<>();
    }

    /**
     * Adds an item to the shopping car
     * @param item item to add
     * @param price price of the item
     * @param quantity quantity of items
     * @return ArrayList<CarItem>
     */
    public ArrayList<CartItem> addToCar(String item, float price, float quantity){
        items.add(new CartItem(item, price, quantity));
        return items;
    }

    /**
     * Computes the total amount for the shopping
     * @return Float
     */
    public Float getGrandTotal(){
        float total = 0;
        for (CartItem item : items){
            total += (item.getPrice() * item.getQuantity());
        }
        return total;
    }
}
