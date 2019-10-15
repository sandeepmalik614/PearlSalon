package com.pearl.salon.fragment.salonDetailsFragments;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.pearl.salon.R;
import com.pearl.salon.activity.GalleryViewActivity;
import com.pearl.salon.adapter.MainTopCategoriesAdapter;
import com.pearl.salon.clickListner.TopCategoriesClickListner;

import java.util.ArrayList;

import static com.pearl.salon.utils.AppUtils.generateDarkRenadomNumber;
import static com.pearl.salon.utils.AppUtils.generateLightRenadomNumber;

/**
 * A simple {@link Fragment} subclass.
 */
public class SalonAboutFragment extends Fragment {

    private View mainView;
    private ImageView img_photoOne, img_photoTwo, img_photoThree, img_photoFour;
    private ArrayList<String> imageList;

    private TopCategoriesClickListner topCategoriesClickListner = new TopCategoriesClickListner() {
        @Override
        public void onClick(String categoryName) {
            Toast.makeText(getActivity(), "" + categoryName, Toast.LENGTH_SHORT).show();
        }
    };
    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_salon_about, container, false);

        img_photoOne = mainView.findViewById(R.id.img_aboutPhotoOne);
        img_photoTwo = mainView.findViewById(R.id.img_aboutPhotoTwo);
        img_photoThree = mainView.findViewById(R.id.img_aboutPhotoThree);
        img_photoFour = mainView.findViewById(R.id.img_aboutPhotoFour);

        img_photoOne.setBackgroundColor(Color.parseColor(generateLightRenadomNumber()));
        img_photoTwo.setBackgroundColor(Color.parseColor(generateLightRenadomNumber()));
        img_photoThree.setBackgroundColor(Color.parseColor(generateLightRenadomNumber()));
        img_photoFour.setBackgroundColor(Color.parseColor(generateLightRenadomNumber()));

        imageList = new ArrayList<>();

        imageList.add("https://content2.jdmagicbox.com/comp/nagpur/h1/0712px712.x712.180820103619.k5h1/catalogue/beau-salon-hair-spa-clinic--nagpur-1hfoonmufe.jpg");
        imageList.add("https://luxurylifestyleawards.com/wp/wp-content/uploads/2018/10/beauty20salon-1.png");
        imageList.add("https://snailz.s3.amazonaws.com/5b7199b3e0812.jpg");
        imageList.add("https://s17026.pcdn.co/wp-content/uploads/sites/9/2016/06/1-229.jpg");

        Glide.with(this).load(imageList.get(0)).into(img_photoOne);
        Glide.with(this).load(imageList.get(1)).into(img_photoTwo);
        Glide.with(this).load(imageList.get(2)).into(img_photoThree);
        Glide.with(this).load(imageList.get(3)).into(img_photoFour);

        img_photoOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GalleryViewActivity.class);
                intent.putStringArrayListExtra("list", imageList);
                intent.putExtra("position", 0);
                ActivityOptions options = ActivityOptions.
                        makeSceneTransitionAnimation(getActivity(), Pair.<View, String>create(img_photoOne, "sliderImage"));
                startActivity(intent, options.toBundle());
            }
        });

        img_photoTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GalleryViewActivity.class);
                intent.putStringArrayListExtra("list", imageList);
                intent.putExtra("position", 1);
                ActivityOptions options = ActivityOptions.
                        makeSceneTransitionAnimation(getActivity(), Pair.<View, String>create(img_photoTwo, "sliderImage"));
                startActivity(intent, options.toBundle());
            }
        });

        img_photoThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GalleryViewActivity.class);
                intent.putStringArrayListExtra("list", imageList);
                intent.putExtra("position", 2);
                ActivityOptions options = ActivityOptions.
                        makeSceneTransitionAnimation(getActivity(), Pair.<View, String>create(img_photoThree, "sliderImage"));
                startActivity(intent, options.toBundle());
            }
        });

        img_photoFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GalleryViewActivity.class);
                intent.putStringArrayListExtra("list", imageList);
                intent.putExtra("position", 3);
                ActivityOptions options = ActivityOptions.
                        makeSceneTransitionAnimation(getActivity(), Pair.<View, String>create(img_photoFour, "sliderImage"));
                startActivity(intent, options.toBundle());
            }
        });

        return mainView;
    }
}
