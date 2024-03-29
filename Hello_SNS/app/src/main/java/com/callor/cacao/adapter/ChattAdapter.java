package com.callor.cacao.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.cacao.R;
import com.callor.cacao.model.Chatt;

import java.util.List;

public class ChattAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Chatt> chattList;

    public void addchattList(Chatt chatt){
        chattList.add(chatt);
        notifyItemChanged(chattList.size());
    }

    public ChattAdapter(List<Chatt> chattList) {
        this.chattList = chattList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item_layout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chatt_item,parent,false);
        ChattViewHolder viewHolder = new ChattViewHolder(item_layout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Chatt chatt = chattList.get(position);
        ChattViewHolder chattViewHolder = (ChattViewHolder) holder;

        chattViewHolder.item_name.setText(chatt.getName());
        chattViewHolder.item_msg.setText(chatt.getMsg());
    }

    @Override
    public int getItemCount() {
        return chattList == null ? 0 : chattList.size();
    }

    private static class ChattViewHolder extends RecyclerView.ViewHolder {

        public TextView item_name;
        public TextView item_msg;
        public ChattViewHolder(View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            item_msg = itemView.findViewById(R.id.item_msg);
        }
    }
}
