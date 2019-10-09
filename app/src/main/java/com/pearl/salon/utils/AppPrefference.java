package com.pearl.salon.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class AppPrefference {

    private static SharedPreferences mPrefs;
    private static SharedPreferences.Editor mPrefsEditor;

    public static boolean isUserLoggedOut(Context ctx) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return mPrefs.getBoolean("isLoggedIn", true);
    }

    public static void setUserLoggedOut(Context ctx, Boolean value) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        mPrefsEditor = mPrefs.edit();
        mPrefsEditor.putBoolean("isLoggedIn", value);
        mPrefsEditor.apply();
    }

    public static boolean isIntroComplete(Context ctx) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return mPrefs.getBoolean("intro", false);
    }

    public static void setIntroComplete(Context ctx, Boolean value) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        mPrefsEditor = mPrefs.edit();
        mPrefsEditor.putBoolean("intro", value);
        mPrefsEditor.apply();
    }

    public static void setUserId(Context ctx, String id){
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        mPrefsEditor = mPrefs.edit();
        mPrefsEditor.putString("userId", id);
        mPrefsEditor.apply();
    }

    public static String getUserId(Context ctx){
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return mPrefs.getString("userId", "");
    }

    public static void setUserMobileNumber(Context ctx, String mobile){
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        mPrefsEditor = mPrefs.edit();
        mPrefsEditor.putString("userMobile", mobile);
        mPrefsEditor.apply();
    }

    public static String getUserMobileNumber(Context ctx){
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return mPrefs.getString("userMobile", "");
    }

    public static void setUserEmail(Context ctx, String email){
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        mPrefsEditor = mPrefs.edit();
        mPrefsEditor.putString("userEmail", email);
        mPrefsEditor.apply();
    }

    public static String getUserEmail(Context ctx){
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return mPrefs.getString("userEmail", "");
    }

    public static void setUserName(Context ctx, String name){
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        mPrefsEditor = mPrefs.edit();
        mPrefsEditor.putString("userName", name);
        mPrefsEditor.apply();
    }

    public static String getUserName(Context ctx){
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return mPrefs.getString("userName", "");
    }

    public static void setUserGender(Context ctx, String gender){
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        mPrefsEditor = mPrefs.edit();
        mPrefsEditor.putString("userGender", gender);
        mPrefsEditor.apply();
    }

    public static String getUserGender(Context ctx){
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return mPrefs.getString("userGender", "");
    }

    public static String getFirebaseToken(Context ctx) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return mPrefs.getString("FirebaseToken", "");
    }

    public static void setFirebaseToken(Context ctx, String value) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        mPrefsEditor = mPrefs.edit();
        mPrefsEditor.putString("FirebaseToken", value);
        mPrefsEditor.commit();
    }

    public static void clearAllPreferences(Context ctx) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        mPrefsEditor = mPrefs.edit();
        mPrefsEditor.clear();
        mPrefsEditor.apply();
    }

}
