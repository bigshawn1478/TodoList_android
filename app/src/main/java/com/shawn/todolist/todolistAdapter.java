package com.shawn.todolist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class todolistAdapter extends RecyclerView.Adapter<todolistAdapter.ViewHolder> {
    ArrayList<String> m_data;

    public todolistAdapter(ArrayList<String> data) {
        m_data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todolist_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(m_data.get(position));
    }

    @Override
    public int getItemCount() {
        return m_data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.todolist_item_title);
        }
    }
}
