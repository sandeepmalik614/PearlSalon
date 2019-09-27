package com.pearl.salon.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pearl.salon.R;
import com.pearl.salon.model.BestSalonData;

import java.util.ArrayList;

public class HomeBestSalonAdapter extends RecyclerView.Adapter<HomeBestSalonAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> colorList;
    private ArrayList<BestSalonData> salonData;

    public HomeBestSalonAdapter(Context context, ArrayList<String> colorList, ArrayList<BestSalonData> salonData) {
        this.context = context;
        this.colorList = colorList;
        this.salonData = salonData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_best_salon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.salonImage.setBackgroundColor(Color.parseColor(colorList.get(position)));
        holder.title.setText(salonData.get(position).getTitle());
        holder.star.setText(salonData.get(position).getRating());
        holder.add.setText(salonData.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return colorList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView salonImage;
        private TextView title, star, add;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            salonImage = itemView.findViewById(R.id.imageView12);
            title = itemView.findViewById(R.id.textView23);
            star = itemView.findViewById(R.id.textView22);
            add = itemView.findViewById(R.id.textView24);
        }
    }
}
