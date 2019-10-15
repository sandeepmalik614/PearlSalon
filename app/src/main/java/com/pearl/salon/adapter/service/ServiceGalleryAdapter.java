package com.pearl.salon.adapter.service;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.provider.ContactsContract;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pearl.salon.R;
import com.pearl.salon.activity.GalleryViewActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ServiceGalleryAdapter extends RecyclerView.Adapter<ServiceGalleryAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> imageList;
    private ArrayList<String> colorList;

    public ServiceGalleryAdapter(Context context, ArrayList<String> imageList, ArrayList<String> colorList) {
        this.context = context;
        this.imageList = imageList;
        this.colorList = colorList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gallery, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.imageView.setBackgroundColor(Color.parseColor(colorList.get(position)));
        Glide.with(context).load(imageList.get(position)).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, GalleryViewActivity.class);
                intent.putStringArrayListExtra("list", imageList);
                intent.putExtra("position", position);
                ActivityOptions options = ActivityOptions.
                        makeSceneTransitionAnimation((Activity) context, Pair.<View, String>create(holder.imageView, "sliderImage"));
                context.startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_galleryItem);
        }
    }
}
