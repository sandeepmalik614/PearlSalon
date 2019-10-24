package com.pearl.salon.fragment.appointmentHistoryFragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pearl.salon.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppointmentUpComingFragment extends Fragment {


    public AppointmentUpComingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_appointment_up_coming, container, false);
    }

}
