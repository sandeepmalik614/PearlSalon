package com.pearl.salon.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

import com.pearl.salon.R;
import com.pearl.salon.adapter.salonDetail.GalleryImageSlideAdapter;

import java.util.ArrayList;

public class GalleryViewActivity extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private ArrayList<String> imageList;
    private TextView tv_pageNo;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_view);

        mPager = findViewById(R.id.vp_slider);
        tv_pageNo = findViewById(R.id.textView53);
        toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);

        imageList = new ArrayList<>();
        imageList = getIntent().getExtras().getStringArrayList("list");
        currentPage = getIntent().getExtras().getInt("position");

        NUM_PAGES = imageList.size();

        mPager.setAdapter(new GalleryImageSlideAdapter(this, imageList));
        mPager.setCurrentItem(currentPage, true);
        tv_pageNo.setText((currentPage + 1) + " of " + NUM_PAGES);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tv_pageNo.setText((position + 1) + " of " + NUM_PAGES);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
