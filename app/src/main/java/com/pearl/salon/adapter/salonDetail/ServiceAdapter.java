package com.pearl.salon.adapter.salonDetail;

import android.content.Context;
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
import com.pearl.salon.model.service.ServiceList;

import java.util.ArrayList;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ServiceList> arrayList;
    private ArrayList<String> colorList;
    private boolean isPrice = false;

    public ServiceAdapter(Context context, ArrayList<ServiceList> arrayList, ArrayList<String> colorList, boolean isPrice) {
        this.context = context;
        this.arrayList = arrayList;
        this.colorList = colorList;
        this.isPrice = isPrice;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_service, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String color = colorList.get(position);
        holder.serviceImage.setBackgroundColor(Color.parseColor(color));
        Glide.with(context).load(arrayList.get(position).getImage()).into(holder.serviceImage);
        holder.serviceName.setText(arrayList.get(position).getServiceName());
        holder.serviceType.setText(arrayList.get(position).getServiceType());

        if(isPrice){
           holder.serviceView.setVisibility(View.GONE);
        }else{
            holder.serviceView.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView serviceImage;
        private TextView serviceName, serviceType, serviceView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            serviceImage = itemView.findViewById(R.id.img_service);
            serviceName = itemView.findViewById(R.id.textView45);
            serviceType = itemView.findViewById(R.id.textView46);
            serviceView = itemView.findViewById(R.id.textView44);
        }
    }
}
