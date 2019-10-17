package com.dicoding.moviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] titleMovie;
    private String[] dataDescription;
    private TypedArray dataPoster;
    private FilmAdapter adapter;
    private ArrayList<Film> films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new FilmAdapter(this);
        ListView listView = findViewById(R.id.lv_listview);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this, films.get(position).getTitle(),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_FILM, films.get(position));


                startActivity(intent);
            }
        });
    }

    private void prepare() {
        titleMovie = getResources().getStringArray(R.array.title_moviie);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
    }

    private void addItem() {
        films = new ArrayList<>();

        for (int i = 0; i < titleMovie.length; i++) {
                Film film = new Film();
                film.setPoster(dataPoster.getResourceId(i, -1));
                film.setTitle(titleMovie[i]);
                film.setDescription(dataDescription[i]);
                films.add(film);
        }
        adapter.setFilm(films);
    }
}
