package com.example.hci_mobile_library.seat;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.hci_mobile_library.R;

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
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item_register, parent, false);
        }

        TextView floor = convertView.findViewById(R.id.textView_floor);
        ImageView thumbnail = convertView.findViewById(R.id.imageView_thumbnail);
        TextView name = convertView.findViewById(R.id.textView_seat_name);
        ProgressBar progressBar = convertView.findViewById(R.id.progressBar);
        TextView count = convertView.findViewById(R.id.textView_seat_count);

        SeatListItem item = items.get(position);

        floor.setText(item.getFloor());
        thumbnail.setImageResource(item.getImage());
        name.setText(item.getName());

        int max = item.getMax();
        int c = item.getCount();
        String seat_left = Integer.toString(max - c);
        count.setText(seat_left+" seats left");

        int p = (int)(100 * c/max);
        progressBar.setProgress(p);

        float ratio = (float) p / 100;

        float hue = 120 - (120 * ratio);

        progressBar.setProgressTintList(ColorStateList.valueOf(Color.HSVToColor(new float[]{hue, 1f, 0.9f})));

        return convertView;
    }

    public void addItem(String floor, String name, int image, int count, int max) {
        SeatListItem item = new SeatListItem(floor, name, image, count, max);
        items.add(item);
    }

}
