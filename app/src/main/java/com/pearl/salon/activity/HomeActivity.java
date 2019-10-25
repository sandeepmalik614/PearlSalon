package com.pearl.salon.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.facebook.login.LoginManager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.pearl.salon.R;
import com.pearl.salon.fragment.AppointmentFragment;
import com.pearl.salon.fragment.HomeFragment;
import com.pearl.salon.fragment.InboxFragment;
import com.pearl.salon.fragment.NearbyFragment;
import com.pearl.salon.fragment.ProfileFragment;
import com.pearl.salon.utils.AppPrefference;
import com.pearl.salon.utils.AppUtils;
import com.pearl.salon.utils.CircleImageView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "HomeActivity";

    private boolean doublePressedExit = false;
    private BottomNavigationView bottomNavView;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private CircleImageView userImage;
    private TextView tv_username, tv_email;
    final Fragment fragment1 = new HomeFragment();
    final Fragment fragment2 = new NearbyFragment();
    final Fragment fragment3 = new InboxFragment();
    final Fragment fragment4 = new AppointmentFragment();
    final Fragment fragment5 = new ProfileFragment();
    private FragmentTransaction fragmentTransaction;
    private Toolbar toolbar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    switchFragment(fragment1);
                    toolbar.setTitle("Home ");
                    return true;
                case R.id.nav_nearby:
                    switchFragment(fragment2);
                    toolbar.setTitle("Nearby ");
                    return true;
                case R.id.nav_inbox:
                    switchFragment(fragment3);
                    toolbar.setTitle("Inbox ");
                    return true;
                case R.id.nav_appointment:
                    switchFragment(fragment4);
                    toolbar.setTitle("Appointment ");
                    return true;
                case R.id.nav_profile:
                    switchFragment(fragment5);
                    toolbar.setTitle("Profile ");
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        bottomNavView = findViewById(R.id.bottom_nav_view);
        bottomNavView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        switchFragment(fragment1);
        setSideDetails();
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_logout) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Logout");
            builder.setMessage("Are you sure, you want to logout?");
            builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    LoginManager.getInstance().logOut();
                    AppPrefference.clearAllPreferences(HomeActivity.this);
                    AppPrefference.setIntroComplete(HomeActivity.this, true);
                    Intent intent = new Intent(HomeActivity.this, SocialLoginActivity.class);
                    AppUtils.clearAllIntent(intent);
                    startActivity(intent);
                    finish();
                }
            });
            builder.show();
        }
        return true;
    }

    private void switchFragment(Fragment fragment) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }

    private void setSideDetails(){
        userImage = findViewById(R.id.imageView34);
        tv_username = findViewById(R.id.textView97);
        tv_email = findViewById(R.id.textView98);

        Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQthOsl8408U1hItQ2a2souAu_kZY05Ss8h8xvRSjvCOPXuRN4C&s").into(userImage);
        tv_username.setText(AppPrefference.getUserName(this));
        tv_email.setText("1234567890");
    }

    @Override
    protected void onResume() {
        if (!AppUtils.isConnectionAvailable(this)) {
            AppUtils.showBottomToast(this, "No internet connection, Please check your internet connection");
        }

        if (getIntent().getBooleanExtra("goToAppointment", false)) {
            switchFragment(fragment4);
            toolbar.setTitle("Appointment ");
            bottomNavView.setSelectedItemId(R.id.nav_appointment);
        }

        super.onResume();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (doublePressedExit) {
                super.onBackPressed();
            } else {
                AppUtils.showBottomToast(this, "Please click BACK again to exit");
                doublePressedExit = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        doublePressedExit = false;
                    }
                }, 2000);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_notification:
                Toast.makeText(this, "Notification Clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
