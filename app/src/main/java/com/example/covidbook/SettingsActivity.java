package com.example.covidbook;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;

import com.example.covidbook.info.PersonInfoList;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new SettingsFragment())
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
            SwitchPreferenceCompat nightMode = findPreference("dark_mode_toggle");
            if (nightMode != null) {
                nightMode.setOnPreferenceChangeListener((preference, newValue) -> {
                    switch (getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) {
                        case Configuration.UI_MODE_NIGHT_YES:
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                            break;
                        case Configuration.UI_MODE_NIGHT_NO:
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                            break;
                    }
                    return true;
                });
            }

            Preference eraser = findPreference("erase_list");
            if(eraser != null){
                eraser.setOnPreferenceClickListener((newValue) -> {


                    new AlertDialog.Builder(getContext())
                            .setTitle("Erase data")
                            .setMessage("Do you want to delete all your rapports?")
                            .setView(R.layout.settings_activity)
                            .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    PersonInfoList.deleteData();
                                    Toast.makeText(App.context,"Data erased",Toast.LENGTH_SHORT).show();
                                }
                            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                        }
                    }).show();
                    return true;
                });
            }
        }
    }



}