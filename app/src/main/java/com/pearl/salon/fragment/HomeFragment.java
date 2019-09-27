package com.pearl.salon.fragment;


import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;

import com.pearl.salon.R;
import com.pearl.salon.adapter.HomeBestSalonAdapter;
import com.pearl.salon.adapter.MainTopCategoriesAdapter;
import com.pearl.salon.model.BestSalonData;
import com.pearl.salon.utils.AppUtils;

import java.util.ArrayList;
import java.util.Random;

import static com.pearl.salon.utils.AppUtils.generateDarkRenadomNumber;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView rv_home_topCategories;
    private TextView tv_topCatogiresSeeAll, tv_bestDalonSeeAll;
    private View mainView;
    private ArrayList<String> colorList;
    private ArrayList<String> secondcolorList;
    private ArrayList<BestSalonData> salonData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_home, container, false);
        AppUtils.setBarTransparent(getActivity());

        rv_home_topCategories = mainView.findViewById(R.id.rv_home_topCategories);
        tv_topCatogiresSeeAll = mainView.findViewById(R.id.tv_topCatogiresSeeAll);

        tv_bestDalonSeeAll = mainView.findViewById(R.id.tv_bestDalonSeeAll);

        setViewStub();

        for (int i = 0; i < 3; i++) {
        }

        setTopCategoryAdapter();

        return mainView;
    }

    private void setViewStub(){
        ViewStub viewStub = null;
        viewStub = mainView.findViewById(R.id.mainViewStub);
        View inflated = null;
        inflated = viewStub.inflate();
        RecyclerView rv_home_bestSalon = inflated.findViewById(R.id.rv_home_Salon);
        rv_home_bestSalon.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        secondcolorList = new ArrayList<>();
        setSalonData();
        for (int i = 0; i < 10; i++) {
            secondcolorList.add(generateDarkRenadomNumber());
            if (i == 9) {
                rv_home_bestSalon.setAdapter(new HomeBestSalonAdapter(getActivity(), secondcolorList, salonData));
                break;
            }
        }
    }


    private void setTopCategoryAdapter() {
        rv_home_topCategories.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        colorList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            colorList.add(generateDarkRenadomNumber());
            if (i == 9) {
                rv_home_topCategories.setAdapter(new MainTopCategoriesAdapter(getActivity(), colorList));
                break;
            }
        }
    }

    private void setSalonData(){
        salonData = new ArrayList<>();

        BestSalonData data0 = new BestSalonData("Beauty Box Luxurious Salon", "1.2","C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital");
        BestSalonData data1 = new BestSalonData("Naturals Salon", "4.0","B-1, J BLOCK, 1st Floor");
        BestSalonData data2 = new BestSalonData("Hairport Unisex Salon", "1.2","G 104, Shop Number 1, Main Road, Dwarka Sector 7, Delhi - 110075, Near Brahma Society and Opposite Gokul Garden");
        BestSalonData data3 = new BestSalonData("Looks Salon", "1.2","Sco 122 Huda Market, Gurgaon Sector 46, Gurgaon - 122003");
        BestSalonData data4 = new BestSalonData("Jawed Habib Hair Studio", "1.2","Shop Number C 70, Malviya Nagar, Delhi - 110017, Near Mother Diary Booth,Main Market");
        BestSalonData data5 = new BestSalonData("Beau Shop", "1.2","A 2/115, Ground Floor, Rajouri Garden, Delhi - 110027, Behind Croma");
        BestSalonData data6 = new BestSalonData("ki ka unisex salon", "1.2","180/C, jeevan Nagar, nr Tikona Park, Jeevan Park, Delhi - 110014 ");
        BestSalonData data7 = new BestSalonData("Dmd Salon", "1.2","Jc 54 Ground Floor Gupta Colony, Khirki Extn, Gupta Colony, Malviya Nagar, Delhi - 110017, NiranKari Public School");
        BestSalonData data8 = new BestSalonData("Beauty Box Luxurious Salon", "1.2","C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital");
        BestSalonData data9 = new BestSalonData("Beauty Box Luxurious Salon", "1.2","C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital");

        salonData.add(data0);
        salonData.add(data1);
        salonData.add(data2);
        salonData.add(data3);
        salonData.add(data4);
        salonData.add(data5);
        salonData.add(data6);
        salonData.add(data7);
        salonData.add(data8);
        salonData.add(data9);
    }


}
