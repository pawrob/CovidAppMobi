package com.example.covidbook.ui.emergency;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.covidbook.R;
import com.example.covidbook.info.PersonInfo;
import com.example.covidbook.info.PersonInfoList;

public class ThirdFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private Button callButton1;
    private Button callButton2;
    private Button callButton3;
    public static ThirdFragment newInstance(int index) {
        ThirdFragment fragment = new ThirdFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_third, container, false);

        callButton1 = (Button) root.findViewById(R.id.button2);
        callButton1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:800190590"));
                startActivity(intent);
            }
        });
        callButton2 = (Button) root.findViewById(R.id.button3);
        callButton2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:989"));
                startActivity(intent);
            }
        });

        callButton2 = (Button) root.findViewById(R.id.button4);
        callButton2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:KancelariaElektroniczna@nfz.gov.pl?subject=Question about covid-19")); // only email apps should handle this
                startActivity(intent);
            }
        });
        return root;
    }

}