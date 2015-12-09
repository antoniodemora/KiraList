package org.kira.kiralist.core;

import java.util.ArrayList;

/**
 * Created by huan on 7/12/15.
 */
public class KiraList {
    private ArrayList<String> wishList;
    private ShoppingCart shoppingCart;

    public KiraList(){
        wishList = new ArrayList<>();
        shoppingCart = new ShoppingCart();
    }

    /**
     * Add item to wishlist
     * @param item item to add
     * @return ArrayList<String>
     */
    public ArrayList<String> addItem(String item){
        wishList.add(item);
        return wishList;
    }

    /**
     * Sets the wishlist
     * @param wishList ArrayList of items to buy
     */
    public void setWishList(ArrayList<String> wishList){
        this.wishList = wishList;
    }

    /**
     * Returns the wishlist for the object
     * @return ArrayList<String>
     */
    public ArrayList<String> getWishList(){
        return wishList;
    }

    /**
     * Adds the specified item to the shop car and deletes it from the wish list
     * @param item_index wishlist item to add
     * @param price price for the item
     * @param quantity quantity of items
     * @return Shopping Cart
     */
    public ShoppingCart addItemToCar(int item_index, float price, float quantity){
        shoppingCart.addToCar(wishList.get(item_index), price, quantity);
        wishList.remove(item_index);
        return shoppingCart;
    }


}
