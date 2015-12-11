package org.kira.kiralist;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.kira.kiralist.core.KiraList;

public class MainActivity extends Activity {
    public static final String KIRALIST = "org.kira.kiralist.KiraList";

    private EditText new_item;
    private KiraList kiraList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kiraList = new KiraList();
        if(savedInstanceState != null) {
            kiraList = (KiraList) savedInstanceState.getSerializable(KIRALIST);
        }
        new_item = (EditText) findViewById(R.id.new_item);
        new_item.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (keyEvent != null){
                    addItem();
                    return true;
                }
                return false;
            }
        });
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
            }
        });

        wishlist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showDialogDeleteItem(position);
                return true;
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceSate){
        savedInstanceSate.putSerializable(KIRALIST, kiraList);
        super.onSaveInstanceState(savedInstanceSate);
    }

    public void addItem(){
        String item = new_item.getText().toString();
        new_item.setText("");
        adapter.insert(item, 0);
    }

    public void viewCart(View view) {
        Intent intent = new Intent(this, ShoppingCartActivity.class);
        intent.putExtra(KIRALIST, kiraList);
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.leaving_app)
                .setMessage(R.string.confirm_leave_app)
                .setPositiveButton(R.string.accept, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }


    /*
        DIALOGS
     */
    public void showDialogAddToCart(final int position){
        String item = kiraList.getWishList().get(position);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setMessage(item);
        final EditText txt_price = new EditText(this);
        txt_price.setInputType(EditorInfo.TYPE_CLASS_NUMBER | EditorInfo.TYPE_NUMBER_FLAG_DECIMAL);
        txt_price.setHint(R.string.label_price);
        final EditText txt_quantity = new EditText(this);
        txt_quantity.setInputType(EditorInfo.TYPE_CLASS_NUMBER | EditorInfo.TYPE_NUMBER_FLAG_DECIMAL);
        txt_quantity.setHint(R.string.label_quantity);
        LinearLayout dialog_view = new LinearLayout(this);
        dialog_view.setOrientation(LinearLayout.VERTICAL);
        dialog_view.addView(txt_price);
        dialog_view.addView(txt_quantity);
        dialogBuilder.setView(dialog_view);

        dialogBuilder.setPositiveButton(R.string.accept, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
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

    public void showDialogDeleteItem(final int position){
        String item = kiraList.getWishList().get(position);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setMessage(getString(R.string.delete_item) + item + '?');

        dialogBuilder.setPositiveButton(R.string.accept, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                kiraList.deleteItem(position);
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
