package com.example.hci_mobile_library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.hci_mobile_library.main.MainFragment;
import com.example.hci_mobile_library.option.OptionFragment;

public class MainActivity extends AppCompatActivity implements OnActivityResultListener {

    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences data = getSharedPreferences("student", MODE_PRIVATE);
        SharedPreferences.Editor editor = data.edit();
        editor.putString("name", "이름");
        editor.putString("num", "12345");
        editor.putString("department", "컴퓨터공학과");
        editor.commit();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new MainFragment())
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            super.onBackPressed();
        } else {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
            } else {
                this.doubleBackToExitPressedOnce = true;
                Toast.makeText(this, "한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
            }

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000); // 2초 내에 두 번 눌러야 종료되도록 설정
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 프래그먼트로 결과 전달
        OptionFragment fragment = (OptionFragment) getSupportFragmentManager().findFragmentById(R.layout.fragment_option);
        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }
}