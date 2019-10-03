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
import com.pearl.salon.model.MainList;
import com.pearl.salon.model.SalonData;
import com.pearl.salon.utils.AppUtils;

import java.util.ArrayList;
import java.util.Objects;

import static com.pearl.salon.utils.AppUtils.generateDarkRenadomNumber;
import static com.pearl.salon.utils.AppUtils.generateLightRenadomNumber;

/**
 * A simple {@link Fragment} subclass.
 */
public class NearbyFragment extends Fragment {

    private RecyclerView rv_topServices, rv_types;
    private TextView tv_topCatogiresSeeAll, tv_bestDalonSeeAll;
    private View mainView;
    private ArrayList<String> darkColorList;
    private ArrayList<String> lightColorList;
    private ArrayList<String> headingList;
    private ArrayList<SalonData> bestSalonData;
    private ArrayList<SalonData> trendingSalonData;
    private ArrayList<SalonData> hotDealsData;
    private ArrayList<SalonData> latestSalonData;
    private ArrayList<MainList> mainLists;
    private MainList bestSalon;
    private MainList trendingSalon;
    private MainList hotDeals;
    private MainList latestSalon;
    private EditText edt_mainSearch;

    private HomeClickListner homeClickListner = new HomeClickListner() {
        @Override
        public void mainClick(String heading) {
            Toast.makeText(getActivity(), "" + heading, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void childClick(String salonName) {
            Toast.makeText(getActivity(), "" + salonName, Toast.LENGTH_SHORT).show();
        }
    };

    private TopCategoriesClickListner topCategoriesClickListner = new TopCategoriesClickListner() {
        @Override
        public void onClick(String categoryName) {
            Toast.makeText(getActivity(), "" + categoryName, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_nearby, container, false);

        rv_topServices = mainView.findViewById(R.id.rv_nearby_topServices);
        tv_topCatogiresSeeAll = mainView.findViewById(R.id.tv_topCatogiresSeeAll);
        edt_mainSearch = mainView.findViewById(R.id.edtNearbySearch);
        rv_types = mainView.findViewById(R.id.rv_nearby_types);

        mainLists = new ArrayList<>();
        bestSalon = new MainList();
        trendingSalon = new MainList();
        hotDeals = new MainList();
        latestSalon = new MainList();

        setTopCategoryAdapter();

        setView();

        edt_mainSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Serach", Toast.LENGTH_SHORT).show();
            }
        });


        return mainView;
    }

    private void setView() {
        rv_types.setLayoutManager(new LinearLayoutManager(getActivity()));
        headingList = new ArrayList<>();
        lightColorList = new ArrayList<>();
        lightColorList.clear();
        for (int j = 0; j < 10; j++) {
            lightColorList.add(generateLightRenadomNumber());
        }
        rv_types.setAdapter(new HomeTypesAdapter(getActivity(), lightColorList, mainLists, headingList, homeClickListner));
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                headingList.add("Popular Salon Nearby");
                setBestSalonData();
                bestSalon.setSalonData(bestSalonData);
                mainLists.add(0, bestSalon);
                Objects.requireNonNull(rv_types.getAdapter()).notifyDataSetChanged();
            } else if (i == 1) {
                headingList.add("Trending Salon Nearby");
                setTrendingSalonData();
                trendingSalon.setSalonData(trendingSalonData);
                mainLists.add(1, trendingSalon);
                rv_types.getAdapter().notifyDataSetChanged();
            } else if (i == 2) {
                headingList.add("Spacial Package & offers");
                setHotDeals();
                hotDeals.setSalonData(hotDealsData);
                mainLists.add(2, hotDeals);
                rv_types.getAdapter().notifyDataSetChanged();
            } else if (i == 3) {
                headingList.add("All New Salon Nearby");
                setLatestSalonData();
                latestSalon.setSalonData(latestSalonData);
                mainLists.add(3, latestSalon);
                rv_types.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void setTopCategoryAdapter() {
        rv_topServices.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        darkColorList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            darkColorList.add(generateDarkRenadomNumber());
            if (i == 9) {
                rv_topServices.setAdapter(new MainTopCategoriesAdapter(getActivity(), darkColorList, topCategoriesClickListner));
                break;
            }
        }
    }

