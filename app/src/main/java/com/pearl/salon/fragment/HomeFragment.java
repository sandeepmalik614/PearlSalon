package com.pearl.salon.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pearl.salon.R;
import com.pearl.salon.adapter.HomeTypesAdapter;
import com.pearl.salon.adapter.MainTopCategoriesAdapter;
import com.pearl.salon.clickListner.HomeClickListner;
import com.pearl.salon.clickListner.TopCategoriesClickListner;
import com.pearl.salon.model.BestSalonData;
import com.pearl.salon.utils.AppUtils;

import java.util.ArrayList;

import static com.pearl.salon.utils.AppUtils.generateDarkRenadomNumber;
import static com.pearl.salon.utils.AppUtils.generateLightRenadomNumber;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView rv_home_topCategories, rv_home_types;
    private TextView tv_topCatogiresSeeAll, tv_bestDalonSeeAll;
    private View mainView;
    private ArrayList<String> darkColorList;
    private ArrayList<String> lightColorList;
    private ArrayList<String> headingList;
    private ArrayList<BestSalonData> salonData;
    private EditText edt_mainSearch;

    private HomeClickListner homeClickListner = new HomeClickListner() {
        @Override
        public void mainClick(String heading) {
            Toast.makeText(getActivity(), ""+heading, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void childClick(String salonName) {
            Toast.makeText(getActivity(), ""+salonName, Toast.LENGTH_SHORT).show();
        }
    };

    private TopCategoriesClickListner topCategoriesClickListner = new TopCategoriesClickListner() {
        @Override
        public void onClick(String categoryName) {
            Toast.makeText(getActivity(), ""+categoryName, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_home, container, false);
        AppUtils.setBarTransparent(getActivity());

        rv_home_topCategories = mainView.findViewById(R.id.rv_home_topCategories);
        tv_topCatogiresSeeAll = mainView.findViewById(R.id.tv_topCatogiresSeeAll);
        edt_mainSearch = mainView.findViewById(R.id.edt_mainSearch);
        rv_home_types = mainView.findViewById(R.id.rv_home_types);

        setTopCategoryAdapter();
        setSalonData();

        setView();

        edt_mainSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Serach", Toast.LENGTH_SHORT).show();
            }
        });

        return mainView;
    }

    private void setView(){
        rv_home_types.setLayoutManager(new LinearLayoutManager(getActivity()));
        headingList = new ArrayList<>();
        lightColorList = new ArrayList<>();
        rv_home_types.setAdapter(new HomeTypesAdapter(getActivity(), lightColorList, salonData, headingList, homeClickListner));
        for (int i = 0; i < 4; i++) {
            lightColorList.clear();
            for (int j = 0; j < salonData.size(); j++) {
                lightColorList.add(generateLightRenadomNumber());
            }
            if(i == 0){
                headingList.add("Best Salon");
                rv_home_types.getAdapter().notifyDataSetChanged();
            }else if(i == 1){
                headingList.add("Trending Salon");
                rv_home_types.getAdapter().notifyDataSetChanged();
            }else if(i == 2){
                headingList.add("Latest Salon");
                rv_home_types.getAdapter().notifyDataSetChanged();
            }else if(i == 3) {
                headingList.add("Faltu Salon");
                rv_home_types.getAdapter().notifyDataSetChanged();
            }
        }
    }


    private void setTopCategoryAdapter() {
        rv_home_topCategories.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        darkColorList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            darkColorList.add(generateDarkRenadomNumber());
            if (i == 9) {
                rv_home_topCategories.setAdapter(new MainTopCategoriesAdapter(getActivity(), darkColorList, topCategoriesClickListner));
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
