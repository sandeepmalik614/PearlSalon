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
import com.pearl.salon.clickListner.BookServiceClickListner;
import com.pearl.salon.model.book.BookHeadingList;
import com.pearl.salon.model.book.BookServiceList;

import java.util.ArrayList;

public class BookServiceAdapter extends RecyclerView.Adapter<BookServiceAdapter.ViewHolder> {

    private Context context;
    private ArrayList<BookHeadingList> dataList;
    private BookServiceClickListner clickListner;

    public BookServiceAdapter(Context context, ArrayList<BookHeadingList> dataList, BookServiceClickListner clickListner) {
        this.context = context;
        this.dataList = dataList;
        this.clickListner = clickListner;
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
                openPopup(holder.tv_spinner, dataList.get(position).getServiceList(),
                        holder.tv_spinner.getText().toString(),
                        holder.tv_heading.getText().toString());
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

    private void openPopup(final TextView tv_spinner, final ArrayList<BookServiceList> serviceList, final String firstText, final String heading) {
        final PopupMenu menu = new PopupMenu(context, tv_spinner);
        for (int i = 0; i < serviceList.size(); i++) {
            menu.getMenu().add(serviceList.get(i).getName());
        }
        menu.show();

        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                String selectedItem = menuItem.getTitle().toString();
                tv_spinner.setText(selectedItem);

                int pos = 0;

                for (int i = 0; i < serviceList.size(); i++) {
                    if (selectedItem.equals(serviceList.get(i).getName())) {
                        pos = i;
                        break;
                    }
                }

                if (selectedItem.equals("Select service")) {
                    for (int i = 0; i < serviceList.size(); i++) {
                        if(firstText.equals(serviceList.get(i).getName())){
                            clickListner.onPriceDelete(heading, serviceList.get(i).getPrice());
                            break;
                        }
                    }
                } else if (firstText.equals("Select service")) {
                    clickListner.onPriceAdd(heading, serviceList.get(pos).getPrice());
                } else {
                    clickListner.onPriceChange(heading, serviceList.get(pos).getPrice());
                }

                return false;
            }
        });
    }
}
