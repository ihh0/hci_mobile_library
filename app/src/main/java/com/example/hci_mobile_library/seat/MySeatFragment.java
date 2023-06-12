package com.example.hci_mobile_library.seat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.hci_mobile_library.R;

public class MySeatFragment extends Fragment {

//    FragmentManager fragmentManager = getChildFragmentManager();
//    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    public MySeatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myseat, container, false);

        Button buttonToFragment1 = view.findViewById(R.id.button_history);

        buttonToFragment1.setOnClickListener(new View.OnClickListener() {
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
