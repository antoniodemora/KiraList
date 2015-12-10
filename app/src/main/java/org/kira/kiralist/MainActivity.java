package org.kira.kiralist;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

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

        wishlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showDialogAddToCart(position);
//                kiraList.addItemToCar(position, 5, 1);
//                adapter.notifyDataSetChanged();
            }
        });
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
        Intent intent = new Intent(this, ShoppingCartActivity.class);
        intent.putExtra(WISHLIST, kiraList.getWishList());
        startActivity(intent);
    }

    public void showDialogAddToCart(final int position){
        String item = kiraList.getWishList().get(position);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setView(getLayoutInflater().inflate(R.layout.dialog_add_to_car, null));
        dialogBuilder.setMessage(item);

        dialogBuilder.setPositiveButton(R.string.accept, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText txt_price = (EditText) findViewById(R.id.txt_price);
                EditText txt_quantity = (EditText) findViewById(R.id.txt_quantity);
                float price = Float.parseFloat(txt_price.getText().toString());
                float quantity = Float.parseFloat(txt_quantity.getText().toString());
                kiraList.addItemToCar(position, price, quantity);
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });

        dialogBuilder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });


        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }
}
