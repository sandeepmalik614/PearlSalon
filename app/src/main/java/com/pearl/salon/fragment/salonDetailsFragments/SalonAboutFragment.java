package com.pearl.salon.fragment.salonDetailsFragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pearl.salon.R;
import com.pearl.salon.adapter.MainTopCategoriesAdapter;
import com.pearl.salon.clickListner.TopCategoriesClickListner;

import java.util.ArrayList;

import static com.pearl.salon.utils.AppUtils.generateDarkRenadomNumber;

/**
 * A simple {@link Fragment} subclass.
 */
public class SalonAboutFragment extends Fragment {

    private RecyclerView rv_aboutPhotos;
    private View mainView;
    private ArrayList<String> darkColorList;

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

        rv_aboutPhotos = mainView.findViewById(R.id.rv_aboutPhotos);

        rv_aboutPhotos.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        setTopCategoryAdapter();

        return mainView;
    }

    private void setTopCategoryAdapter() {
        rv_aboutPhotos.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        darkColorList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            darkColorList.add(generateDarkRenadomNumber());
            if (i == 9) {
                rv_aboutPhotos.setAdapter(new MainTopCategoriesAdapter(getActivity(), darkColorList, topCategoriesClickListner));
                break;
            }
        }
    }

}
