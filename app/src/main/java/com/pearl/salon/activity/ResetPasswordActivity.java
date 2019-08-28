package com.pearl.salon.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.pearl.salon.R;
import com.pearl.salon.utils.AppUtils;

import static com.pearl.salon.utils.AppUtils.clearAllIntent;

public class ResetPasswordActivity extends AppCompatActivity {

    private EditText edt_new_pass, edt_con_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        AppUtils.setBarTransparent(this);

        edt_new_pass = findViewById(R.id.edt_reset_new_password);
        edt_con_pass = findViewById(R.id.edt_reset_con_password);
    }

    public void resetPasswordBack(View view) {
        finish();
    }

    public void resetPassword(View view) {
        if(edt_new_pass.getText().toString().isEmpty()){
            AppUtils.showTopToast(this, "Please enter new password");
        }else if(edt_con_pass.getText().toString().isEmpty()){
            AppUtils.showTopToast(this, "Please enter confirm password");
        }else if(!edt_new_pass.getText().toString().equals(edt_con_pass.getText().toString())){
            AppUtils.showTopToast(this, "New password and Confirm password should be same");
        }else{
            AppUtils.showBottomToast(this, "Password changed successfully");
            Intent intent = new Intent(this, SocialLoginActivity.class);
            clearAllIntent(intent);
            startActivity(intent);
            finish();
        }
    }
}
