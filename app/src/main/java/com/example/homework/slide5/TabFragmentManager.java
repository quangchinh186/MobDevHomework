package com.example.homework.slide5;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.homework.fragment.Fragment1;
import com.example.homework.fragment.Fragment2;
import com.example.homework.fragment.Fragment3;

public class TabFragmentManager extends FragmentStateAdapter {
    public TabFragmentManager(@NonNull FragmentActivity fragmentActivity){
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 2:
                return new Fragment3();
            case 1:
                return new Fragment2();
            default:
                return new Fragment1();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
