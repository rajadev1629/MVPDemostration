package com.test.logitech.view.viewholder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.logitech.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.view_parent)
    public CardView parentView;
    @BindView(R.id.img_movie)
    public ImageView imgMovie;
    @BindView(R.id.txt_title)
    public TextView txtTitle;

    public MovieViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}