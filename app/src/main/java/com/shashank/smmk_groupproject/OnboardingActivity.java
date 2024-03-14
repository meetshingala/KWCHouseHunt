package com.shashank.smmk_groupproject;

// OnboardingActivity.java
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.shashank.smmk_groupproject.Adapter.IntroPagerAdapter;


public class OnboardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        ViewPager2 viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new IntroPagerAdapter(this));

        TabLayout tabLayout = findViewById(R.id.tabLayout);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            // Set the initial icons for the tabs
            if (position == 0) {
                tab.setIcon(R.drawable.tab_selected);
            } else {
                tab.setIcon(R.drawable.tab_unselected);
            }
        }).attach();

        // Set custom OnTabSelectedListener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.setIcon(R.drawable.tab_selected);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setIcon(R.drawable.tab_unselected);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}