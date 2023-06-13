package com.example.hci_mobile_library;

import android.content.Intent;

public interface OnActivityResultListener {
    void onActivityResult(int requestCode, int resultCode, Intent data);
}