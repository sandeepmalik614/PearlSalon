package com.pearl.salon.utils;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pearl.salon.R;
import com.pearl.salon.activity.OtpVerificationActivity;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class AppUtils {

    public static boolean isConnectionAvailable(Context ctx) {
        ConnectivityManager mManager = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mNetworkInfo = mManager.getActiveNetworkInfo();
        return (mNetworkInfo != null) && (mNetworkInfo.isConnected());
    }

    public static void setBarTransparent(Activity activity){
         activity.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    public static void hideKeyboard(Activity activity) {
        View view = activity.findViewById(android.R.id.content);
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void showKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    public static void openNumberKeyboard(EditText editText, Activity activity){
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput((editText), InputMethodManager.SHOW_IMPLICIT);
    }

    public static boolean isValidEmail(String email){
        if(email.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")){
            return true;
        }else {
            return false;
        }
    }

    public static void showTopToast(Activity activity, String message){
        Toast toast = Toast.makeText(activity, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

    public static void showCentreToast(Activity activity, String message){
        Toast toast = Toast.makeText(activity, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

    public static void showBottomToast(Activity activity, String message){
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    public static void clearAllIntent(Intent intent){
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|
                Intent.FLAG_ACTIVITY_CLEAR_TASK |
                Intent.FLAG_ACTIVITY_NEW_TASK);
    }

    public static void openCodeSentDialog(final Activity activity, final String screen) {
        final Dialog dialog = new Dialog(activity);
        dialog.setCanceledOnTouchOutside(false);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_code_sent);

        Button btn_done = dialog.findViewById(R.id.btn_dialogDone);
        TextView tv_heading = dialog.findViewById(R.id.textView18);
        TextView tv_small = dialog.findViewById(R.id.textView19);

        if(screen.equalsIgnoreCase("MobileVerify")){
            tv_heading.setText(R.string.mobile_verify_popup_text1);
            tv_small.setText(R.string.mobile_verify_popup_text2);
        }else {
            tv_heading.setText(R.string.forgot_password_popup_text1);
            tv_small.setText(R.string.forgot_password_popup_text2);
        }

        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Intent intent = new Intent(activity, OtpVerificationActivity.class);
                intent.putExtra("screenName", screen);
                activity.startActivity(intent);
            }
        });

        dialog.show();
    }

    public static String generateDarkRenadomNumber() {
        Random r = new Random();
        int red = r.nextInt(150 - 0 + 1) + 1;
        int green = r.nextInt(150 - 0 + 1) + 1;
        int blue = r.nextInt(150 - 0 + 1) + 1;

        GradientDrawable draw = new GradientDrawable();
        draw.setShape(GradientDrawable.OVAL);
        draw.setColor(Color.rgb(red, green, blue));
        String color = String.format("#%02x%02x%02x", red, green, blue);
        color = color.replace("android.graphics.drawable.GradientDrawable@", "");
        return color;
    }
}
