package com.pearl.salon.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.pearl.salon.R;

import java.util.ArrayList;

public class MainTopCategoriesAdapter extends RecyclerView.Adapter<MainTopCategoriesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> colorList;

    public MainTopCategoriesAdapter(Context context, ArrayList<String> colorList) {
        this.context = context;
        this.colorList = colorList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_top_categories, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String color = colorList.get(position);
        holder.card_top_categories.setCardBackgroundColor(Color.parseColor(color));
    }

    @Override
    public int getItemCount() {
        return colorList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView card_top_categories;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card_top_categories = itemView.findViewById(R.id.card_top_categories);
        }
    }
}
