package com.pearl.salon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pearl.salon.R;
import com.pearl.salon.model.book.BookHeadingList;
import com.pearl.salon.model.book.BookServiceList;

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
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.tv_heading.setText(dataList.get(position).getHeading());
        holder.tv_spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPopup(holder.tv_spinner, dataList.get(position).getServiceList());
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_heading, tv_spinner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_spinner = itemView.findViewById(R.id.textView61);
            tv_heading = itemView.findViewById(R.id.textView62);
        }
    }

    private void openPopup(final TextView tv_spinner, ArrayList<BookServiceList> serviceList){
        final PopupMenu menu = new PopupMenu(context, tv_spinner);
        for (int i = 0; i < serviceList.size(); i++) {
            menu.getMenu().add(serviceList.get(i).getName());
        }
        menu.show();

        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                tv_spinner.setText(menuItem.getTitle());
                return false;
            }
        });
    }
}
