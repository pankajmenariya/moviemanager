package com.example.moviemanager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class movieDetailActivity extends AppCompatActivity {

    Movie movie;
    TextView tvOverviewDetail;
    ImageView ivMovieBackDroppath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Movie saved as favorite", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvOverviewDetail = (TextView) findViewById(R.id.tvOverviewDetail);
        ivMovieBackDroppath = (ImageView) findViewById(R.id.ivMovieBackdrop);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            movie = (Movie) extras.getSerializable("MOVIE");
            this.setTitle(movie.getTitle());
            tvOverviewDetail.setText(movie.getOverview());
            Picasso.with(this)
                    .load(movie.getBackdropPath())
                    .into(ivMovieBackDroppath);
        }
    }
}
