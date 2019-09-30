package com.pearl.salon.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.pearl.salon.R;
import com.pearl.salon.clickListner.TopCategoriesClickListner;

import java.util.ArrayList;

public class MainTopCategoriesAdapter extends RecyclerView.Adapter<MainTopCategoriesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> colorList;
    private TopCategoriesClickListner clickListner;

    public MainTopCategoriesAdapter(Context context, ArrayList<String> colorList, TopCategoriesClickListner clickListner) {
        this.context = context;
        this.colorList = colorList;
        this.clickListner = clickListner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_top_categories, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        String color = colorList.get(position);
        holder.card_top_categories.setCardBackgroundColor(Color.parseColor(color));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListner.onClick(holder.title.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return colorList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView card_top_categories;
        private TextView title, place;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card_top_categories = itemView.findViewById(R.id.card_top_categories);
            title = itemView.findViewById(R.id.tv_top_catogires_title);
            place = itemView.findViewById(R.id.tv_top_catogires_places);
        }
    }
}
