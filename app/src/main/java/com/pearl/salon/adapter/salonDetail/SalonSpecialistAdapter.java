package com.pearl.salon.adapter.salonDetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pearl.salon.R;
import com.pearl.salon.utils.CircleImageView;

public class SalonSpecialistAdapter extends RecyclerView.Adapter<SalonSpecialistAdapter.ViewHolder> {

    private Context context;

    public SalonSpecialistAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_salon_specialists, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load("https://dixmfnt6b5ogu.cloudfront.net/user/pages/02.home-9a/05._testimonials-2/jonas-eilsoe-profil-kvadrat.jpg?g-5d85d749").into(holder.userImage);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView userImage;
        private TextView tv_username, tv_userpost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userImage = itemView.findViewById(R.id.circleImageView);
            tv_username = itemView.findViewById(R.id.textView32);
            tv_userpost = itemView.findViewById(R.id.textView34);
        }
    }
}
