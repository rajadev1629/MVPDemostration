package com.test.logitech.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.test.logitech.R;
import com.test.logitech.model.entity.Movie;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailActivity extends AppCompatActivity {

    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.txt_rate_and_date)
    TextView txtRateAndDate;
    @BindView(R.id.txt_language)
    TextView txtLanguage;
    @BindView(R.id.txt_time_and_genre)
    TextView txtTimeAndGenre;
    @BindView(R.id.txt_plot)
    TextView txtPlot;
    @BindView(R.id.txt_writer)
    TextView txtWriter;
    @BindView(R.id.img_poster)
    ImageView imgPoster;

    private Movie movie;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        getData();
        setData();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getData() {
        if (getIntent() != null)
            movie = getIntent().getParcelableExtra(getString(R.string.movie_data_key));
    }

    private void setData() {
        if (movie == null)
            return;

        txtTitle.setText(movie.title != null ? movie.title : getString(R.string.not_available));
        txtPlot.setText(movie.plot != null ? movie.plot : getString(R.string.not_available));
        txtWriter.setText(movie.writer != null ? movie.writer : getString(R.string.not_available));
        txtLanguage.setText(movie.language != null ? movie.language : getString(R.string.not_available));

        String rateAndDate = (movie.rated != null ? movie.rated : getString(R.string.not_available)) + " | " +
                (movie.released != null ? movie.released : getString(R.string.not_available));
        txtRateAndDate.setText(rateAndDate);

        String timeAndGenre = (movie.runtime != null ? movie.runtime : getString(R.string.not_available)) + " | " +
                (movie.genre != null ? movie.genre : getString(R.string.not_available));
        txtTimeAndGenre.setText(timeAndGenre);

        if (movie.poster != null && !movie.poster.equalsIgnoreCase("N/A"))
            Glide.with(this).load(movie.poster).placeholder(R.drawable.ic_default).into(imgPoster);
    }
}
