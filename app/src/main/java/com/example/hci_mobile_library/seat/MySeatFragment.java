package com.example.hci_mobile_library.seat;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.example.hci_mobile_library.R;

public class MySeatFragment extends Fragment {


    public MySeatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myseat, container, false);

        ImageButton back = view.findViewById(R.id.imageButton_back_myseat);
        ImageButton history = view.findViewById(R.id.imageButton_history);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MySeatHistoryFragment historyFragment = new MySeatHistoryFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, historyFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }
}
