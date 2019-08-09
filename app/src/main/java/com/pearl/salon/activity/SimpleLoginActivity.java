package com.pearl.salon.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.pearl.salon.R;
import com.pearl.salon.utils.AppUtils;

public class SimpleLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_login);
        AppUtils.setBarTransparent(this);
    }

    public void goToRegister(View view) {

    }

    public void goToForgot(View view) {
        startActivity(new Intent(SimpleLoginActivity.this, ForgotPasswordActivity.class));
    }
}
