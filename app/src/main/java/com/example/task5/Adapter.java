package com.example.task5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Item> arrayList;


    public Adapter(Context context, int layout, ArrayList<Item> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtTitle, txtLabel;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(layout, null);
            viewHolder.txtTitle = convertView.findViewById(R.id.item_title);
            viewHolder.txtLabel = convertView.findViewById(R.id.choice);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Item item = arrayList.get(position);

        viewHolder.txtTitle.setText(item.getTitle());
        viewHolder.txtLabel.setText(item.getChoice());


        return convertView;
    }
}
