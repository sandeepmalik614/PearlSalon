package com.pearl.salon.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.pearl.salon.R;
import com.pearl.salon.utils.CircleImageView;
import com.pearl.salon.fragment.barberProfile.BarberPortfolioFragment;
import com.pearl.salon.fragment.barberProfile.BarberReviewFragment;

public class StaffProfileActivity extends AppCompatActivity {

    private CircleImageView userImage;
    private ImageView bannerImage, img_staff_back, img_staff_save;
    private TabLayout tab_barberProfile;
    private boolean isSaved = false;
    private TextView bookNow;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_profile);

        userImage = findViewById(R.id.img_staff_user);
        bannerImage = findViewById(R.id.img_staff_banner);
        tab_barberProfile = findViewById(R.id.tab_barberProfile);
        img_staff_back = findViewById(R.id.img_staff_back);
        img_staff_save = findViewById(R.id.img_staff_save);
        bookNow = findViewById(R.id.tv_barberProfile_book);

        img_staff_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        img_staff_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isSaved){
                    isSaved = false;
                    img_staff_save.setBackgroundResource(R.drawable.ic_save_later_white_24dp);
                }else{
                    isSaved = true;
                    img_staff_save.setBackgroundResource(R.drawable.ic_saved_24dp);
                }
            }
        });

        bookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StaffProfileActivity.this, BookFirstActivity.class));
            }
        });

        Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQX1Zl9dZiTBT8WwG36HWdrMlTvJckwUn5VL4IciQLNVeGc-enk9A")
                .into(bannerImage);

        Glide.with(this).load("https://dixmfnt6b5ogu.cloudfront.net/user/pages/02.home-9a/05._testimonials-2/jonas-eilsoe-profil-kvadrat.jpg?g-5d85d749")
                .into(userImage);

        tab_barberProfile.addTab(tab_barberProfile.newTab().setText("Portfolio"));
        tab_barberProfile.addTab(tab_barberProfile.newTab().setText("Review"));

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_barberProfile, new BarberPortfolioFragment()).commit();

        tab_barberProfile.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_barberProfile, new BarberPortfolioFragment()).commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_barberProfile, new BarberReviewFragment()).commit();
                        break;
                    // Continue for each tab in TabLayout
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
