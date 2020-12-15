package com.example.covidbook.ui.add;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.covidbook.R;

public class AddFragment extends Fragment {

    private AddViewModel addViewModel;
    private RatingBar rb;
    private Button submitButton;
    private TextView submitInfo;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        addViewModel =
                new ViewModelProvider(this).get(AddViewModel.class);
        View root = inflater.inflate(R.layout.fragment_add, container, false);
//        final TextView textView = root.findViewById(R.id.text_add);
        NumberPicker np = root.findViewById(R.id.tempPick);
        np.setMinValue(35);
        np.setMaxValue(45);

        rb = root.findViewById(R.id.rateBar);
        submitButton = (Button) root.findViewById(R.id.submitButton);
        submitInfo = root.findViewById(R.id.ratingInfo);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
              submitInfo.setText("Rating: " + rb.getRating() + "\nTemp: " + np.getValue()+"C");
            }
        });

        addViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });
        return root;
    }
}