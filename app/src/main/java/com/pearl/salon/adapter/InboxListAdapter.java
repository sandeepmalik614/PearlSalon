package com.pearl.salon.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pearl.salon.R;
import com.pearl.salon.model.inbox.InboxList;
import com.pearl.salon.utils.CircleImageView;

import java.util.ArrayList;

public class InboxListAdapter extends RecyclerView.Adapter<InboxListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<InboxList> inboxList;

    public InboxListAdapter(Context context, ArrayList<InboxList> inboxList) {
        this.context = context;
        this.inboxList = inboxList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_inbox_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.username.setText(inboxList.get(position).getUsername());
        holder.username.setTypeface(holder.username.getTypeface(), Typeface.BOLD);
        holder.time.setText(inboxList.get(position).getTime());
        holder.message.setText(inboxList.get(position).getMessage());

        Glide.with(context).load(inboxList.get(position).getImage()).into(holder.userImage);

        if(inboxList.get(position).getUnread() > 0){
            holder.unread.setVisibility(View.VISIBLE);
            holder.unread.setText(String.valueOf(inboxList.get(position).getUnread()));
        }else{
            holder.unread.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return inboxList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView userImage;

        private TextView username, time, message, unread;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userImage = itemView.findViewById(R.id.circleImageView2);
            username = itemView.findViewById(R.id.textView89);
            time = itemView.findViewById(R.id.textView90);
            message = itemView.findViewById(R.id.textView91);
            unread = itemView.findViewById(R.id.textView92);
        }
    }
}
