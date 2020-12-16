package com.example.covidbook.ui.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.covidbook.MainActivity;
import com.example.covidbook.MapActivity;
import com.example.covidbook.R;
import com.example.covidbook.info.image.ImageChooserActivity;
import com.example.covidbook.ui.add.AddFragment;

import java.util.Locale;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        final ImageView imageView = root.findViewById(R.id.profile_img);
        homeViewModel.getImage().observe(getViewLifecycleOwner(), new Observer<Bitmap>() {
            @Override
            public void onChanged(@Nullable Bitmap b) {
//                imageView.setImageBitmap(b);
//                HomeViewModel.setBmp(BitmapFactory.decodeFile(ImageChooserActivity.getPicturePath()));
            }
        });

        final Button statusbtn = root.findViewById(R.id.status_update_button);
        statusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                AddFragment addFrag = new AddFragment();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.home_frag, addFrag)
                        .addToBackStack(null)
                        .commit();
            }
        });

        createButton(R.id.status_update_button, AddFragment.class, root);
        createButton(R.id.local_hospitals_button, MapActivity.class, root);
        createButton(R.id.default_clinic_button, MapActivity.class, root);
        createButton(R.id.emergency_screen_button, MapActivity.class, root);

        return root;
    }

    public void createButton (@IdRes int viewId, Class chosenClass, View root) {
        Button chosenButton = root.findViewById(viewId);
        chosenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getActivity(), chosenClass);
                startActivity(startIntent);
            }
        });
    }
}