package com.pearl.salon.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.pearl.salon.R;
import com.pearl.salon.utils.AppPrefference;
import com.pearl.salon.utils.AppUtils;

public class SplashActivity extends AppCompatActivity {

    private ImageView img_logo;
    private TextView tv_appName, tv_tagLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        AppUtils.setBarTransparent(this);

        img_logo = findViewById(R.id.imageView5);
        tv_appName = findViewById(R.id.textView);
        tv_tagLine = findViewById(R.id.textView2);

        animate();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = null;
                if (AppPrefference.isIntroComplete(SplashActivity.this)) {
                    if (AppPrefference.isUserLoggedOut(SplashActivity.this)) {
                        intent = new Intent(SplashActivity.this, SocialLoginActivity.class);
                    } else {
                        intent = new Intent(SplashActivity.this, HomeActivity.class);
                    }
                } else {
                    intent = new Intent(SplashActivity.this, IntroActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, 1500);
    }

    @Override
    protected void onResume() {
        if(!AppUtils.isConnectionAvailable(this)){
            AppUtils.showBottomToast(this, "No internet connection, Please check your internet connection");
        }
        super.onResume();
    }

    private void animate() {
        Animation fadeIn = AnimationUtils
                .loadAnimation(SplashActivity.this, R.anim.fade_in);
        img_logo.startAnimation(fadeIn);
        tv_appName.startAnimation(fadeIn);
        tv_tagLine.startAnimation(fadeIn);
    }
}
