package com.test.logitech.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.test.logitech.R;
import com.test.logitech.listener.OnMovieItemClickListener;
import com.test.logitech.model.entity.Movie;
import com.test.logitech.presenter.HomeScreenPresenterImpl;
import com.test.logitech.presenter.presenterinterface.HomeScreenPresenter;
import com.test.logitech.utils.EqualSpacingItemDecoration;
import com.test.logitech.view.adapter.MovieAdapter;
import com.test.logitech.view.viewinterface.HomeScreenView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements HomeScreenView {

    @BindView(R.id.list_view)
    RecyclerView movieListView;

    private HomeScreenPresenter presenter;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupLayout();

        presenter = new HomeScreenPresenterImpl();
        presenter.attachView(this);
        presenter.getMovieList();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void setData(List<Movie> movieList) {
        adapter.setData(movieList);
    }

    private void setupLayout() {
        adapter = new MovieAdapter(this);
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        movieListView.setLayoutManager(manager);
        movieListView.setAdapter(adapter);
        movieListView.addItemDecoration(new EqualSpacingItemDecoration(20));

        adapter.setListener(new OnMovieItemClickListener() {
            @Override
            public void onMovieClicked(Movie movie) {
                Intent intent = new Intent(MainActivity.this, MovieDetailActivity.class);
                intent.putExtra(getString(R.string.movie_data_key), movie);
                startActivity(intent);
            }
        });


    }
}
