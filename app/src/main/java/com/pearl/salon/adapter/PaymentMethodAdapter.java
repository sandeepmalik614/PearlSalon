package com.pearl.salon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pearl.salon.R;
import com.pearl.salon.clickListner.PamentMethodClickListner;
import com.pearl.salon.model.book.PaymentMethodList;

import java.util.ArrayList;

public class PaymentMethodAdapter extends RecyclerView.Adapter<PaymentMethodAdapter.ViewHolder> {

    private Context context;
    private ArrayList<PaymentMethodList> methodList;
    private PamentMethodClickListner clickListner;

    public PaymentMethodAdapter(Context context, ArrayList<PaymentMethodList> methodList, PamentMethodClickListner clickListner) {
        this.context = context;
        this.methodList = methodList;
        this.clickListner = clickListner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_payment_method, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Glide.with(context).load(methodList.get(position).getDrawable()).into(holder.banner);
        holder.tv_name.setText(methodList.get(position).getName());
        holder.tv_end.setText(methodList.get(position).getEndWith());

        if(methodList.get(position).isSelected()){
            holder.rb.setChecked(true);
            holder.v_border.setVisibility(View.VISIBLE);
            if(clickListner != null){
                clickListner.onSelect(methodList.get(position).getName());
            }
        }else{
            holder.rb.setChecked(false);
            holder.v_border.setVisibility(View.INVISIBLE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!methodList.get(position).isSelected()){
                    for (int i = 0; i < methodList.size(); i++) {
                        methodList.get(i).setSelected(false);
                    }
                    methodList.get(position).setSelected(true);
                    if(clickListner != null){
                        clickListner.onSelect(methodList.get(position).getName());
                    }
                    notifyDataSetChanged();
                }
            }
        });

        holder.rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!methodList.get(position).isSelected()){
                    for (int i = 0; i < methodList.size(); i++) {
                        methodList.get(i).setSelected(false);
                    }
                    methodList.get(position).setSelected(true);
                    if(clickListner != null){
                        clickListner.onSelect(methodList.get(position).getName());
                    }
                    notifyDataSetChanged();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return methodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView banner;
        private TextView tv_name, tv_end;
        private RadioButton rb;
        private View v_border;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            banner = itemView.findViewById(R.id.imageView25);
            tv_name = itemView.findViewById(R.id.textView78);
            rb = itemView.findViewById(R.id.radioButton);
            tv_end = itemView.findViewById(R.id.textView79);
            v_border = itemView.findViewById(R.id.view9);
        }
    }
}
