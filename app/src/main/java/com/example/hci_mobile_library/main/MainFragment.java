package com.example.hci_mobile_library.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.hci_mobile_library.book.RentFragment;
import com.example.hci_mobile_library.book.SearchFragment;
import com.example.hci_mobile_library.option.OptionFragment;
import com.example.hci_mobile_library.seat.MySeatFragment;
import com.example.hci_mobile_library.R;
import com.example.hci_mobile_library.seat.SeatRegisterationFragment;

import java.util.Timer;
import java.util.TimerTask;

public class MainFragment extends Fragment implements View.OnClickListener {

    private int[] items = {R.drawable.banner01, R.drawable.banner02};

    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 1000;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 5000; // time in milliseconds between successive task executions.

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ImageButton option_button = view.findViewById(R.id.button_options);

        ViewPager viewPager = view.findViewById(R.id.view_pager);
        Button button_more = view.findViewById(R.id.button_more_info);

        Button button_myseat = view.findViewById(R.id.button_myseat);
        Button button_seat_register = view.findViewById(R.id.button_seat_register);
        Button button_qr = view.findViewById(R.id.button_qr);
        Button button_search = view.findViewById(R.id.button_search);
        Button button_rent = view.findViewById(R.id.button_rent);

        ImageButton button_web = view.findViewById(R.id.button_weblink);
        ImageButton button_inst = view.findViewById(R.id.button_inst);
        ImageButton button_call = view.findViewById(R.id.button_call);


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
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            @Override
            public void run() {
                if(currentPage >= 2) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);


        button_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://dl.jbnu.ac.kr/bbs/list/1?subject_code=1&mId=30401000"));
                startActivity(intent);
            }
        });

        button_myseat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MySeatFragment mySeatFragment = new MySeatFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, mySeatFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        button_seat_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatRegisterationFragment seatRegisterationFragment = new SeatRegisterationFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, seatRegisterationFragment)
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


        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchFragment searchFragment = new SearchFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, searchFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        button_rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RentFragment rentFragment = new RentFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, rentFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        button_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://dl.jbnu.ac.kr/"));
                startActivity(intent);
            }
        });

        button_inst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/jbnu_library/"));
                startActivity(intent);
            }
        });

        button_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0632703456"));
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onClick(View view) {

    }

}
