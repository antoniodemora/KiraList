package org.kira.kiralist;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.kira.kiralist.core.CartItem;

import java.text.DecimalFormat;
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
        DecimalFormat df = new DecimalFormat("#.##");

        TextView itemText = new TextView(getContext());
        itemText.setTextSize(20);
        itemText.setText(item.getItem());

        TextView quantity_text = new TextView(getContext());
        quantity_text.setTextSize(15);
        quantity_text.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        quantity_text.setText("C: " + new DecimalFormat("#.####").format(item.getQuantity()));

        TextView price_text = new TextView(getContext());
        price_text.setTextSize(15);
        price_text.setText(getContext().getString(R.string.text_price) + ": $ " + df.format(item.getPrice()));

        LinearLayout details_layout = new LinearLayout(getContext());
        details_layout.addView(quantity_text);
        details_layout.addView(price_text);

        LinearLayout parent_layout = new LinearLayout(getContext());
        parent_layout.setOrientation(LinearLayout.VERTICAL);
        parent_layout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        parent_layout.addView(itemText);
        parent_layout.addView(details_layout);

        TextView subtotal_text = new TextView(getContext());
        subtotal_text.setTextSize(30);
        subtotal_text.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        subtotal_text.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
        subtotal_text.setText("$ " + df.format(item.getSubTotal()));

        LinearLayout super_layout = new LinearLayout(getContext());
        super_layout.addView(parent_layout);
        super_layout.addView(subtotal_text);

        return super_layout;
    }
}
