package com.pearl.salon.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.pearl.salon.R;
import com.pearl.salon.utils.AppPrefference;
import com.pearl.salon.utils.AppUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        AppUtils.setBarTransparent(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = null;
                if (AppPrefference.isIntroComplete(SplashActivity.this)) {
                    if (AppPrefference.isUserLoggedOut(SplashActivity.this)) {
                        intent = new Intent(SplashActivity.this, SocialLoginActivity.class);
                    } else {
                        intent = new Intent(SplashActivity.this, MainActivity.class);
                    }
                } else {
                    intent = new Intent(SplashActivity.this, IntroActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, 1500);
    }
}
