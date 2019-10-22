package com.pearl.salon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pearl.salon.R;
import com.pearl.salon.model.book.BookSpecialistList;
import com.pearl.salon.utils.CircleImageView;

import java.util.ArrayList;

public class BookSpecialistAdapter extends RecyclerView.Adapter<BookSpecialistAdapter.ViewHolder> {

    private Context context;
    private ArrayList<BookSpecialistList> userList;

    public BookSpecialistAdapter(Context context, ArrayList<BookSpecialistList> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_book_specialist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final BookSpecialistList data = userList.get(position);

        Glide.with(context).load(data.getImage()).into(holder.userImage);
        holder.tv_name.setText(data.getName());

        if (data.isSelected()) {
            holder.v_selection.setVisibility(View.VISIBLE);
        } else {
            holder.v_selection.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!data.isSelected()) {
                    for (int i = 0; i < userList.size(); i++) {
                        userList.get(i).setSelected(false);
                    }
                    userList.get(position).setSelected(true);
                }else{
                    for (int i = 0; i < userList.size(); i++) {
                        userList.get(i).setSelected(false);
                    }
                }
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View v_selection;
        private CircleImageView userImage;
        private TextView tv_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            v_selection = itemView.findViewById(R.id.view8);
            userImage = itemView.findViewById(R.id.circleImageView1);
            tv_name = itemView.findViewById(R.id.textView68);
        }
    }
}
