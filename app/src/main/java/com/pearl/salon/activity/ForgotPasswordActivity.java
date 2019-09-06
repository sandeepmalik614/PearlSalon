package com.pearl.salon.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pearl.salon.R;
import com.pearl.salon.utils.AppUtils;

import static com.pearl.salon.utils.AppUtils.hideKeyboard;
import static com.pearl.salon.utils.AppUtils.isConnectionAvailable;
import static com.pearl.salon.utils.AppUtils.isValidEmail;
import static com.pearl.salon.utils.AppUtils.openCodeSentDialog;
import static com.pearl.salon.utils.AppUtils.setBarTransparent;
import static com.pearl.salon.utils.AppUtils.showKeyboard;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText edt_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
//        setBarTransparent(this);
        showKeyboard(this);
        edt_email = findViewById(R.id.editText);
        edt_email.requestFocus();

    }

    public void onBackForgot(View view) {
        hideKeyboard(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onBackPressed();
            }
        }, 100);
    }

    public void sendForgotOtp(View view) {
        if (isConnectionAvailable(this)) {
            if (edt_email.getText().toString().isEmpty()) {
                Toast.makeText(this, "Enter your email id", Toast.LENGTH_SHORT).show();
            } else if (!isValidEmail(edt_email.getText().toString())) {
                Toast.makeText(this, "Enter a valid email id", Toast.LENGTH_SHORT).show();
            } else {
                hideKeyboard(this);
                openCodeSentDialog(this, "ForgotPassword");
            }
        }else{
            AppUtils.showBottomToast(this, "No internet connection, Please check your internet connection");
        }
    }

    @Override
    protected void onResume() {
        if (!AppUtils.isConnectionAvailable(this)) {
            AppUtils.showBottomToast(this, "No internet connection, Please check your internet connection");
        }
        super.onResume();
    }
}
