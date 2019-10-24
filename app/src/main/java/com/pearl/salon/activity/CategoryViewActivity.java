package com.pearl.salon.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pearl.salon.R;
import com.pearl.salon.adapter.CategorySalonAdapter;
import com.pearl.salon.clickListner.HomeClickListner;
import com.pearl.salon.model.home.SalonData;

import java.util.ArrayList;

import static com.pearl.salon.utils.AppUtils.generateLightRenadomNumber;
import static com.pearl.salon.utils.AppUtils.generateRandomNumber;

public class CategoryViewActivity extends AppCompatActivity {

    private RecyclerView rv_category;
    private TextView tv_categoryName;
    private ImageView img_back;
    private ArrayList<SalonData> salonData;
    private ArrayList<String> lightColorList;

    private HomeClickListner homeClickListner = new HomeClickListner() {
        @Override
        public void mainClick(String heading) {
            Toast.makeText(CategoryViewActivity.this, "" + heading, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void childClick(String salonName, boolean isAdd) {
            if (isAdd) {
                Toast.makeText(CategoryViewActivity.this, "This is add", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(new Intent(CategoryViewActivity.this, SalonDetailActivity.class));
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_view);

        rv_category = findViewById(R.id.rv_category);
        tv_categoryName = findViewById(R.id.textView85);
        img_back = findViewById(R.id.imageView30);

        tv_categoryName.setText(getIntent().getStringExtra("categoryName"));

        rv_category.setLayoutManager(new GridLayoutManager(this, 2));

        salonData = new ArrayList<>();
        lightColorList = new ArrayList<>();

        setSalonData();

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setSalonData() {
        salonData = new ArrayList<>();

        SalonData data0 = new SalonData("This is best salon data", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", false, generateRandomNumber());
        SalonData data1 = new SalonData("Naturals Salon", "4.0", "B-1, J BLOCK, 1st Floor", false, generateRandomNumber());
        SalonData data2 = new SalonData("Hairport Unisex Salon", "1.2", "G 104, Shop Number 1, Main Road, Dwarka Sector 7, Delhi - 110075, Near Brahma Society and Opposite Gokul Garden", false, generateRandomNumber());
        SalonData data3 = new SalonData("Looks Salon", "1.2", "Sco 122 Huda Market, Gurgaon Sector 46, Gurgaon - 122003", false, generateRandomNumber());
        SalonData data4 = new SalonData("Jawed Habib Hair Studio", "1.2", "Shop Number C 70, Malviya Nagar, Delhi - 110017, Near Mother Diary Booth,Main Market", true, generateRandomNumber());
        SalonData data5 = new SalonData("Beau Shop", "1.2", "A 2/115, Ground Floor, Rajouri Garden, Delhi - 110027, Behind Croma", true, generateRandomNumber());
        SalonData data6 = new SalonData("ki ka unisex salon", "1.2", "180/C, jeevan Nagar, nr Tikona Park, Jeevan Park, Delhi - 110014 ", false, generateRandomNumber());
        SalonData data7 = new SalonData("Dmd Salon", "1.2", "Jc 54 Ground Floor Gupta Colony, Khirki Extn, Gupta Colony, Malviya Nagar, Delhi - 110017, NiranKari Public School", false, generateRandomNumber());
        SalonData data8 = new SalonData("Beauty Box Luxurious Salon", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", false, generateRandomNumber());
        SalonData data9 = new SalonData("Beauty Box Luxurious Salon", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", false, generateRandomNumber());
        SalonData data10 = new SalonData("Jawed Habib Hair Studio", "1.2", "Shop Number C 70, Malviya Nagar, Delhi - 110017, Near Mother Diary Booth,Main Market", true, generateRandomNumber());
        SalonData data11 = new SalonData("Beau Shop", "1.2", "A 2/115, Ground Floor, Rajouri Garden, Delhi - 110027, Behind Croma", true, generateRandomNumber());
        SalonData data12 = new SalonData("ki ka unisex salon", "1.2", "180/C, jeevan Nagar, nr Tikona Park, Jeevan Park, Delhi - 110014 ", false, generateRandomNumber());
        SalonData data13 = new SalonData("Dmd Salon", "1.2", "Jc 54 Ground Floor Gupta Colony, Khirki Extn, Gupta Colony, Malviya Nagar, Delhi - 110017, NiranKari Public School", false, generateRandomNumber());
        SalonData data14 = new SalonData("Beauty Box Luxurious Salon", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", false, generateRandomNumber());
        SalonData data15 = new SalonData("Beauty Box Luxurious Salon", "1.2", "C-1/15, Rohini Sector 15, Delhi - 110089, Opposite Sunrise Hospital", false, generateRandomNumber());

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
        salonData.add(data10);
        salonData.add(data11);
        salonData.add(data12);
        salonData.add(data13);
        salonData.add(data14);
        salonData.add(data15);

        for (int j = 0; j < salonData.size(); j++) {
            lightColorList.add(generateLightRenadomNumber());
            if (j == (salonData.size() - 1)) {
                rv_category.setAdapter(new CategorySalonAdapter(CategoryViewActivity.this, lightColorList, salonData, homeClickListner));
            }
        }
    }
}
