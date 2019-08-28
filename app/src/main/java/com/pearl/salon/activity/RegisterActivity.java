package com.pearl.salon.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.pearl.salon.R;
import com.pearl.salon.utils.AppPrefference;
import com.pearl.salon.utils.AppUtils;

import static com.pearl.salon.utils.AppPrefference.setUserEmail;
import static com.pearl.salon.utils.AppPrefference.setUserGender;
import static com.pearl.salon.utils.AppPrefference.setUserLoggedOut;
import static com.pearl.salon.utils.AppPrefference.setUserName;
import static com.pearl.salon.utils.AppUtils.clearAllIntent;
import static com.pearl.salon.utils.AppUtils.isValidEmail;
import static com.pearl.salon.utils.AppUtils.showBottomToast;

public class RegisterActivity extends AppCompatActivity {

    private EditText edt_name, edt_email, edt_phone, edt_dob, edt_pass, edt_conPass;
    private RadioButton rb_male, rb_female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        AppUtils.setBarTransparent(this);

        edt_name = findViewById(R.id.editText4);
        edt_email = findViewById(R.id.editText5);
        edt_phone = findViewById(R.id.editText6);
        edt_dob = findViewById(R.id.editText7);
        edt_pass = findViewById(R.id.editText8);
        edt_conPass = findViewById(R.id.editText9);
        rb_male = findViewById(R.id.rb_male);
        rb_female = findViewById(R.id.rb_female);

        if(!AppPrefference.getUserMobileNumber(this).isEmpty()){
            edt_phone.setText(AppPrefference.getUserMobileNumber(this));
            edt_phone.setEnabled(false);
        }

    }

    public void backToLogin(View view) {
        finish();
    }

    public void alreadyLogin(View view) {
        Intent intent = new Intent(this, SocialLoginActivity.class);
        clearAllIntent(intent);
        startActivity(intent);
        finish();
    }

    public void verifyUserDetails(View view) {
        if(edt_name.getText().toString().isEmpty()){
            showBottomToast(this, "Enter username");
            edt_name.requestFocus();
        }else if(edt_email.getText().toString().isEmpty() || !isValidEmail(edt_email.getText().toString())){
            showBottomToast(this, "Enter valid email-id");
            edt_email.requestFocus();
        }else if(edt_dob.getText().toString().isEmpty()){
            showBottomToast(this,"Select your DOB");
        }else if(!rb_female.isChecked() && !rb_male.isChecked()){
            showBottomToast(this,"Select your Gender");
        }else if(edt_pass.getText().toString().isEmpty()){
            showBottomToast(this, "Enter your password");
        }else if(!edt_pass.getText().toString().equals(edt_conPass.getText().toString())){
            showBottomToast(this, "Password and Confirm Password should be same");
        }else {
            showBottomToast(this, "You have registered successfully");
            setUserLoggedOut(this, false);
            setUserName(this, edt_name.getText().toString());
            setUserEmail(this, edt_email.getText().toString());
            if(rb_male.isChecked()){
                setUserGender(this,"Male");
            }else if(rb_female.isChecked()){
                setUserGender(this,"Female");
            }
            Intent intent = new Intent(this, MainActivity.class);
            clearAllIntent(intent);
            startActivity(intent);
            finish();
        }
    }

    public void setDOB(View view) {
        final DatePickerDialog da1 = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthofyear, int dayofmonth) {
                String selectedDay = String.valueOf(dayofmonth);
                String selectedMonth = String.valueOf(monthofyear + 1);
                if(selectedDay.length() == 1){
                    selectedDay = "0"+selectedDay;
                }
                if(selectedMonth.length() == 1){
                    selectedMonth = "0"+selectedMonth;
                }
                edt_dob.setText(selectedDay+"-"+selectedMonth+"-"+year);
            }
        }, 1990, 01, 01);
        da1.show();
    }
}
