package com.pearl.salon.activity;

import androidx.appcompat.app.AppCompatActivity;

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

import static com.pearl.salon.utils.AppUtils.hideKeyboard;
import static com.pearl.salon.utils.AppUtils.isValidEmail;
import static com.pearl.salon.utils.AppUtils.setBarTransparent;
import static com.pearl.salon.utils.AppUtils.showKeyboard;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText edt_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        setBarTransparent(this);
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
        if (edt_email.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter your email id", Toast.LENGTH_SHORT).show();
        } else if (!isValidEmail(edt_email.getText().toString())) {
            Toast.makeText(this, "Enter a valid email id", Toast.LENGTH_SHORT).show();
        } else {
            hideKeyboard(this);
            openCodeSentDialog();
        }
    }

    private void openCodeSentDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setCanceledOnTouchOutside(false);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_code_sent);

        Button btn_done = dialog.findViewById(R.id.btn_dialogDone);
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                startActivity(new Intent(ForgotPasswordActivity.this, OtpVerificationActivity.class));
            }
        });

        dialog.show();
    }
}
