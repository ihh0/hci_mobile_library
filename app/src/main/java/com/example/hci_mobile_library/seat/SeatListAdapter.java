package com.example.hci_mobile_library.seat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class SeatListAdapter extends BaseAdapter {
    ArrayList<SeatListItem> items = new ArrayList<SeatListItem>();
    Context context;

    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext();

        return convertView;
    }


}
