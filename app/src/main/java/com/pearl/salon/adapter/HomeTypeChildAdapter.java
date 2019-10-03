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

import com.pearl.salon.R;
import com.pearl.salon.clickListner.HomeClickListner;
import com.pearl.salon.model.SalonData;

import java.util.ArrayList;

public class HomeTypeChildAdapter extends RecyclerView.Adapter<HomeTypeChildAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> colorList;
    private ArrayList<SalonData> salonData;
    private HomeClickListner homeClickListner;
    private static final int VIEW_TYPE_SALON = 0;
    private static final int VIEW_TYPE_ADD = 1;

    public HomeTypeChildAdapter(Context context, ArrayList<String> colorList, ArrayList<SalonData> salonData, HomeClickListner homeClickListner) {
        this.context = context;
        this.colorList = colorList;
        this.salonData = salonData;
        this.homeClickListner = homeClickListner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_SALON) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_home_best_salon, parent, false);
            return new ViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_main_add, parent, false);
            return new ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.salonImage.setBackgroundColor(Color.parseColor(colorList.get(position)));
        holder.title.setText(salonData.get(position).getTitle());
        holder.add.setText(salonData.get(position).getAddress());
        holder.star.setText(salonData.get(position).getRating());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(salonData.get(position).isAdd()){
                    homeClickListner.childClick("This is add");
                }else{
                    homeClickListner.childClick(salonData.get(position).getTitle());
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

            salonImage = itemView.findViewById(R.id.imageView12);
            title = itemView.findViewById(R.id.textView23);
            star = itemView.findViewById(R.id.textView22);
            add = itemView.findViewById(R.id.textView24);
            book = itemView.findViewById(R.id.button9);
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
