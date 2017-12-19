package com.community.jboss.leadmanagement;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingsActivity extends FragmentActivity{
    @BindView(R.id.settings_toolbar)
    Toolbar settingsToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.settings_toolbar);
//        toolbar.setTitle("T");
//        setSupportActionBar(toolbar);
        SettingsFragment settingsFragment = new SettingsFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.settings_fragID, settingsFragment)
                .commit();
        ButterKnife.bind(this);
        settingsToolbar.setTitle("@string/settings_toolbar");
        settingsToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_black));
        settingsToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}



