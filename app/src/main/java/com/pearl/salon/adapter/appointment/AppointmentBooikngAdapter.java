package com.pearl.salon.adapter.appointment;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pearl.salon.R;
import com.pearl.salon.utils.AppUtils;

public class AppointmentBooikngAdapter extends RecyclerView.Adapter<AppointmentBooikngAdapter.ViewHolder> {

    private Context context;

    public AppointmentBooikngAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_booking_all, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.banner.setBackgroundColor(Color.parseColor(AppUtils.generateLightRenadomNumber()));

        Glide.with(context).load(AppUtils.generateRandomNumber()).into(holder.banner);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView banner;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            banner = itemView.findViewById(R.id.imageView33);
        }
    }
}
