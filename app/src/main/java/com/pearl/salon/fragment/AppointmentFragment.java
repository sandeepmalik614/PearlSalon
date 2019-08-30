package com.pearl.salon.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pearl.salon.R;
import com.pearl.salon.utils.AppUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppointmentFragment extends Fragment {


    public AppointmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_appointment, container, false);
        AppUtils.setBarTransparent(getActivity());
        return view;
    }

}
