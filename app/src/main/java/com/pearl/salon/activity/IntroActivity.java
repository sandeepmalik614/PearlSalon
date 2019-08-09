package com.pearl.salon.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.pearl.salon.R;
import com.pearl.salon.utils.AppPrefference;
import com.pearl.salon.utils.AppUtils;

public class IntroActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private Button btn_next;
    private MyViewPagerAdapter myViewPagerAdapter;
    private int[] layouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        AppUtils.setBarTransparent(this);

        viewPager = findViewById(R.id.viewPager);
        btn_next = findViewById(R.id.button);
        layouts = new int[]{
                R.layout.intro_one,
                R.layout.intro_two};

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = getItem(+1);
                if (current < layouts.length) {
                    viewPager.setCurrentItem(current);
                } else {
                    AppPrefference.setIntroComplete(IntroActivity.this, true);
                    Intent intent = new Intent(IntroActivity.this, SocialLoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            if (position == layouts.length - 1) {
                btn_next.setText("Get Started");
            } else {
                btn_next.setText("Next");
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };


    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
