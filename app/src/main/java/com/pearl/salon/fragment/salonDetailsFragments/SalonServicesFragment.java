package com.pearl.salon.fragment.salonDetailsFragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pearl.salon.R;
import com.pearl.salon.adapter.salonDetail.ServiceAdapter;
import com.pearl.salon.adapter.salonDetail.ServicePackageAdapter;
import com.pearl.salon.model.service.ServiceList;
import com.pearl.salon.model.service.ServicePackageList;

import java.util.ArrayList;

import static com.pearl.salon.utils.AppUtils.generateLightRenadomNumber;

/**
 * A simple {@link Fragment} subclass.
 */
public class SalonServicesFragment extends Fragment {

    private View mainView;
    private TextView tv_headService, tv_headPackage, tv_headPrice;
    private RecyclerView rv_mainService, rv_mainPackage, rv_mainPrice;
    private ArrayList<String> colorList;
    private boolean isServiceView = true, isPackageView = false, isPriceView = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.fragment_salon_services, container, false);

        tv_headService = mainView.findViewById(R.id.tv_headService);
        tv_headPackage = mainView.findViewById(R.id.tv_headPackage);
        tv_headPrice = mainView.findViewById(R.id.tv_headPrice);
        rv_mainService = mainView.findViewById(R.id.rv_mainService);
        rv_mainPackage = mainView.findViewById(R.id.rv_mainPackage);
        rv_mainPrice = mainView.findViewById(R.id.rv_mainPrice);

        rv_mainService.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_mainPackage.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_mainPrice.setLayoutManager(new LinearLayoutManager(getActivity()));
        colorList = new ArrayList<>();

        setServiceView();

        tv_headService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isServiceView) {
                    isServiceView = true;
                    isPackageView = false;
                    isPriceView = false;
                    rv_mainService.setVisibility(View.VISIBLE);
                    rv_mainPackage.setVisibility(View.GONE);
                    rv_mainPrice.setVisibility(View.GONE);
                    tabClicked(tv_headService, tv_headPackage, tv_headPrice);
                    setServiceView();
                }
            }
        });

        tv_headPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isPackageView){
                    isServiceView = false;
                    isPackageView = true;
                    isPriceView = false;
                    rv_mainService.setVisibility(View.GONE);
                    rv_mainPackage.setVisibility(View.VISIBLE);
                    rv_mainPrice.setVisibility(View.GONE);
                    tabClicked(tv_headPackage, tv_headService, tv_headPrice);
                    setPackageView();
                }
            }
        });

        tv_headPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isPriceView){
                    isServiceView = false;
                    isPackageView = false;
                    isPriceView = true;
                    rv_mainService.setVisibility(View.GONE);
                    rv_mainPackage.setVisibility(View.GONE);
                    rv_mainPrice.setVisibility(View.VISIBLE);
                    tabClicked(tv_headPrice, tv_headPackage, tv_headService);
                    setPriceTable();
                }
            }
        });


        return mainView;
    }

    private void tabClicked(TextView active, TextView notActiveFirst, TextView notActiveSecond) {
        active.setTextColor(getResources().getColor(R.color.white));
        active.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        notActiveFirst.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        notActiveFirst.setBackgroundColor(getResources().getColor(R.color.white));

        notActiveSecond.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        notActiveSecond.setBackgroundColor(getResources().getColor(R.color.white));
    }

    private void setServiceView() {
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

        rv_mainService.setAdapter(new ServiceAdapter(getActivity(), serviceLists, colorList, false));
    }

    private void setPackageView() {
        ServicePackageList data0 = new ServicePackageList("Stylish Hair cut +Blow dry+ Head wash",
                                                "Free Cancellation", "\u20B9 349",
                "https://img4.nbstatic.in/tr:w-500/5cc941465f1503000d3ab644.png");
        ServicePackageList data1 = new ServicePackageList("Choose any 5 services", "Free Cancellation", "\u20B9 449",
                "https://www.hughcampbellhairgroup.com/files/2017/03/MARSALONPM.jpg");
        ServicePackageList data2 = new ServicePackageList("Choose any 5 services", "Free Cancellation", "\u20B9 349",
                "https://images.unsplash.com/photo-1521590832167-7bcbfaa6381f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
        ServicePackageList data3 = new ServicePackageList("Hair Keratin/Smoothening (Any Length)", "Free Cancellation", "\u20B9 3300",
                "https://lh3.googleusercontent.com/1I0GR6VnT28qSfTiaFxeKe_JGNVsNcm_qdIXwLkSf-lNSVUPqFRU5ngebDxrkeQ5h8ufbOI=w1080-h608-p-no-v0");
        ServicePackageList data4 = new ServicePackageList("Global Color/Highlights Color", "Free Cancellation", "\u20B9 2499",
                "https://images.jdmagicbox.com/comp/delhi/s6/011pxx11.xx11.180309151252.p4s6/catalogue/d-and-a-the-unisex-salon-rohini-delhi-beauty-parlours-for-makeup-6vkqykyndg.jpg");
        ServicePackageList data5 = new ServicePackageList("Women: Haircut (Any Style)", "Free Cancellation", "\u20B9 799",
                "https://du0xldifh78n8.cloudfront.net/c/m.icapellisalon.com/a355920/5496b20d28ae215a801514bc43591c7e/2/1920");
        ServicePackageList data6 = new ServicePackageList("Men: Haircut (Any Style)", "Free Cancellation", "\u20B9 349",
                "https://www.salonpricelady.com/wp-content/uploads/2016/02/hair-salon-inside.jpg");

        ArrayList<ServicePackageList> packageLists = new ArrayList<>();

        packageLists.add(data0);
        packageLists.add(data1);
        packageLists.add(data2);
        packageLists.add(data3);
        packageLists.add(data4);
        packageLists.add(data5);
        packageLists.add(data6);

        colorList.clear();

        for (int i = 0; i < 7; i++) {
            colorList.add(generateLightRenadomNumber());
        }

        rv_mainPackage.setAdapter(new ServicePackageAdapter(getActivity(), packageLists, colorList));
    }

    private void setPriceTable() {
        ServiceList data0 = new ServiceList("Combo Manicure/Pedicure", "\u20B9 349");
        ServiceList data1 = new ServiceList("Manicure", "\u20B9 349");
        ServiceList data2 = new ServiceList("Spa Manicure", "\u20B9 349");
        ServiceList data3 = new ServiceList("Gel Manicure (with Soak Off)", "\u20B9 349");
        ServiceList data4 = new ServiceList("Gel Manicure (without Soak Off)", "\u20B9 349");
        ServiceList data5 = new ServiceList("Shellac Gel Manicure (with Soak Off)", "\u20B9 349");
        ServiceList data6 = new ServiceList("Shellac Gel Manicure (without Soak Off)", "\u20B9 349");
        ServiceList data7 = new ServiceList("Gel Soak Off", "\u20B9 349");
        ServiceList data8 = new ServiceList("Powder Dip Manicure (Medium Real Nail)", "\u20B9 349");
        ServiceList data9 = new ServiceList("7-14 Day Gel Polish (no UV)", "\u20B9 349");
        ServiceList data10 = new ServiceList("French Manicure", "\u20B9 349");
        ServiceList data11 = new ServiceList("Powder Dip Manicure (Short Real Nail)", "\u20B9 349");
        ServiceList data12 = new ServiceList("Powder Dip Manicure (Long Real Nail)", "\u20B9 349");
        ServiceList data13 = new ServiceList("Polish Change", "\u20B9 349");
        ServiceList data14 = new ServiceList("Buffing Manicure", "\u20B9 349");
        ArrayList<ServiceList> serviceLists = new ArrayList<>();
        serviceLists.add(data0);
        serviceLists.add(data1);
        serviceLists.add(data2);
        serviceLists.add(data3);
        serviceLists.add(data4);
        serviceLists.add(data5);
        serviceLists.add(data6);
        serviceLists.add(data7);
        serviceLists.add(data8);
        serviceLists.add(data9);
        serviceLists.add(data10);
        serviceLists.add(data11);
        serviceLists.add(data12);
        serviceLists.add(data13);
        serviceLists.add(data14);

        colorList.clear();

        for (int i = 0; i < 15; i++) {
            colorList.add(generateLightRenadomNumber());
        }

        rv_mainPrice.setAdapter(new ServiceAdapter(getActivity(), serviceLists, colorList, true));
    }
}
