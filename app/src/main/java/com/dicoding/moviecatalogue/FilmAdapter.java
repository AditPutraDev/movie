    package com.dicoding.moviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Film> film;

    public void setFilm(ArrayList<Film> film){
        this.film = film;
    }
    public FilmAdapter(Context context){
        this.context = context;
        film = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return film.size();
    }

    @Override
    public Object getItem(int position) {
        return film.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_film, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Film film = (Film) getItem(position);
        viewHolder.bind(film);
        return view;
    }

    private class ViewHolder {
        private ImageView imagePoster;
        private TextView txtTitle;
        private TextView txtDescription;
        ViewHolder(View view){
            imagePoster = view.findViewById(R.id.image_poster);
            txtTitle = view.findViewById(R.id.text_title);
            txtDescription = view.findViewById(R.id.text_desc);
        }
        void bind(Film film){
            txtTitle.setText(film.getTitle());
            txtDescription.setText(film.getDescription());
            imagePoster.setImageResource(film.getPoster());
        }
    }
}
