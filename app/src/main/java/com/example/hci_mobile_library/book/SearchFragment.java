package com.example.hci_mobile_library.book;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.hci_mobile_library.R;

public class SearchFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        ImageButton back = view.findViewById(R.id.imageButton_back_search);
        ImageButton history = view.findViewById(R.id.imageButton_search_history);

        ListView listView = view.findViewById(R.id.list_search);
        BookListAdapter adapter = new BookListAdapter();
        listView.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookHistory bookHistory = new BookHistory();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, bookHistory)
                        .addToBackStack(null)
                        .commit();
            }
        });

        adapter.addItem("name1", "author7", "publisher a", R.drawable.book01);
        adapter.addItem("name2", "author6", "publisher b", R.drawable.book01);
        adapter.addItem("name3", "author5", "publisher c", R.drawable.book01);
        adapter.addItem("name4", "author4", "publisher d", R.drawable.book01);
        adapter.addItem("name5", "author3", "publisher e", R.drawable.book01);
        adapter.addItem("name6", "author2", "publisher f", R.drawable.book01);
        adapter.addItem("name7", "author1", "publisher g", R.drawable.book01);

        return view;
    }
}