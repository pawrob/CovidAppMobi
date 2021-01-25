package com.example.covidbook.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.preference.PreferenceManager;

import com.example.covidbook.App;
import com.example.covidbook.MapActivity;
import com.example.covidbook.R;
import com.example.covidbook.info.PersonInfoList;

import com.example.covidbook.info.image.ImageChooserActivity;
import com.example.covidbook.ui.add.AddFragment;
import com.example.covidbook.ui.emergency.EmergencyActivity;

import java.util.Locale;

import com.example.covidbook.RecyclerActivity;

import static android.content.Context.MODE_PRIVATE;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    PersonInfoList plist = new PersonInfoList();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        Bundle args = getArguments();
        final TextView textView = root.findViewById(R.id.text_home);


        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(App.context);
        String nameFromSetings = sharedPreferences.getString("name", null);
        textView.setText(nameFromSetings);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onChanged(@Nullable String s) {
                if (nameFromSetings != null) {
                    textView.setText(s + nameFromSetings);
                }
                else {
                    textView.setText(s);
                }
            }
        });

        final ImageView imageView = root.findViewById(R.id.profile_img);
        homeViewModel.getImage().observe(getViewLifecycleOwner(), new Observer<Bitmap>() {
            @Override
            public void onChanged(@Nullable Bitmap b) {

                SharedPreferences sharedPreferences = App.context.getSharedPreferences("shared preferences", MODE_PRIVATE);
                String namePreferance123 = sharedPreferences.getString("namePreferance", null);
                if(namePreferance123 !=null){
                    String bitmap = sharedPreferences.getString("imagePreferance", null);
                    imageView.setImageBitmap(decodeBase64(bitmap));
                }


            }
        });

//        final Button statusbtn = root.findViewById(R.id.status_update_button);
//        statusbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AppCompatActivity activity = (AppCompatActivity) view.getContext();
//                Fragment addFrag = new AddFragment();
//                activity.getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.home_frag, addFrag)
//                        .addToBackStack(null)
//                        .commit();
//            }
//        });

        final Button mapBtn = root.findViewById(R.id.local_hospitals_button);
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "geo:"+ 19.4667 + "," + 51.7833 +"?q=hospitals+near+me";
                startActivity(new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri)));
            }
        });


//        createButton(R.id.status_update_button, AddFragment.class, root);
//        createButton(R.id.local_hospitals_button, MapActivity.class, root);
        createButton(R.id.default_clinic_button, MapActivity.class, root);
        createButton(R.id.emergency_screen_button, EmergencyActivity.class, root);

        createButton(R.id.statusButton, RecyclerActivity.class, root);


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

    public static Bitmap decodeBase64(String input) {
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory
                .decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}