package com.pearl.salon.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.pearl.salon.R;
import com.pearl.salon.adapter.AppointmentPagerAdapter;
import com.pearl.salon.utils.AppUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppointmentFragment extends Fragment {

    private View mainView;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AppointmentPagerAdapter pagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_appointment, container, false);

        tabLayout = mainView.findViewById(R.id.tb_appointment);
        viewPager = mainView.findViewById(R.id.vp_appintment);

        pagerAdapter = new AppointmentPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        return mainView;
    }

}
