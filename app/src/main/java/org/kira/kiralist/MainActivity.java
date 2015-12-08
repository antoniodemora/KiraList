package org.kira.kiralist;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TableLayout;

public class MainActivity extends Activity {
    private EditText et_item;
    private TableLayout tl_items;
    private KiraList kiraList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kiraList = new KiraList();
        et_item = (EditText) findViewById(R.id.et_item);
        tl_items = (TableLayout) findViewById(R.id.tl_items);
    }
}
