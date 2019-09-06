package com.pearl.salon.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import com.pearl.salon.R;
import com.pearl.salon.utils.AppUtils;

public class SocialLoginActivity extends AppCompatActivity {

    private boolean doublePressedExit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_login);
//        AppUtils.setBarTransparent(this);

    }

    public void goToLogin(View view) {
        startActivity(new Intent(this, SimpleLoginActivity.class));
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

    @Override
    protected void onResume() {
        if(!AppUtils.isConnectionAvailable(this)){
            AppUtils.showBottomToast(this, "No internet connection, Please check your internet connection");
        }
        super.onResume();
    }

    public void googleLogin(View view) {
        if(AppUtils.isConnectionAvailable(this)){

        }else{
            AppUtils.showBottomToast(this, "No internet connection, Please check your internet connection");
        }
    }

    public void facebookLogin(View view) {
        if(AppUtils.isConnectionAvailable(this)){

        }else{
            AppUtils.showBottomToast(this, "No internet connection, Please check your internet connection");
        }
    }
}
