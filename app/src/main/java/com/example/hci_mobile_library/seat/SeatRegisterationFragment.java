package com.example.hci_mobile_library.seat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.hci_mobile_library.R;

public class SeatRegisterationFragment extends Fragment {

    public SeatRegisterationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seat_registration, container, false);

        ImageButton back = view.findViewById(R.id.button_back_register);

        ListView listView = view.findViewById(R.id.list_seat);
        SeatListAdapter adapter = new SeatListAdapter();
        listView.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        adapter.addItem("2F", "노트북테이블1", R.drawable.thumbnail_4f, 40, 100);
        adapter.addItem("2F", "스마트테이블1", R.drawable.thumbnail_4f, 34, 156);
        adapter.addItem("2F", "스마트테이블2", R.drawable.thumbnail_4f, 59, 140);
        adapter.addItem("2F", "PC학습테이블2", R.drawable.thumbnail_4f, 13, 32);

        adapter.addItem("3F", "노트북테이블2", R.drawable.thumbnail_4f, 45, 45);
        adapter.addItem("3F", "학습테이블", R.drawable.thumbnail_4f, 28, 104);

        adapter.addItem("4F", "노트북열람실", R.drawable.thumbnail_4f, 107, 160);
        adapter.addItem("4F", "제1열람실", R.drawable.thumbnail_4f, 65, 272);
        adapter.addItem("4F", "제2열람실", R.drawable.thumbnail_4f, 49, 80);
        adapter.addItem("4F", "제3열람실", R.drawable.thumbnail_4f, 41, 156);
        adapter.addItem("4F", "제4열람실", R.drawable.thumbnail_4f, 52, 156);
        adapter.addItem("4F", "제5열람실", R.drawable.thumbnail_4f, 56, 80);
        adapter.addItem("4F", "제6열람실", R.drawable.thumbnail_4f, 59, 272);

        adapter.addItem("EX", "특성화캠퍼스 도서관 열람실", R.drawable.thumbnail_4f, 0, 236);
        adapter.addItem("EX", "의과대학 제2열람실", R.drawable.thumbnail_4f, 6, 147);

        return view;
    }
}
