package com.pearl.salon.fragment.appointmentHistoryFragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pearl.salon.R;
import com.pearl.salon.adapter.appointment.AppointmentBooikngAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppointmentBooingFragment extends Fragment {

    private View mainView;
    private RecyclerView rv_app_booking;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_appointment_booing, container, false);
        init();
        return mainView;
    }

    private void init() {

        rv_app_booking = mainView.findViewById(R.id.rv_app_booking);

        rv_app_booking.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_app_booking.setAdapter(new AppointmentBooikngAdapter(getActivity()));

    }

    //    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//
//        if (isVisibleToUser) {
//            Handler handler = new Handler();
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    init();
//                }
//            }, 20);
//
//        }
//
//    }
}
