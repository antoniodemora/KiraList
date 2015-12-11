package org.kira.kiralist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.kira.kiralist.core.CartItem;

import java.util.ArrayList;

/**
 * Created by huan on 10/12/15.
 */
public class CartItemAdapter extends ArrayAdapter{
    public CartItemAdapter(Context context, ArrayList<CartItem> cartItems) {
        super(context, 0, cartItems);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        CartItem item = (CartItem) getItem(position);

        TextView itemText = new TextView(getContext());
        itemText.setTextSize(25);
        itemText.setText(item.getItem());

        TextView quantity_text = new TextView(getContext());
        quantity_text.setTextSize(10);
        quantity_text.setText("#: " + Float.toString(item.getQuantity()));

        TextView price_text = new TextView(getContext());
        price_text.setTextSize(10);
        price_text.setText(getContext().getString(R.string.text_price) + ": $ " + Float.toString(item.getPrice()));

        TextView subtotal_text = new TextView(getContext());
        subtotal_text.setTextSize(10);
        subtotal_text.setText("Subtotal: $ " + Float.toString(item.getSubTotal()));

        LinearLayout details_layout = new LinearLayout(getContext());
        details_layout.addView(quantity_text);
        details_layout.addView(price_text);
        details_layout.addView(subtotal_text);

        LinearLayout parent_layout = new LinearLayout(getContext());
        parent_layout.setOrientation(LinearLayout.VERTICAL);
        parent_layout.addView(itemText);
        parent_layout.addView(details_layout);

        return parent_layout;
    }
}
