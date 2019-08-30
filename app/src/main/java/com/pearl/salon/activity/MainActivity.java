package com.pearl.salon.activity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.pearl.salon.R;
import com.pearl.salon.fragment.AppointmentFragment;
import com.pearl.salon.fragment.HomeFragment;
import com.pearl.salon.fragment.InboxFragment;
import com.pearl.salon.fragment.NearbyFragment;
import com.pearl.salon.fragment.ProfileFragment;
import com.pearl.salon.utils.AppUtils;

public class MainActivity extends AppCompatActivity {

    private boolean doublePressedExit = false;
    private BottomNavigationView navView;
    final Fragment fragment1 = new HomeFragment();
    final Fragment fragment2 = new NearbyFragment();
    final Fragment fragment3 = new InboxFragment();
    final Fragment fragment4 = new AppointmentFragment();
    final Fragment fragment5 = new ProfileFragment();
    private FragmentTransaction fragmentTransaction;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    switchFragment(fragment1);
                    return true;
                case R.id.nav_nearby:
                    switchFragment(fragment2);
                    return true;
                case R.id.nav_inbox:
                    switchFragment(fragment3);
                    return true;
                case R.id.nav_appointment:
                    switchFragment(fragment4);
                    return true;
                case R.id.nav_profile:
                    switchFragment(fragment5);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppUtils.setBarTransparent(this);
        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        switchFragment(fragment1);
    }

    private void switchFragment(Fragment fragment) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (doublePressedExit) {
            super.onBackPressed();
        } else {
            AppUtils.showBottomToast(this, "Please click BACK again to exit");
            doublePressedExit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doublePressedExit = false;
                }
            }, 2000);
        }
    }

    @Override
    protected void onResume() {
        if(!AppUtils.isConnectionAvailable(this)){
            AppUtils.showBottomToast(this, "No internet connection, Please check your internet connection");
        }
        super.onResume();
    }
}
