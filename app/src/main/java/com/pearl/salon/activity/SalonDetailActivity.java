package com.pearl.salon.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pearl.salon.R;

public class SalonDetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView salonImage;
    private TextView tv_salonName, tv_salonAdd, tv_salonStatus, tv_reviewCount;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_detail);

        salonImage = findViewById(R.id.imageView16);
        tv_salonName = findViewById(R.id.textView31);
        tv_salonAdd = findViewById(R.id.textView30);
        tv_salonStatus = findViewById(R.id.textView28);
        tv_reviewCount = findViewById(R.id.textView29);
        ratingBar = findViewById(R.id.ratingBarDetailPage);
        toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        tv_salonName.setText("Main Street Salon");
        tv_salonAdd.setText("Raquel, Christine & Mamie 3821 Main Street Culver City, CA 90232");
        Glide.with(this).load("https://images.squarespace-cdn.com/content/v1/587ed62137c581c9c42fee61/1487379670546-RK2BWY5T8KNSURFC59C8/ke17ZwdGBToddI8pDm48kLkXF2pIyv_F2eUT9F60jBl7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0iyqMbMesKd95J-X4EagrgU9L3Sa3U8cogeb0tjXbfawd0urKshkc5MgdBeJmALQKw/mainstreetsalon-14.jpg?format=2500w")
                .into(salonImage);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
