package com.pearl.salon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pearl.salon.R;

import java.util.ArrayList;

public class PackageAndOfferServiceAdapter extends RecyclerView.Adapter<PackageAndOfferServiceAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> serviceList;

    public PackageAndOfferServiceAdapter(Context context, ArrayList<String> serviceList) {
        this.context = context;
        this.serviceList = serviceList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_package_offer_service, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_service.setText(serviceList.get(position));
    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_service;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_service = itemView.findViewById(R.id.tv_package_offer_service);
        }
    }
}
