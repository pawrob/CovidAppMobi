package com.example.covidbook.ui.emergency;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.covidbook.MapActivity;
import com.example.covidbook.R;

public class FirstFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static FirstFragment newInstance(int index) {
        FirstFragment fragment = new FirstFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        createButtonWithLink(R.id.info_button_1, "https://www.who.int/emergencies/diseases/novel-coronavirus-2019/advice-for-public", view);
        createButtonWithLink(R.id.info_button_2, "https://www.who.int/news-room/q-a-detail/coronavirus-disease-covid-19", view);
        createButtonWithLink(R.id.info_button_3, "https://www.who.int/news-room/q-a-detail/coronavirus-disease-covid-19", view);
        createButtonWithLink(R.id.info_button_4, "https://www.who.int/emergencies/diseases/novel-coronavirus-2019/situation-reports", view);
        createButtonWithLink(R.id.info_button_5, "https://www.who.int/emergencies/diseases/novel-coronavirus-2019", view);
    }

    public void createButtonWithLink (@IdRes int viewId, String link, View root) {
        Button chosenButton = root.findViewById(viewId);
        chosenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(link);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}