    private void setBestSalonData() {
        bestSalonData = new ArrayList<>();

        SalonData data0 = new SalonData("This is best salon data", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", false);
        SalonData data1 = new SalonData("Naturals Salon", "4.0", "B-1, J BLOCK, 1st Floor", false);
        SalonData data2 = new SalonData("Hairport Unisex Salon", "1.2", "G 104, Shop Number 1, Main Road, Dwarka Sector 7, Delhi - 110075, Near Brahma Society and Opposite Gokul Garden", false);
        SalonData data3 = new SalonData("Looks Salon", "1.2", "Sco 122 Huda Market, Gurgaon Sector 46, Gurgaon - 122003", false);
        SalonData data4 = new SalonData("Jawed Habib Hair Studio", "1.2", "Shop Number C 70, Malviya Nagar, Delhi - 110017, Near Mother Diary Booth,Main Market", false);
        SalonData data5 = new SalonData("Beau Shop", "1.2", "A 2/115, Ground Floor, Rajouri Garden, Delhi - 110027, Behind Croma", false);
        SalonData data6 = new SalonData("ki ka unisex salon", "1.2", "180/C, jeevan Nagar, nr Tikona Park, Jeevan Park, Delhi - 110014 ", false);
        SalonData data7 = new SalonData("Dmd Salon", "1.2", "Jc 54 Ground Floor Gupta Colony, Khirki Extn, Gupta Colony, Malviya Nagar, Delhi - 110017, NiranKari Public School", false);
        SalonData data8 = new SalonData("Beauty Box Luxurious Salon", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", false);
        SalonData data9 = new SalonData("Beauty Box Luxurious Salon", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", false);

        bestSalonData.add(data0);
        bestSalonData.add(data1);
        bestSalonData.add(data2);
        bestSalonData.add(data3);
        bestSalonData.add(data4);
        bestSalonData.add(data5);
        bestSalonData.add(data6);
        bestSalonData.add(data7);
        bestSalonData.add(data8);
        bestSalonData.add(data9);
    }

    private void setTrendingSalonData() {
        trendingSalonData = new ArrayList<>();

        SalonData data0 = new SalonData("This is Trending salon Data", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", false);
        SalonData data1 = new SalonData("Naturals Salon", "4.0", "B-1, J BLOCK, 1st Floor", false);
        SalonData data2 = new SalonData("Hairport Unisex Salon", "1.2", "G 104, Shop Number 1, Main Road, Dwarka Sector 7, Delhi - 110075, Near Brahma Society and Opposite Gokul Garden", false);
        SalonData data3 = new SalonData("Looks Salon", "1.2", "Sco 122 Huda Market, Gurgaon Sector 46, Gurgaon - 122003", false);
        SalonData data4 = new SalonData("Jawed Habib Hair Studio", "1.2", "Shop Number C 70, Malviya Nagar, Delhi - 110017, Near Mother Diary Booth,Main Market", false);
        SalonData data5 = new SalonData("Beau Shop", "1.2", "A 2/115, Ground Floor, Rajouri Garden, Delhi - 110027, Behind Croma", false);
        SalonData data6 = new SalonData("ki ka unisex salon", "1.2", "180/C, jeevan Nagar, nr Tikona Park, Jeevan Park, Delhi - 110014 ", false);
        SalonData data7 = new SalonData("Dmd Salon", "1.2", "Jc 54 Ground Floor Gupta Colony, Khirki Extn, Gupta Colony, Malviya Nagar, Delhi - 110017, NiranKari Public School", false);
        SalonData data8 = new SalonData("Beauty Box Luxurious Salon", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", false);
        SalonData data9 = new SalonData("Beauty Box Luxurious Salon", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", false);

        trendingSalonData.add(data0);
        trendingSalonData.add(data1);
        trendingSalonData.add(data2);
        trendingSalonData.add(data3);
        trendingSalonData.add(data4);
        trendingSalonData.add(data5);
        trendingSalonData.add(data6);
        trendingSalonData.add(data7);
        trendingSalonData.add(data8);
        trendingSalonData.add(data9);
    }

    private void setHotDeals() {
        hotDealsData = new ArrayList<>();

        SalonData data0 = new SalonData("Beauty Box Luxurious Salon", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", true);
        SalonData data1 = new SalonData("Naturals Salon", "4.0", "B-1, J BLOCK, 1st Floor", true);
        SalonData data2 = new SalonData("Hairport Unisex Salon", "1.2", "G 104, Shop Number 1, Main Road, Dwarka Sector 7, Delhi - 110075, Near Brahma Society and Opposite Gokul Garden", true);
        SalonData data3 = new SalonData("Looks Salon", "1.2", "Sco 122 Huda Market, Gurgaon Sector 46, Gurgaon - 122003", true);
        SalonData data4 = new SalonData("Jawed Habib Hair Studio", "1.2", "Shop Number C 70, Malviya Nagar, Delhi - 110017, Near Mother Diary Booth,Main Market", true);
        SalonData data5 = new SalonData("Beau Shop", "1.2", "A 2/115, Ground Floor, Rajouri Garden, Delhi - 110027, Behind Croma", true);
        SalonData data6 = new SalonData("ki ka unisex salon", "1.2", "180/C, jeevan Nagar, nr Tikona Park, Jeevan Park, Delhi - 110014 ", true);
        SalonData data7 = new SalonData("Dmd Salon", "1.2", "Jc 54 Ground Floor Gupta Colony, Khirki Extn, Gupta Colony, Malviya Nagar, Delhi - 110017, NiranKari Public School", true);
        SalonData data8 = new SalonData("Beauty Box Luxurious Salon", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", true);
        SalonData data9 = new SalonData("Beauty Box Luxurious Salon", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", true);

        hotDealsData.add(data0);
        hotDealsData.add(data1);
        hotDealsData.add(data2);
        hotDealsData.add(data3);
        hotDealsData.add(data4);
        hotDealsData.add(data5);
        hotDealsData.add(data6);
        hotDealsData.add(data7);
        hotDealsData.add(data8);
        hotDealsData.add(data9);
    }

    private void setLatestSalonData() {
        latestSalonData = new ArrayList<>();

        SalonData data0 = new SalonData("This is Latest Salon data", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", false);
        SalonData data1 = new SalonData("Naturals Salon", "4.0", "B-1, J BLOCK, 1st Floor", false);
        SalonData data2 = new SalonData("Hairport Unisex Salon", "1.2", "G 104, Shop Number 1, Main Road, Dwarka Sector 7, Delhi - 110075, Near Brahma Society and Opposite Gokul Garden", false);
        SalonData data3 = new SalonData("Looks Salon", "1.2", "Sco 122 Huda Market, Gurgaon Sector 46, Gurgaon - 122003", false);
        SalonData data4 = new SalonData("Jawed Habib Hair Studio", "1.2", "Shop Number C 70, Malviya Nagar, Delhi - 110017, Near Mother Diary Booth,Main Market", false);
        SalonData data5 = new SalonData("Beau Shop", "1.2", "A 2/115, Ground Floor, Rajouri Garden, Delhi - 110027, Behind Croma", false);
        SalonData data6 = new SalonData("ki ka unisex salon", "1.2", "180/C, jeevan Nagar, nr Tikona Park, Jeevan Park, Delhi - 110014 ", false);
        SalonData data7 = new SalonData("Dmd Salon", "1.2", "Jc 54 Ground Floor Gupta Colony, Khirki Extn, Gupta Colony, Malviya Nagar, Delhi - 110017, NiranKari Public School", false);
        SalonData data8 = new SalonData("Beauty Box Luxurious Salon", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", false);
        SalonData data9 = new SalonData("Beauty Box Luxurious Salon", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", false);

        latestSalonData.add(data0);
        latestSalonData.add(data1);
        latestSalonData.add(data2);
        latestSalonData.add(data3);
        latestSalonData.add(data4);
        latestSalonData.add(data5);
        latestSalonData.add(data6);
        latestSalonData.add(data7);
        latestSalonData.add(data8);
        latestSalonData.add(data9);
    }

}
