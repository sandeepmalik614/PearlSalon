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
        mPrefsEditor.commit();
    }

    public static boolean isIntroComplete(Context ctx) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return mPrefs.getBoolean("intro", false);
    }

    public static void setIntroComplete(Context ctx, Boolean value) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        mPrefsEditor = mPrefs.edit();
        mPrefsEditor.putBoolean("intro", value);
        mPrefsEditor.commit();
    }

    public static void clearAllPreferences(Context ctx) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        mPrefsEditor = mPrefs.edit();
        mPrefsEditor.clear();
        mPrefsEditor.commit();
    }

}
