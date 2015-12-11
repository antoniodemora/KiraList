package org.kira.kiralist.core;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by huan on 7/12/15.
 */
public class KiraList implements Serializable {
    private static final long serialVersionUID = 1L;
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
    public void addItem(String item){
        wishList.add(item);
    }

    public void deleteItem(int index){
        wishList.remove(index);
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
     * @param item_index index of the wishlist item to add
     * @param price price for the item
     * @param quantity quantity of items
     */
    public void addItemToCar(int item_index, float price, float quantity){
        shoppingCart.addToCar(wishList.get(item_index), price, quantity);
        wishList.remove(item_index);
    }

    /**
     * Sets the shopping cart for the kiralist
     * @param shoppingCart the new shopping cart
     */
    public void setShoppingCart(ShoppingCart shoppingCart){
        this.shoppingCart = shoppingCart;
    }

    /**
     * Returns the shopping cart for the kiralist
     * @return ShoppingCart for KiraList
     */
    public ShoppingCart getShoppingCart(){
        return this.shoppingCart;
    }

}
