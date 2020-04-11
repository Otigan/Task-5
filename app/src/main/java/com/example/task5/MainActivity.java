package com.example.task5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ListView itemList;
    ArrayList<Item> items;
    //Adapter for ListView
    private Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        itemList = findViewById(R.id.itemList);
        items = new ArrayList<>();


        //Adding items to list
        items.add(new Item("Item #1"));
        items.add(new Item("Item #2"));
        items.add(new Item("Item #3"));
        items.add(new Item("Item #4"));



        adapter = new Adapter(this, R.layout.item_layout, items);


        itemList.setAdapter(adapter);

        //Setting ClickListener
        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = view.findViewById(R.id.choice);
                //Opens a dialog with choices
                Dialog alertDialog = onCreateDialog(MainActivity.this, textView);
                alertDialog.show();
            }
        });




    }

    public Dialog onCreateDialog(Context context, final TextView v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        //Array with variants of choice
        final String[] arr = {"1", "2", "3", "4", "5"};

        builder.setTitle("Choose an item")
                .setItems(R.array.listArray, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        v.setText(arr[which]);
                    }
                });
        return builder.create();
    }
}