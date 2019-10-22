package com.pearl.salon.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pearl.salon.R;
import com.pearl.salon.clickListner.TimeSalotClickListner;
import com.pearl.salon.model.book.BookTimeSlotList;

import java.util.ArrayList;

public class BookTimeSalotAdapter extends RecyclerView.Adapter<BookTimeSalotAdapter.ViewHolder> {

    private Context context;
    private ArrayList<BookTimeSlotList> slotList;
    private TimeSalotClickListner clickListner;

    public BookTimeSalotAdapter(Context context, ArrayList<BookTimeSlotList> slotList, TimeSalotClickListner clickListner) {
        this.context = context;
        this.slotList = slotList;
        this.clickListner = clickListner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_book_salot, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.btn_salot.setText(slotList.get(position).getTime());

        if (slotList.get(position).isSelected()) {
            holder.btn_salot.setBackgroundResource(R.drawable.selected_time_salot);
            holder.btn_salot.setTextColor(Color.parseColor("#ffffff"));
            if(clickListner != null){
                clickListner.onTimeSelect(slotList.get(position).getTime());
            }
        } else {
            holder.btn_salot.setBackgroundResource(R.drawable.default_time_salot);
            holder.btn_salot.setTextColor(Color.parseColor("#787878"));
        }

        holder.btn_salot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!slotList.get(position).isSelected()) {
                    for (int i = 0; i < slotList.size(); i++) {
                        slotList.get(i).setSelected(false);
                    }

                    slotList.get(position).setSelected(true);
                    if(clickListner != null){
                        clickListner.onTimeSelect(slotList.get(position).getTime());
                    }
                }
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return slotList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView btn_salot;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            btn_salot = itemView.findViewById(R.id.btn_salot);
        }
    }
}
