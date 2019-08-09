package com.pearl.salon.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.pearl.salon.R;
import com.pearl.salon.utils.AppUtils;

public class ResetPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        AppUtils.setBarTransparent(this);
    }
}
