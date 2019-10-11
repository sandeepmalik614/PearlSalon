package com.pearl.salon.fragment.salonDetailsFragments;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.pearl.salon.R;
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

    private TopCategoriesClickListner topCategoriesClickListner = new TopCategoriesClickListner() {
        @Override
        public void onClick(String categoryName) {
            Toast.makeText(getActivity(), "" + categoryName, Toast.LENGTH_SHORT).show();
        }
    };

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

        return mainView;
    }
}
