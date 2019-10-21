package com.pearl.salon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pearl.salon.R;
import com.pearl.salon.model.book.BookHeadingList;

import java.util.ArrayList;

public class BookServiceAdapter extends RecyclerView.Adapter<BookServiceAdapter.ViewHolder> {

    private Context context;
    private ArrayList<BookHeadingList> dataList;

    public BookServiceAdapter(Context context, ArrayList<BookHeadingList> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_book_service, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.heading.setText(dataList.get(position).getHeading());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private Spinner spinner;
        private TextView heading;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            spinner = itemView.findViewById(R.id.spinner);
            heading = itemView.findViewById(R.id.textView61);
        }
    }
}
