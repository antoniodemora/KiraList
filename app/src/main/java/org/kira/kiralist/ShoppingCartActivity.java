package org.kira.kiralist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.kira.kiralist.core.KiraList;
import org.kira.kiralist.core.ShoppingCart;


public class ShoppingCartActivity extends Activity {
    private ShoppingCart shoppingCart;
    private TextView grand_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        Intent intent = getIntent();
        KiraList kiraList = (KiraList) intent.getSerializableExtra(MainActivity.KIRALIST);
        shoppingCart = kiraList.getShoppingCart();
        grand_total = (TextView) findViewById(R.id.grand_total);
        grand_total.setText("$ " + shoppingCart.getGrandTotal().toString());

        ListView cart_items = (ListView) findViewById(R.id.cart_items);

        CartItemAdapter adapter;
        adapter = new CartItemAdapter(
                this,
                shoppingCart.getItems()
        );

        cart_items.setAdapter(adapter);
    }
}
