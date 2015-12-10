package org.kira.kiralist.core;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by huan on 9/12/15.
 */
public class WishlistItemAdapter extends ArrayAdapter{
    public WishlistItemAdapter(Context context, ArrayList<String> objects) {
        super(context, 0, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        String item = (String) getItem(position);
        TextView textView = new TextView(getContext());
        textView.setTextSize(25);
        textView.setText(item);
        return textView;
    }
}
