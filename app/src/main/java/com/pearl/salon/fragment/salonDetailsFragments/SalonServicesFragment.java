package com.pearl.salon.fragment.salonDetailsFragments;


import android.bluetooth.BluetoothClass;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pearl.salon.R;
import com.pearl.salon.adapter.service.ServiceAdapter;
import com.pearl.salon.model.service.ServiceList;

import java.util.ArrayList;

import static com.pearl.salon.utils.AppUtils.generateLightRenadomNumber;

/**
 * A simple {@link Fragment} subclass.
 */
public class SalonServicesFragment extends Fragment {

    private View mainView;
    private TextView tv_headService, tv_headPackage, tv_headPrice;
    private RecyclerView rv_mainService;
    private ArrayList<String> colorList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.fragment_salon_services, container, false);

        tv_headService = mainView.findViewById(R.id.tv_headService);
        tv_headPackage = mainView.findViewById(R.id.tv_headPackage);
        tv_headPrice = mainView.findViewById(R.id.tv_headPrice);
        rv_mainService = mainView.findViewById(R.id.rv_mainService);

        rv_mainService.setLayoutManager(new LinearLayoutManager(getActivity()));
        colorList = new ArrayList<>();

        setServiceView();

        tv_headService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tabClicked(tv_headService, tv_headPackage, tv_headPrice);
                setServiceView();
            }
        });

        tv_headPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tabClicked(tv_headPackage, tv_headService, tv_headPrice);
                setPackageView();
            }
        });

        tv_headPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tabClicked(tv_headPrice, tv_headPackage, tv_headService);
                setPriceTable();
            }
        });



        return mainView;
    }

    private void tabClicked(TextView active, TextView notActiveFirst, TextView notActiveSecond){
        active.setTextColor(getResources().getColor(R.color.white));
        active.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        notActiveFirst.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        notActiveFirst.setBackgroundColor(getResources().getColor(R.color.white));

        notActiveSecond.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        notActiveSecond.setBackgroundColor(getResources().getColor(R.color.white));
    }

    private void setServiceView(){
        ServiceList data0 = new ServiceList("Hairstyle", "10 Types");
        ServiceList data1 = new ServiceList("Shaving", "6 Types");
        ServiceList data2 = new ServiceList("Hairdryer", "4 Types");
        ServiceList data3 = new ServiceList("Haircut", "8 Types");
        ServiceList data4 = new ServiceList("Hair Coloring", "4 Types");
        ServiceList data5 = new ServiceList("Facial Makeup", "12 Types");
        ServiceList data6 = new ServiceList("Eye Makeup", "10 Types");
        ArrayList<ServiceList> serviceLists = new ArrayList<>();
        serviceLists.add(data0);
        serviceLists.add(data1);
        serviceLists.add(data2);
        serviceLists.add(data3);
        serviceLists.add(data4);
        serviceLists.add(data5);
        serviceLists.add(data6);

        colorList.clear();

        for (int i = 0; i < 7; i++) {
            colorList.add(generateLightRenadomNumber());
        }

        rv_mainService.setAdapter(new ServiceAdapter(getActivity(), serviceLists, colorList));
    }

    private void setPackageView(){

    }

    private void setPriceTable(){

    }
}
