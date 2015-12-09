package org.kira.kiralist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
    public static final String WISHLIST = "com.kira.kiralist.wishlist";

    private EditText et_item;
    private ListView lst_items;
    private KiraList kiraList;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kiraList = new KiraList();
        if(savedInstanceState != null) {
            kiraList.setWishList(savedInstanceState.getStringArrayList(WISHLIST));
        }
        et_item = (EditText) findViewById(R.id.et_item);
        lst_items = (ListView) findViewById(R.id.lst_items);

        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                kiraList.getWishList()
        );

        lst_items.setAdapter(adapter);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceSate){
        savedInstanceSate.putStringArrayList(WISHLIST, kiraList.getWishList());
        super.onSaveInstanceState(savedInstanceSate);
    }

    public void addItem(View view){
        String item = et_item.getText().toString();
        et_item.setText("");
        adapter.insert(item, 0);
    }

    public void shop(View view) {
        Intent intent = new Intent(this, ShopCar.class);
        startActivity(intent);
        finish();
    }
}
