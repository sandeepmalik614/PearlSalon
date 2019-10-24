package com.pearl.salon.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.pearl.salon.R;
import com.pearl.salon.adapter.PackageAndOfferServiceAdapter;

import java.util.ArrayList;

public class PackageAndOfferActivity extends AppCompatActivity {

    private RecyclerView rv_service;
    private ImageView banner, backImage;
    private Button btn_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_and_offer);

        rv_service = findViewById(R.id.rv_package_offer_service);
        banner = findViewById(R.id.imageView26);
        backImage = findViewById(R.id.imageView28);
        btn_book = findViewById(R.id.button14);

        Glide.with(this).load(getIntent().getStringExtra("serviceBanner")).into(banner);

        rv_service.setLayoutManager(new GridLayoutManager(this, 2));

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Hairstyling");
        arrayList.add("Hair Color");
        arrayList.add("Corner Lashes");
        arrayList.add("Nail");
        arrayList.add("Make up");
        arrayList.add("Retoch");
        arrayList.add("Body Glowing");
        arrayList.add("Facial");
        arrayList.add("Eyebrows");
        arrayList.add("Spa");

        rv_service.setAdapter(new PackageAndOfferServiceAdapter(this, arrayList));

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PackageAndOfferActivity.this, BookSecondActivity.class));
            }
        });

    }
}
