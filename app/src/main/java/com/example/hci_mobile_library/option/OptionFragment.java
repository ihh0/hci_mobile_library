package com.example.hci_mobile_library.option;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.hci_mobile_library.OnActivityResultListener;
import com.example.hci_mobile_library.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class OptionFragment extends Fragment {

    private static final int PICK_PHOTO_REQUEST = 1;
    private OnActivityResultListener listener;
    ImageView profile;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnActivityResultListener) {
            listener = (OnActivityResultListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnActivityResultListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_PHOTO_REQUEST && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                Uri selectedImageUri = data.getData();
                try {
                    InputStream inputStream = getActivity().getContentResolver().openInputStream(selectedImageUri);
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    profile.setImageBitmap(bitmap);

                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    String img = Base64.encodeToString(byteArray, Base64.DEFAULT);

                    SharedPreferences imgsave = getActivity().getSharedPreferences("student",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = imgsave.edit();
                    editor.putString("profile", img);
                    editor.apply();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_option, container, false);

        ImageButton back = view.findViewById(R.id.imageButton_back_options);

        profile = view.findViewById(R.id.imageView_profile);

        TextView student_name = view.findViewById(R.id.textView_student_name);
        TextView student_num = view.findViewById(R.id.textView_student_num);
        TextView department = view.findViewById(R.id.textView_department);

        Button add_image = view.findViewById(R.id.button_add_picture);
        Button notice = view.findViewById(R.id.button_notice);
        Button guide = view.findViewById(R.id.button_help);
        Button logout = view.findViewById(R.id.button_logout);

        SharedPreferences student = getActivity().getSharedPreferences("student", Context.MODE_PRIVATE);

        student_name.setText(student.getString("name", "로그인하세요"));
        student_num.setText(student.getString("num", ""));
        department.setText(student.getString("department", ""));


        try {
            String profile_image = student.getString("profile", "");
            byte [] encodeByte = Base64.decode(profile_image, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            profile.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.getMessage();
        }

        add_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_PHOTO_REQUEST);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://dl.jbnu.ac.kr/bbs/list/1?subject_code=1&mId=30401000"));
                startActivity(intent);
            }
        });

        guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuideFragment guideFragment = new GuideFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, guideFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }
}
