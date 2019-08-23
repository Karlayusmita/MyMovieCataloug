package com.example.mymovieapplication;

import android.arch.core.executor.TaskExecutor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailMovieActivity extends AppCompatActivity {
    ImageView poster;
    TextView title;
    TextView description;
    TextView release_date;
    TextView director_name;
    TextView runtime;
    public static final String EXTRA_MOVIE = "MOVIE_DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        poster = findViewById(R.id.detail_poster);
        title = findViewById(R.id.detail_title);
        description = findViewById(R.id.detail_overview);
        release_date = findViewById(R.id.detail_releaseDate);
        runtime = findViewById(R.id.detail_runtime);
        director_name = findViewById(R.id.detail_director_name);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        Glide.with(this)
                .load(Integer.valueOf(movie.getPoster()))
                .into(poster);
        title.setText(movie.getTitle());
        description.setText(movie.getOverview());
        release_date.setText(movie.getRelease_date());
        runtime.setText(movie.getRuntime());
        director_name.setText(movie.getDirector_name());



    }
}
