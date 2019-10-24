package com.pearl.salon.adapter.salonDetail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pearl.salon.R;
import com.pearl.salon.activity.PackageAndOfferActivity;
import com.pearl.salon.clickListner.PackageAndOfferClickListner;
import com.pearl.salon.model.service.ServicePackageList;

import java.util.ArrayList;

public class ServicePackageAdapter extends RecyclerView.Adapter<ServicePackageAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ServicePackageList> packageLists;
    private ArrayList<String> colorList;
    private PackageAndOfferClickListner clickListner;

    public ServicePackageAdapter(Context context, ArrayList<ServicePackageList> packageLists, ArrayList<String> colorList, PackageAndOfferClickListner clickListner) {
        this.context = context;
        this.packageLists = packageLists;
        this.colorList = colorList;
        this.clickListner = clickListner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_service_package, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.bannerImage.setBackgroundColor(Color.parseColor(colorList.get(position)));
        Glide.with(context).load(packageLists.get(position).getOfferImage()).into(holder.bannerImage);
        holder.offerName.setText(packageLists.get(position).getOfferName());
        holder.offerDesc.setText(packageLists.get(position).getOfferDesc());
        holder.offerPrice.setText(packageLists.get(position).getOfferPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clickListner != null){
                    clickListner.onClick(packageLists.get(position).getOfferImage());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return packageLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView bannerImage;
        private TextView offerName, offerDesc, offerPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bannerImage = itemView.findViewById(R.id.imageView18);
            offerName = itemView.findViewById(R.id.textView48);
            offerDesc = itemView.findViewById(R.id.textView50);
            offerPrice = itemView.findViewById(R.id.textView49);
        }
    }
}
