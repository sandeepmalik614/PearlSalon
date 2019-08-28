package com.pearl.salon.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.pearl.salon.R;
import com.pearl.salon.utils.AppUtils;

import static com.pearl.salon.utils.AppPrefference.setUserEmail;
import static com.pearl.salon.utils.AppPrefference.setUserGender;
import static com.pearl.salon.utils.AppPrefference.setUserLoggedOut;
import static com.pearl.salon.utils.AppPrefference.setUserName;
import static com.pearl.salon.utils.AppUtils.clearAllIntent;

public class SimpleLoginActivity extends AppCompatActivity {

    private EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_login);
        AppUtils.setBarTransparent(this);

        username = findViewById(R.id.editText2);
        password = findViewById(R.id.editText3);
    }

    public void goToRegister(View view) {
        startActivity(new Intent(SimpleLoginActivity.this, RegisterMobileVerifyActvity.class));
    }

    public void goToForgot(View view) {
        startActivity(new Intent(SimpleLoginActivity.this, ForgotPasswordActivity.class));
    }

    public void signInUser(View view) {
        if (username.getText().toString().isEmpty()) {
            AppUtils.showBottomToast(this, "Enter your Mobile/Email");
        } else if (password.getText().toString().isEmpty()) {
            AppUtils.showBottomToast(this, "Enter password");
        } else {
            setUserLoggedOut(this, false);
            setUserName(this, "Sandeep Malik");
            setUserEmail(this, "sandeep.malik@hkdigitalonline.com");
            setUserGender(this, "Male");
            Intent intent = new Intent(this, MainActivity.class);
            clearAllIntent(intent);
            startActivity(intent);
            finish();
        }
    }
}
