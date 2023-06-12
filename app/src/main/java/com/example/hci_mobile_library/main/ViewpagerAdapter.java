package com.example.hci_mobile_library.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.hci_mobile_library.R;

public class ViewpagerAdapter extends PagerAdapter {
    private String[] texts;

    public ViewpagerAdapter(String[] Items) {
        this.texts = Items;
    }

    @Override
    public int getCount() {
        return texts.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.mainviewpager_item, container, false);
        ImageView imageView = view.findViewById(R.id.view_pager_image);
        imageView.setImageResource(R.drawable.ic_banner);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
