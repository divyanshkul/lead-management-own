package com.community.jboss.leadmanagement;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SettingsFragment extends PreferenceFragmentCompat {


    public SettingsFragment() {
        // Required empty public constructor
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        //return inflater.inflate(R.layout.fragment_settings, container, false);
//    }



    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.settings_view);


        final SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        final String finalURL = sharedPreferences.getString(getString(R.string.savedServerURL), "https://developer.jboss.org");
        final EditTextPreference etPreference = (EditTextPreference) findPreference("server_url");
        etPreference.setSummary(finalURL);
        etPreference.setText(finalURL);

        etPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                String  newURL = newValue.toString().trim();
                etPreference.setSummary(newURL);
                etPreference.setText(newURL);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(getString(R.string.savedServerURL), newURL);
                editor.apply();
                return false;
            }
        });
    }
}
