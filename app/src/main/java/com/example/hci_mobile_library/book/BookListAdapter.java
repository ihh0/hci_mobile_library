package com.example.hci_mobile_library.book;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hci_mobile_library.R;

import java.util.ArrayList;

public class BookListAdapter extends BaseAdapter {
    ArrayList<BookListItem> items = new ArrayList<BookListItem>();
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
            convertView = inflater.inflate(R.layout.listview_item_book, parent, false);
        }

        ImageView thumbnail = convertView.findViewById(R.id.imageView_book_thumbnail);
        TextView name = convertView.findViewById(R.id.textView_book_name);
        TextView author_and_publisher = convertView.findViewById(R.id.textView_author);

        BookListItem item = items.get(position);

        thumbnail.setImageResource(item.getImage());
        name.setText(item.getName());
        author_and_publisher.setText(item.getAuthor() + " | " + item.getPublisher());

        return convertView;
    }

    public void addItem(String name, String author, String publisher, int image) {
        BookListItem item = new BookListItem(name, author, publisher, image);
        items.add(item);
    }

}
