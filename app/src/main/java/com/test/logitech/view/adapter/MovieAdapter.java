package com.test.logitech.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.test.logitech.R;
import com.test.logitech.listener.OnMovieItemClickListener;
import com.test.logitech.model.entity.Movie;
import com.test.logitech.view.viewholder.MovieViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<Movie> movieList = new ArrayList<>();
    private OnMovieItemClickListener listener;
    private Context context;

    public MovieAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Movie> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    public void setListener(OnMovieItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    private Movie getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_movie_list, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        final Movie movie = getItem(position);
        bindData(holder, movie);
        bindListener(holder, movie);
    }

    private void bindData(MovieViewHolder holder, final Movie movie) {
        if (movie.poster != null && !movie.poster.equalsIgnoreCase("N/A"))
            Glide.with(context).load(movie.poster).placeholder(R.drawable.ic_default).into(holder.imgMovie);
        holder.txtTitle.setText(movie.title != null ? movie.title : context.getString(R.string.not_available));

    }

    private void bindListener(MovieViewHolder holder, final Movie movie) {
        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onMovieClicked(movie);
            }
        });
    }
}
