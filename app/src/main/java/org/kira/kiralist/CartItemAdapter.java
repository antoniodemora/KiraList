package org.kira.kiralist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
        TextView textView = new TextView(getContext());
        textView.setTextSize(25);
        textView.setText(item.getItem());
        return textView;
    }
}
