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
public class AppointmentBooingFragment extends Fragment {

    private View mainView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_appointment_booing, container, false);

        return mainView;
    }

}
