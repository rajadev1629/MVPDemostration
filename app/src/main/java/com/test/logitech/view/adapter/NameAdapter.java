package com.test.logitech.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.logitech.R;
import com.test.logitech.view.viewholder.MovieViewHolder;

import java.util.ArrayList;
import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<String> nameList = new ArrayList<>();

    public void setData(List<String> nameList) {
        this.nameList = nameList;
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    private String getItem(int position) {
        return nameList.get(position);
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_name_list, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        final String name = getItem(position);
        holder.txtTitle.setText(name);
    }
}
