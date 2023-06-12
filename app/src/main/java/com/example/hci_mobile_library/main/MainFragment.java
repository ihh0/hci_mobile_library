package com.example.hci_mobile_library.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.hci_mobile_library.option.OptionFragment;
import com.example.hci_mobile_library.seat.MySeatFragment;
import com.example.hci_mobile_library.R;

public class MainFragment extends Fragment implements View.OnClickListener {

    private String[] items = {"Page 1", "Page 2"};

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ImageButton option_button = view.findViewById(R.id.button_options);

        Button button_seat_register = view.findViewById(R.id.button_seat_register);
        Button button_qr = view.findViewById(R.id.button_qr);
        Button button_notify = view.findViewById(R.id.button_notify);
        Button button_search = view.findViewById(R.id.button_search);
        ViewPager viewPager = view.findViewById(R.id.view_pager);

        ViewpagerAdapter adapter = new ViewpagerAdapter(items);        // 어댑터 생성. 아이템 리스트를 파라미터로 넣어준다.
        viewPager.setAdapter(adapter);    // 뷰페이저에 어댑터 등록

        option_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OptionFragment optionFragment = new OptionFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, optionFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

//        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Seat", Context.MODE_PRIVATE);
//        int seat_num = sharedPreferences.getInt("seat_num", -1);
        button_seat_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MySeatFragment mySeatFragment = new MySeatFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, mySeatFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        button_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QRCodeFragment qrCodeFragment = new QRCodeFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, qrCodeFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        button_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MySeatFragment mySeatFragment = new MySeatFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, mySeatFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MySeatFragment mySeatFragment = new MySeatFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, mySeatFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });


        return view;
    }

    @Override
    public void onClick(View view) {

    }

}
