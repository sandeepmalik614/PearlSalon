package com.pearl.salon.fragment.salonDetailsFragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pearl.salon.R;
import com.pearl.salon.adapter.salonDetail.ServiceReviewAdapter;
import com.pearl.salon.model.review.ReviewList;
import com.pearl.salon.utils.AppUtils;

import org.w3c.dom.Comment;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SalonReviewFragment extends Fragment {

    private View mainView;
    private TextView tv_detailReviewCount;
    private RecyclerView rv_comment;
    private ArrayList<ReviewList> reviewList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_salon_review, container, false);

        tv_detailReviewCount = mainView.findViewById(R.id.tv_detailReviewCount);
        rv_comment = mainView.findViewById(R.id.rv_detailReview);

        rv_comment.setLayoutManager(new LinearLayoutManager(getActivity()));

        reviewList = new ArrayList<>();
        ArrayList<String> colorList = new ArrayList<>();

        ReviewList review = new ReviewList("Sandeep Malik", "https://dixmfnt6b5ogu.cloudfront.net/user/pages/02.home-9a/05._testimonials-2/jonas-eilsoe-profil-kvadrat.jpg?g-5d85d749"
                                                , "1 hour ago", "A prosecutor may not remark to the jury that a defendant's failure to testify implies guilt, and a judge may not remark to the jury his or her opinion about what the evidence does or does not prove."
                                                , 3);
        reviewList.add(review);
        reviewList.add(review);
        reviewList.add(review);
        reviewList.add(review);
        reviewList.add(review);
        reviewList.add(review);
        reviewList.add(review);
        reviewList.add(review);
        reviewList.add(review);
        reviewList.add(review);
        reviewList.add(review);
        reviewList.add(review);
        reviewList.add(review);
        reviewList.add(review);
        reviewList.add(review);
        reviewList.add(review);

        tv_detailReviewCount.setText("All Reviews ("+reviewList.size()+")");

        rv_comment.setAdapter(new ServiceReviewAdapter(getActivity(), reviewList));

        return mainView;
    }

}
