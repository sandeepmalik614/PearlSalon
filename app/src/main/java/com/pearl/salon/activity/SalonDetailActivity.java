package com.pearl.salon.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.pearl.salon.R;
import com.pearl.salon.adapter.salonDetail.SalonSpecialistAdapter;
import com.pearl.salon.fragment.salonDetailsFragments.SalonAboutFragment;
import com.pearl.salon.fragment.salonDetailsFragments.SalonGalleryFragment;
import com.pearl.salon.fragment.salonDetailsFragments.SalonReviewFragment;
import com.pearl.salon.fragment.salonDetailsFragments.SalonServicesFragment;
import com.pearl.salon.utils.AppUtils;

public class SalonDetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView salonImage, img_like_salon;
    private TextView tv_salonName, tv_salonAdd, tv_salonStatus, tv_reviewCount, tv_tb_salonName;
    private RatingBar ratingBar;
    private RecyclerView rv_salonSpecialists;
    private boolean isLike = false;
    private TabLayout tabLayout;
    private NestedScrollView nsv_salonDetail;
    private boolean isDarkTootlbar = false;
    private LinearLayout ll_share;

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i2 = new Intent(SalonDetailActivity.this, StaffProfileActivity.class);
            startActivity(i2);
            overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
        }
    };

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_detail);

        tabLayout = findViewById(R.id.tab_salonSpecialists);
//        viewPager = findViewById(R.id.vp_salonSpecialists);
        rv_salonSpecialists = findViewById(R.id.rv_salonSpecialists);
        img_like_salon = findViewById(R.id.img_like_salon);
        salonImage = findViewById(R.id.imageView16);
        tv_tb_salonName = findViewById(R.id.tv_tb_salonName);
        tv_salonName = findViewById(R.id.textView31);
        tv_salonAdd = findViewById(R.id.textView30);
        tv_salonStatus = findViewById(R.id.textView28);
        tv_reviewCount = findViewById(R.id.textView29);
        ratingBar = findViewById(R.id.ratingBarDetailPage);
        nsv_salonDetail = findViewById(R.id.nsv_salonDetail);
        ll_share = findViewById(R.id.ll_share_salon_details);
        toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        tabLayout.addTab(tabLayout.newTab().setText("About"));
        tabLayout.addTab(tabLayout.newTab().setText("Services"));
        tabLayout.addTab(tabLayout.newTab().setText("Gallery"));
        tabLayout.addTab(tabLayout.newTab().setText("Review"));

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new SalonAboutFragment()).commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (tab.getPosition()) {
                    case 0:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, new SalonAboutFragment()).commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, new SalonServicesFragment()).commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, new SalonGalleryFragment()).commit();
                        break;
                    case 3:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, new SalonReviewFragment()).commit();
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

        rv_salonSpecialists.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        rv_salonSpecialists.setAdapter(new SalonSpecialistAdapter(this, onClickListener));

        tv_salonName.setText("Main Street Salon");
        tv_tb_salonName.setText("Main Street Salon");
        tv_salonAdd.setText("Raquel, Christine & Mamie 3821 Culver City");
        Glide.with(this).load("https://images.squarespace-cdn.com/content/v1/587ed62137c581c9c42fee61/1487379670546-RK2BWY5T8KNSURFC59C8/ke17ZwdGBToddI8pDm48kLkXF2pIyv_F2eUT9F60jBl7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0iyqMbMesKd95J-X4EagrgU9L3Sa3U8cogeb0tjXbfawd0urKshkc5MgdBeJmALQKw/mainstreetsalon-14.jpg?format=2500w")
                .into(salonImage);

        img_like_salon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isLike) {
                    isLike = false;
                    img_like_salon.setBackgroundResource(R.drawable.ic_favorite_not_24dp);
                } else {
                    isLike = true;
                    img_like_salon.setBackgroundResource(R.drawable.ic_favorite_24dp);
                }
            }
        });

        nsv_salonDetail.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                if (scrollY > oldScrollY) {
                    if (!isDarkTootlbar) {
                        isDarkTootlbar = true;
                        tv_tb_salonName.setTextColor(Color.parseColor("#ffffff"));
                        toolbar.setBackgroundResource(R.color.colorPrimary);
                        Animation fadeIn = AnimationUtils
                                .loadAnimation(SalonDetailActivity.this, R.anim.fade_in);
                        toolbar.startAnimation(fadeIn);
                        tv_tb_salonName.startAnimation(fadeIn);
                    }

                }

                if (scrollY == 0) {
                    isDarkTootlbar = false;
                    tv_tb_salonName.setTextColor(Color.parseColor("#00FFFFFF"));
                    toolbar.setBackgroundResource(R.color.transparent);
                    Animation fadeIn = AnimationUtils
                            .loadAnimation(SalonDetailActivity.this, R.anim.fade_in);
                    toolbar.startAnimation(fadeIn);
                    tv_tb_salonName.startAnimation(fadeIn);
                }

                if (scrollY == (v.getMeasuredHeight() - v.getChildAt(0).getMeasuredHeight())) {
                    Toast.makeText(SalonDetailActivity.this, "BOTTOM SCROLL", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ll_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppUtils.share(SalonDetailActivity.this, "Pearl Salon youtube video: https://www.youtube.com/watch?v=2Nc2ZI-pZhQ");
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
