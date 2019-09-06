package com.pearl.salon.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pearl.salon.R;
import com.pearl.salon.utils.AppPrefference;
import com.pearl.salon.utils.AppUtils;

import static com.pearl.salon.utils.AppUtils.clearAllIntent;
import static com.pearl.salon.utils.AppUtils.isConnectionAvailable;
import static com.pearl.salon.utils.AppUtils.openCodeSentDialog;
import static com.pearl.salon.utils.AppUtils.setBarTransparent;

public class RegisterMobileVerifyActvity extends AppCompatActivity {

    private EditText mobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_mobile_verify_actvity);
//        setBarTransparent(this);
        mobileNumber = findViewById(R.id.editText10);
    }

    public void clearEditText(View view) {
        if(!mobileNumber.getText().toString().isEmpty()){
            mobileNumber.getText().clear();
        }
    }

    public void verifyMobileBack(View view) {
        finish();
    }

    public void verifyMobile(View view) {
        if(isConnectionAvailable(this)) {
            if (mobileNumber.getText().toString().isEmpty() || mobileNumber.getText().length() < 10) {
                AppUtils.showTopToast(this, "Please enter a valid mobile number");
            } else {
                AppPrefference.setUserMobileNumber(this, mobileNumber.getText().toString());
                openCodeSentDialog(this, "MobileVerify");
            }
        }else{
            AppUtils.showBottomToast(this, "No internet connection, Please check your internet connection");
        }
    }

    public void gotToSicialLogin(View view) {
        Intent intent = new Intent(this, SocialLoginActivity.class);
        clearAllIntent(intent);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onResume() {
        if(!AppUtils.isConnectionAvailable(this)){
            AppUtils.showBottomToast(this, "No internet connection, Please check your internet connection");
        }
        super.onResume();
    }
}
