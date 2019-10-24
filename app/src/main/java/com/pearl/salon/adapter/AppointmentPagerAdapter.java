package com.pearl.salon.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.pearl.salon.fragment.appointmentHistoryFragment.AppointmentBooingFragment;
import com.pearl.salon.fragment.appointmentHistoryFragment.AppointmentCancelFragment;
import com.pearl.salon.fragment.appointmentHistoryFragment.AppointmentUpComingFragment;

public class AppointmentPagerAdapter extends FragmentPagerAdapter {

    public AppointmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new AppointmentBooingFragment();
        }
        else if (position == 1)
        {
            fragment = new AppointmentUpComingFragment();
        }
        else if (position == 2)
        {
            fragment = new AppointmentCancelFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Booking";
        }
        else if (position == 1)
        {
            title = "Up Coming";
        }
        else if (position == 2)
        {
            title = "Canceled";
        }
        return title;
    }

}
