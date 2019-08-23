package com.example.mymovieapplication;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TypedArray dataPoster;
    private String[] dataTitle;
    private String[] dataOverview;
    private String[] dataReleaseDate;
    private String[] dataRuntime;
    private String[] dataDirectorName;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movies.get(position));
                startActivity(intent);
            }
        });
    }

    private void addItem(){
        movies = new ArrayList<>();

        for (int i = 0; i < dataTitle.length; i++){
            Movie movie = new Movie();
            movie.setPoster(dataPoster.getResourceId(i, -1));
            movie.setTitle(dataTitle[i]);
            movie.setRelease_date(dataReleaseDate[i]);
            movie.setOverview(dataOverview[i]);
            movie.setRuntime(dataRuntime[i]);
            movie.setDirector_name(dataDirectorName[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare(){
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataReleaseDate = getResources().getStringArray(R.array.data_release_date);
        dataOverview = getResources().getStringArray(R.array.data_overview);
        dataRuntime = getResources().getStringArray(R.array.data_runtime);
        dataDirectorName = getResources().getStringArray(R.array.data_directorName);

    }
}
