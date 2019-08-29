package com.pearl.salon.activity;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.os.Handler;
import android.view.MenuItem;
import android.widget.TextView;

import com.pearl.salon.R;
import com.pearl.salon.utils.AppUtils;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private boolean doublePressedExit = false;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
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
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onBackPressed() {
        if(doublePressedExit){
            super.onBackPressed();
        }else{
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
}
