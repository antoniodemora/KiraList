package org.kira.kiralist;

import java.util.ArrayList;

/**
 * Created by huan on 7/12/15.
 */
public class KiraList {
    private ArrayList<String> wishList;
    private ShopCar shopCar;

    public KiraList(){
        wishList = new ArrayList<>();
        shopCar = new ShopCar();
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
     * @return ShopCar
     */
    public ShopCar addItemToCar(int item_index, float price, float quantity){
        shopCar.addToCar(wishList.get(item_index), price, quantity);
        wishList.remove(item_index);
        return shopCar;
    }

    class ShopCar{
        ArrayList<CarItem> items;

        public ShopCar(){
            items = new ArrayList<>();
        }

        /**
         * Adds an item to the shopping car
         * @param item item to add
         * @param price price of the item
         * @param quantity quantity of items
         * @return ArrayList<CarItem>
         */
        public ArrayList<CarItem> addToCar(String item, float price, float quantity){
            items.add(new CarItem(item, price, quantity));
            return items;
        }

        /**
         * Computes the total amount for the shopping
         * @return Float
         */
        public Float getGrandTotal(){
            float total = 0;
            for (CarItem item : items){
                total += (item.price * item.quantity);
            }
            return total;
        }

        class CarItem{
            private String item;
            private float price;
            private float quantity;

            public CarItem(String item, float price, float quantity){
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
        }
    }
}
