package com.pearl.salon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pearl.salon.R;
import com.pearl.salon.clickListner.HomeClickListner;
import com.pearl.salon.model.MainList;
import com.pearl.salon.model.SalonData;

import java.util.ArrayList;

public class HomeTypesAdapter extends RecyclerView.Adapter<HomeTypesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> colorList;
    private ArrayList<MainList> salonData;
    private ArrayList<String> headingList;
    private HomeClickListner homeClickListner;

    public HomeTypesAdapter(Context context, ArrayList<String> colorList, ArrayList<MainList> salonData,
                            ArrayList<String> headingList, HomeClickListner homeClickListner) {
        this.context = context;
        this.colorList = colorList;
        this.salonData = salonData;
        this.headingList = headingList;
        this.homeClickListner = homeClickListner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_salon_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tv_bestSalonTitle.setText(headingList.get(position));
        holder.rv_home_Salon.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        holder.rv_home_Salon.setAdapter(new HomeTypeChildAdapter(context, colorList, salonData.get(position).getSalonData(), homeClickListner));

        if(headingList.get(position).equalsIgnoreCase("Hot Deals")){
            holder.tv_bestDalonSeeAll.setVisibility(View.GONE);
        }else{
            holder.tv_bestDalonSeeAll.setVisibility(View.VISIBLE);
        }

        holder.tv_bestDalonSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeClickListner.mainClick(headingList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return headingList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView rv_home_Salon;
        private TextView tv_bestSalonTitle, tv_bestDalonSeeAll;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rv_home_Salon = itemView.findViewById(R.id.rv_home_Salon);
            tv_bestSalonTitle = itemView.findViewById(R.id.tv_bestSalonTitle);
            tv_bestDalonSeeAll = itemView.findViewById(R.id.tv_bestDalonSeeAll);
        }
    }
}
