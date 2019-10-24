package com.pearl.salon.utils;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.pearl.salon.R;
import com.pearl.salon.activity.OtpVerificationActivity;

import java.net.URLEncoder;
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
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

    public static String generateLightRenadomNumber() {
        Random r = new Random();
        int red = r.nextInt(253 - 100 + 1) + 100;
        int green = r.nextInt(200 - 150 + 1) + 150;
        int blue = r.nextInt(200 - 150 + 1) + 150;

        GradientDrawable draw = new GradientDrawable();
        draw.setShape(GradientDrawable.OVAL);
        draw.setColor(Color.rgb(red, green, blue));
        String color = String.format("#%02x%02x%02x", red, green, blue);
        color = color.replace("android.graphics.drawable.GradientDrawable@", "");
        return color;
    }

    public static void getNewFirebaseToken(final Context context) {
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (task.isSuccessful()) {
                            AppPrefference.setFirebaseToken(context, task.getResult().getToken());
                        } else {
                            getNewFirebaseToken(context);
                        }
                    }
                });
    }
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(
                Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

    public static String checkUnsavedNumberOnWhatsapp(Context context, String mobile) {
        String send = "";
        if(isConnectionAvailable(context)){
            String upToNCharacters = mobile.substring(0, Math.min(mobile.length(), 1));
            if (upToNCharacters.equals("9") || upToNCharacters.equals("8") ||
                    upToNCharacters.equals("7") || upToNCharacters.equals("6")){
                PackageManager packageManager = context.getPackageManager();
                Intent i = new Intent(Intent.ACTION_VIEW);

                try {
                    String url = "https://api.whatsapp.com/send?phone=" +
                            "+91 " + mobile + "&text=" + URLEncoder.encode("", "UTF-8");
                    i.setPackage("com.whatsapp");
                    i.setData(Uri.parse(url));
                    if (i.resolveActivity(packageManager) != null) {
                        context.startActivity(i);
                        send = "done";
                    }
                } catch (Exception e) {
                    send = "exception";
                    Toast.makeText(context, "Oops! something went wrong", Toast.LENGTH_SHORT).show();
                }
            }else{
                send = "not valid";
                Toast.makeText(context, "Please enter a valid mobile number", Toast.LENGTH_SHORT).show();
            }
        }else{
            send = "internet";
            Toast.makeText(context, "Please check your internet connection", Toast.LENGTH_SHORT).show();
        }
        return send;
    }

    public static void share(Activity activity, String message){
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
        activity.startActivity(Intent.createChooser(sharingIntent, "Share Using"));
    }

    public static String generateRandomNumber() {
        Random r = new Random();
        int i = r.nextInt(20 - 1) + 1;
        String image = "";
        switch (i) {
            case 1:
                image = "https://img4.nbstatic.in/tr:w-500/5cc941465f1503000d3ab644.png";
                break;
            case 2:
                image = "https://www.hughcampbellhairgroup.com/files/2017/03/MARSALONPM.jpg";
                break;
            case 3:
                image = "https://images.unsplash.com/photo-1521590832167-7bcbfaa6381f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80";
                break;
            case 4:
                image = "https://lh3.googleusercontent.com/1I0GR6VnT28qSfTiaFxeKe_JGNVsNcm_qdIXwLkSf-lNSVUPqFRU5ngebDxrkeQ5h8ufbOI=w1080-h608-p-no-v0";
                break;
            case 5:
                image = "https://images.jdmagicbox.com/comp/delhi/s6/011pxx11.xx11.180309151252.p4s6/catalogue/d-and-a-the-unisex-salon-rohini-delhi-beauty-parlours-for-makeup-6vkqykyndg.jpg";
                break;
            case 6:
                image = "https://du0xldifh78n8.cloudfront.net/c/m.icapellisalon.com/a355920/5496b20d28ae215a801514bc43591c7e/2/1920";
                break;
            case 7:
                image = "https://www.salonpricelady.com/wp-content/uploads/2016/02/hair-salon-inside.jpg";
                break;
            case 8:
                image = "https://images.jdmagicbox.com/comp/delhi/s6/011pxx11.xx11.180309151252.p4s6/catalogue/d-and-a-the-unisex-salon-rohini-delhi-beauty-parlours-for-makeup-6vkqykyndg.jpg";
                break;
            case 9:
                image = "https://www.salonpricelady.com/wp-content/uploads/2016/02/hair-salon-inside.jpg";
                break;
            case 10:
                image = "https://images.unsplash.com/photo-1521590832167-7bcbfaa6381f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80";
                break;
            case 11:
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS25SCC4tst_KTWXEETf2ZIJ7Gp_NE_JVIeL7dfXMZyrPKe2xRU";
                break;
            case 12:
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJ-N35EcvQuayhKqEFppgS2ltBCJHrKKAhiilLwTfAHhBIrghp";
                break;
            case 13:
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCoAwJdTHaYcrTB18i9QByQ13AIHteQDjqDuxIcWI4NtOzSn-Hbg";
                break;
            case 14:
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXnsCqxjKqYQV-sIJfyH7yIGi4geC1g7aZ40lTXyiho4D8vugQkA";
                break;
            case 15:
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRtlQefVeISRBVJvLkUcWF9-02M5ZW-bq4KrCOQHHdjzcU76strMw";
                break;
            case 16:
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9Wl3PhwRSZWi5vUyWrAqf0SOoWNKormLv_cJfcyHI6sbpjq7pKw";
                break;
            case 17:
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSQhF_LPPyePDlh8CVcKw59JA439INJCsO0KTmoVq4O0JFVdXfdfw";
                break;
            case 18:
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQMwRg_sB9uiZw5O9ACwDNdrAZ9rN_DPs3wSYyim3VB-H-OwRi0";
                break;
            case 19:
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-S9XB0THJiPyce6n-BkUzJ74ee5NXKsNf3pzEpBUxfFck9_CH";
                break;
            case 20:
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQXoY1MWzq55e8zqLJE8T2E0vK_mrUTSGvqoQ_UD9f7Pbq16QZs";
                break;
        }
        return image;
    }

}
