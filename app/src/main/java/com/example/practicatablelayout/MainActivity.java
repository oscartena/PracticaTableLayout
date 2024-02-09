package com.example.practicatablelayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.appbartabs);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            Fragment fragment;
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new Fragment1();
                        break;
                    case 1:
                        fragment = new Fragment2();
                        break;
                    case 2:
                        fragment = new Fragment3();
                        break;
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_fragment, fragment)
                        .commit();
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(tab.getText());
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}