package com.dicoding.moviecatalogue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_FILM = "extra_film";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Film film = getIntent().getParcelableExtra(EXTRA_FILM);

        if(film != null){
            TextView textTitle = findViewById(R.id.tv_title);
            textTitle.setText(film.getTitle());
            TextView textDesc = findViewById(R.id.tv_description);
            textDesc.setText(film.getDescription());
            ImageView imageView = findViewById(R.id.image_poster);
            imageView.setImageResource(film.getPoster());
        }
    }
}
