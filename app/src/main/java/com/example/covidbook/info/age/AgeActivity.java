package com.example.covidbook.info.age;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;

import com.example.covidbook.App;
import com.example.covidbook.R;

public class AgeActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private static final String KEY_EDIT_TEXT_PREFERENCE = "name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.root_preferences);
        System.out.print("on create");
    }

    @Override
    protected void onResume(){
        super.onResume();
        // Set up a listener whenever a key changes
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
        updatePreference(KEY_EDIT_TEXT_PREFERENCE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister the listener whenever a key changes
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
                                          String key) {
        updatePreference(key);
    }

    private void updatePreference(String key){
        if (key.equals(KEY_EDIT_TEXT_PREFERENCE)){
            Preference preference = findPreference(key);
            System.out.print("przed updatem");
            if (preference instanceof EditTextPreference){
                EditTextPreference editTextPreference =  (EditTextPreference)preference;
                SharedPreferences sP= App.context.getSharedPreferences("shared preferences", MODE_PRIVATE);
                SharedPreferences.Editor editor = sP.edit();
                editor.putString("setName1", editTextPreference.getText());
                editor.apply();
                System.out.print("po updacie");
                if (editTextPreference.getText().trim().length() > 0){
                    editTextPreference.setSummary("Age:   " + editTextPreference.getText());
                }else{
                    editTextPreference.setSummary("Enter Your Age");
                }
            }
        }
    }

}
