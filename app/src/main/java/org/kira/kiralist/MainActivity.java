package org.kira.kiralist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.kira.kiralist.core.KiraList;

public class MainActivity extends Activity {
    public static final String WISHLIST = "com.kira.kiralist.wishlist";

    private EditText new_item;
    private KiraList kiraList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kiraList = new KiraList();
        if(savedInstanceState != null) {
            kiraList.setWishList(savedInstanceState.getStringArrayList(WISHLIST));
        }
        new_item = (EditText) findViewById(R.id.new_item);
        ListView wishlist = (ListView) findViewById(R.id.wishlist);

        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                kiraList.getWishList()
        );

        wishlist.setAdapter(adapter);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceSate){
        savedInstanceSate.putStringArrayList(WISHLIST, kiraList.getWishList());
        super.onSaveInstanceState(savedInstanceSate);
    }

    public void addItem(View view){
        String item = new_item.getText().toString();
        new_item.setText("");
        adapter.insert(item, 0);
    }

    public void shop(View view) {
        Intent intent = new Intent(this, ShopCar.class);
        startActivity(intent);
        finish();
    }
}
