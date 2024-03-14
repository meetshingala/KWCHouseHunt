package com.shashank.smmk_groupproject.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.shashank.smmk_groupproject.ui.IntroFragment1;
import com.shashank.smmk_groupproject.ui.IntroFragment2;
import com.shashank.smmk_groupproject.ui.IntroFragment3;

public class IntroPagerAdapter extends FragmentStateAdapter {
    public IntroPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new IntroFragment2();
            case 2:
                return new IntroFragment3();
            default:
                return new IntroFragment1();
        }
    }

    @Override
    public int getItemCount() {
        return 3; // Number of intro fragments
    }
}
