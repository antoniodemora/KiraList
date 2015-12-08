package org.kira.kiralist;

import java.util.ArrayList;
import java.util.HashMap;

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

    public ArrayList<String> addItem(String item){
        wishList.add(item);
        return wishList;
    }

    public ArrayList<String> getWishList(){
        return wishList;
    }

    class ShopCar{
        ArrayList<CarItem> items;

        public ShopCar(){
            items = new ArrayList<>();
        }

        public ArrayList<CarItem> addToCar(String item, float price, float quantity){
            items.add(new CarItem(item, price, quantity));
            return items;
        }

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
        }
    }
}
