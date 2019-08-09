package com.pearl.salon.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.pearl.salon.R;
import com.pearl.salon.utils.AppUtils;

public class SocialLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_login);
        AppUtils.setBarTransparent(this);

    }

    public void goToLogin(View view) {
        startActivity(new Intent(this, SimpleLoginActivity.class));
    }
}
