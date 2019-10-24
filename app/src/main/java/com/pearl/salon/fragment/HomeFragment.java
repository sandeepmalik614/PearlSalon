package com.pearl.salon.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pearl.salon.R;
import com.pearl.salon.activity.SalonDetailActivity;
import com.pearl.salon.adapter.HomeTypesAdapter;
import com.pearl.salon.adapter.MainTopCategoriesAdapter;
import com.pearl.salon.clickListner.HomeClickListner;
import com.pearl.salon.clickListner.TopCategoriesClickListner;
import com.pearl.salon.model.home.MainList;
import com.pearl.salon.model.home.SalonData;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import static com.pearl.salon.utils.AppUtils.generateLightRenadomNumber;
import static com.pearl.salon.utils.AppUtils.generateRandomNumber;


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
    private SwipeRefreshLayout mainSwipe;

    private HomeClickListner homeClickListner = new HomeClickListner() {
        @Override
        public void mainClick(String heading) {
            Toast.makeText(getActivity(), "" + heading, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void childClick(String salonName, boolean isAdd) {
            if (isAdd) {
                Toast.makeText(getActivity(), "This is add", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(new Intent(getActivity(), SalonDetailActivity.class));
            }
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
        mainView = inflater.inflate(R.layout.fragment_home, container, false);

        rv_home_topCategories = mainView.findViewById(R.id.rv_home_topCategories);
        tv_topCatogiresSeeAll = mainView.findViewById(R.id.tv_topCatogiresSeeAll);
        edt_mainSearch = mainView.findViewById(R.id.edt_mainSearch);
        rv_home_types = mainView.findViewById(R.id.rv_home_types);
        mainSwipe = mainView.findViewById(R.id.homeRefreshLayout);

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

            }
        });

        mainSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                setView();
                mainSwipe.setRefreshing(false);
            }
        });

        return mainView;
    }

    private void setView() {
        rv_home_types.setLayoutManager(new LinearLayoutManager(getActivity()));
        headingList = new ArrayList<>();
        lightColorList = new ArrayList<>();
        lightColorList.clear();
        for (int j = 0; j < 10; j++) {
            lightColorList.add(generateLightRenadomNumber());
        }
        rv_home_types.setAdapter(new HomeTypesAdapter(getActivity(), lightColorList, mainLists, headingList, homeClickListner));
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                headingList.add("Best Salon");
                setBestSalonData();
                bestSalon.setSalonData(bestSalonData);
                mainLists.add(0, bestSalon);
                Objects.requireNonNull(rv_home_types.getAdapter()).notifyDataSetChanged();
            } else if (i == 1) {
                headingList.add("Trending Salon");
                setTrendingSalonData();
                trendingSalon.setSalonData(trendingSalonData);
                mainLists.add(1, trendingSalon);
                rv_home_types.getAdapter().notifyDataSetChanged();
            } else if (i == 2) {
                headingList.add("Hot Deals");
                setHotDeals();
                hotDeals.setSalonData(hotDealsData);
                mainLists.add(2, hotDeals);
                rv_home_types.getAdapter().notifyDataSetChanged();
            } else if (i == 3) {
                headingList.add("Latest Salon");
                setLatestSalonData();
                latestSalon.setSalonData(latestSalonData);
                mainLists.add(3, latestSalon);
                rv_home_types.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void setTopCategoryAdapter() {
        rv_home_topCategories.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        ArrayList<Integer> iconList = new ArrayList<>();
        iconList.add(R.drawable.cosmetics);
        iconList.add(R.drawable.cosmetics1);
        iconList.add(R.drawable.grooming);
        iconList.add(R.drawable.hair_cutting);
        iconList.add(R.drawable.make_up);
        iconList.add(R.drawable.makeover);
        iconList.add(R.drawable.moisturizer);

        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("Face Care");
        nameList.add("Eye Care");
        nameList.add("Grooming");
        nameList.add("Hair Cutting");
        nameList.add("Make Up");
        nameList.add("Makeover");
        nameList.add("Moisturizer");
        rv_home_topCategories.setAdapter(new MainTopCategoriesAdapter(getActivity(), nameList, topCategoriesClickListner, iconList));
    }

    private void setBestSalonData() {
        bestSalonData = new ArrayList<>();

        SalonData data0 = new SalonData("This is best salon data", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", false, generateRandomNumber());
        SalonData data1 = new SalonData("Naturals Salon", "4.0", "B-1, J BLOCK, 1st Floor", false, generateRandomNumber());
        SalonData data2 = new SalonData("Hairport Unisex Salon", "1.2", "G 104, Shop Number 1, Main Road, Dwarka Sector 7, Delhi - 110075, Near Brahma Society and Opposite Gokul Garden", false, generateRandomNumber());
        SalonData data3 = new SalonData("Looks Salon", "1.2", "Sco 122 Huda Market, Gurgaon Sector 46, Gurgaon - 122003", false, generateRandomNumber());
        SalonData data4 = new SalonData("Jawed Habib Hair Studio", "1.2", "Shop Number C 70, Malviya Nagar, Delhi - 110017, Near Mother Diary Booth,Main Market", false, generateRandomNumber());
        SalonData data5 = new SalonData("Beau Shop", "1.2", "A 2/115, Ground Floor, Rajouri Garden, Delhi - 110027, Behind Croma", false, generateRandomNumber());
        SalonData data6 = new SalonData("ki ka unisex salon", "1.2", "180/C, jeevan Nagar, nr Tikona Park, Jeevan Park, Delhi - 110014 ", false, generateRandomNumber());
        SalonData data7 = new SalonData("Dmd Salon", "1.2", "Jc 54 Ground Floor Gupta Colony, Khirki Extn, Gupta Colony, Malviya Nagar, Delhi - 110017, NiranKari Public School", false, generateRandomNumber());
        SalonData data8 = new SalonData("Beauty Box Luxurious Salon", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", false, generateRandomNumber());
        SalonData data9 = new SalonData("Beauty Box Luxurious Salon", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", false, generateRandomNumber());

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

        SalonData data0 = new SalonData("This is best salon data", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", false, generateRandomNumber());
        SalonData data1 = new SalonData("Naturals Salon", "4.0", "B-1, J BLOCK, 1st Floor", false, generateRandomNumber());
        SalonData data2 = new SalonData("Hairport Unisex Salon", "1.2", "G 104, Shop Number 1, Main Road, Dwarka Sector 7, Delhi - 110075, Near Brahma Society and Opposite Gokul Garden", false, generateRandomNumber());
        SalonData data3 = new SalonData("Looks Salon", "1.2", "Sco 122 Huda Market, Gurgaon Sector 46, Gurgaon - 122003", false, generateRandomNumber());
        SalonData data4 = new SalonData("Jawed Habib Hair Studio", "1.2", "Shop Number C 70, Malviya Nagar, Delhi - 110017, Near Mother Diary Booth,Main Market", false, generateRandomNumber());
        SalonData data5 = new SalonData("Beau Shop", "1.2", "A 2/115, Ground Floor, Rajouri Garden, Delhi - 110027, Behind Croma", false, generateRandomNumber());
        SalonData data6 = new SalonData("ki ka unisex salon", "1.2", "180/C, jeevan Nagar, nr Tikona Park, Jeevan Park, Delhi - 110014 ", false, generateRandomNumber());
        SalonData data7 = new SalonData("Dmd Salon", "1.2", "Jc 54 Ground Floor Gupta Colony, Khirki Extn, Gupta Colony, Malviya Nagar, Delhi - 110017, NiranKari Public School", false, generateRandomNumber());
        SalonData data8 = new SalonData("Beauty Box Luxurious Salon", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", false, generateRandomNumber());
        SalonData data9 = new SalonData("Beauty Box Luxurious Salon", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", false, generateRandomNumber());

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

        SalonData data0 = new SalonData("This is best salon data", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", true, "https://www.lakmesalon.in/sk-eu/content/dam/brands/lakme/india/1560314-lakme-salon-offer-march-new.png");
        SalonData data1 = new SalonData("Naturals Salon", "4.0", "B-1, J BLOCK, 1st Floor", true, "data:image/jpeg;base64,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");
        SalonData data2 = new SalonData("Hairport Unisex Salon", "1.2", "G 104, Shop Number 1, Main Road, Dwarka Sector 7, Delhi - 110075, Near Brahma Society and Opposite Gokul Garden", true, "https://d23uu0nprippzl.cloudfront.net/m/mi/m/mc-o0165258/2.jpg");
        SalonData data3 = new SalonData("Looks Salon", "1.2", "Sco 122 Huda Market, Gurgaon Sector 46, Gurgaon - 122003", true, "https://www.thefreedeals.com/assets/images/web-professional-looks-hair-and-beauty-salon-amrt.jpg");
        SalonData data4 = new SalonData("Jawed Habib Hair Studio", "1.2", "Shop Number C 70, Malviya Nagar, Delhi - 110017, Near Mother Diary Booth,Main Market", true, "https://www.eyecatchers.in/upload/media/Offer_List/EC_Yes_Bank_Offer.jpg");
        SalonData data5 = new SalonData("Beau Shop", "1.2", "A 2/115, Ground Floor, Rajouri Garden, Delhi - 110027, Behind Croma", true, "https://d1csarkz8obe9u.cloudfront.net/posterpreviews/purple-hair-salon-special-offer-banner-design-template-c8a655238cce2f50b9546f210eb3199f_screen.jpg?ts=1561539416");
        SalonData data6 = new SalonData("ki ka unisex salon", "1.2", "180/C, jeevan Nagar, nr Tikona Park, Jeevan Park, Delhi - 110014 ", true, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUtPE-2rv6C_ac5T_CVAbcf29TGdLCZnDuU_aYtwm6uLUUf47GgQ");
        SalonData data7 = new SalonData("Dmd Salon", "1.2", "Jc 54 Ground Floor Gupta Colony, Khirki Extn, Gupta Colony, Malviya Nagar, Delhi - 110017, NiranKari Public School", true, "https://media1.ppl-media.com/mediafiles/e-mag/2014/03/Enrich-Salon-facebook-Offer-6-March.jpg");
        SalonData data8 = new SalonData("Beauty Box Luxurious Salon", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", true, "https://d1m6qo1ndegqmm.cloudfront.net/uploadimages/coupons/11477-Shine_Zone_Saloon_Haircut_Facial_Packages_Chennai_Coupon_1.jpg");
        SalonData data9 = new SalonData("Beauty Box Luxurious Salon", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", true, "https://lh3.googleusercontent.com/kkgSvpj6CJES2tYPv3ScUbhjzKisKisgBtlVUSQGVP3Ammkb8NTsbVvny9iMpTBkGfya");

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

        SalonData data0 = new SalonData("This is best salon data", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", false, generateRandomNumber());
        SalonData data1 = new SalonData("Naturals Salon", "4.0", "B-1, J BLOCK, 1st Floor", false, generateRandomNumber());
        SalonData data2 = new SalonData("Hairport Unisex Salon", "1.2", "G 104, Shop Number 1, Main Road, Dwarka Sector 7, Delhi - 110075, Near Brahma Society and Opposite Gokul Garden", false, generateRandomNumber());
        SalonData data3 = new SalonData("Looks Salon", "1.2", "Sco 122 Huda Market, Gurgaon Sector 46, Gurgaon - 122003", false, generateRandomNumber());
        SalonData data4 = new SalonData("Jawed Habib Hair Studio", "1.2", "Shop Number C 70, Malviya Nagar, Delhi - 110017, Near Mother Diary Booth,Main Market", false, generateRandomNumber());
        SalonData data5 = new SalonData("Beau Shop", "1.2", "A 2/115, Ground Floor, Rajouri Garden, Delhi - 110027, Behind Croma", false, generateRandomNumber());
        SalonData data6 = new SalonData("ki ka unisex salon", "1.2", "180/C, jeevan Nagar, nr Tikona Park, Jeevan Park, Delhi - 110014 ", false, generateRandomNumber());
        SalonData data7 = new SalonData("Dmd Salon", "1.2", "Jc 54 Ground Floor Gupta Colony, Khirki Extn, Gupta Colony, Malviya Nagar, Delhi - 110017, NiranKari Public School", false, generateRandomNumber());
        SalonData data8 = new SalonData("Beauty Box Luxurious Salon", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", false, generateRandomNumber());
        SalonData data9 = new SalonData("Beauty Box Luxurious Salon", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", false, generateRandomNumber());

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
