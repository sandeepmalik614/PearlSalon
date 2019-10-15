package com.pearl.salon.adapter.salonDetail;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pearl.salon.R;
import com.pearl.salon.model.review.ReviewList;
import com.pearl.salon.utils.CircleImageView;

import java.util.ArrayList;

public class ServiceReviewAdapter extends RecyclerView.Adapter<ServiceReviewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ReviewList> reviewLists;

    public ServiceReviewAdapter(Context context, ArrayList<ReviewList> reviewLists) {
        this.context = context;
        this.reviewLists = reviewLists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_review, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(reviewLists.get(position).getImage()).into(holder.userImage);
        holder.userName.setText(reviewLists.get(position).getUsername());
        holder.time.setText(reviewLists.get(position).getTime());
        holder.comment.setText(reviewLists.get(position).getComment());
        holder.ratingBar.setRating(reviewLists.get(position).getStar());
    }

    @Override
    public int getItemCount() {
        return reviewLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView userImage;
        private TextView userName, comment, time;
        private RatingBar ratingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userImage = itemView.findViewById(R.id.imageView19);
            userName = itemView.findViewById(R.id.textView54);
            time = itemView.findViewById(R.id.textView55);
            comment = itemView.findViewById(R.id.textView56);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }
    }
}
