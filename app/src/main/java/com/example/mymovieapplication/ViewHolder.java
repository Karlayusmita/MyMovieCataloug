package com.example.mymovieapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class ViewHolder {
    private ImageView imagePoster;
    private TextView textTitle;
    private TextView textReleaseDate;
    private TextView textDescription;

    ViewHolder(View view){
        imagePoster = view.findViewById(R.id.image_poster);
        textTitle = view.findViewById(R.id.text_title);
        textReleaseDate = view.findViewById(R.id.text_release_date);
        textDescription = view.findViewById(R.id.text_overview);
    }

    void bind(Movie movie) {
        imagePoster.setImageResource(movie.getPoster());
        textTitle.setText(movie.getTitle());
        textReleaseDate.setText(movie.getRelease_date());
        textDescription.setText(movie.getOverview());
    }
}
