package com.pearl.salon.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pearl.salon.R;
import com.pearl.salon.clickListner.HomeClickListner;
import com.pearl.salon.model.home.SalonData;

import java.util.ArrayList;

public class CategorySalonAdapter extends RecyclerView.Adapter<CategorySalonAdapter.ViewHolder> {


    private Context context;
    private ArrayList<String> colorList;
    private ArrayList<SalonData> salonData;
    private HomeClickListner homeClickListner;
    private static final int VIEW_TYPE_SALON = 0;
    private static final int VIEW_TYPE_ADD = 1;

    public CategorySalonAdapter(Context context, ArrayList<String> colorList, ArrayList<SalonData> salonData, HomeClickListner homeClickListner) {
        this.context = context;
        this.colorList = colorList;
        this.salonData = salonData;
        this.homeClickListner = homeClickListner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_SALON) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_category_salon, parent, false);
            return new ViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_category_salon_add, parent, false);
            return new ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.salonImage.setBackgroundColor(Color.parseColor(colorList.get(position)));
        Glide.with(context).load(salonData.get(position).getImage()).into(holder.salonImage);
        holder.title.setText(salonData.get(position).getTitle());
        holder.add.setText(salonData.get(position).getAddress());
        holder.star.setText(salonData.get(position).getRating());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(salonData.get(position).isAdd()){
                    homeClickListner.childClick("This is add", true);
                }else{
                    homeClickListner.childClick(salonData.get(position).getTitle(), false);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return salonData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView salonImage;
        private TextView title, star, add;
        private Button book;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            salonImage = itemView.findViewById(R.id.imageView31);
            title = itemView.findViewById(R.id.textView86);
            star = itemView.findViewById(R.id.textView87);
            add = itemView.findViewById(R.id.textView88);
            book = itemView.findViewById(R.id.button15);
        }
    }
    @Override
    public int getItemViewType(int position) {
        if (salonData.get(position).isAdd()) {
            return VIEW_TYPE_ADD;
        } else {
            return VIEW_TYPE_SALON;
        }
    }

}
