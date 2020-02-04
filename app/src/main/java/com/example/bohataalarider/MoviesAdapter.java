package com.example.bohataalarider;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Movie> moviesList;
Context c;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
public LinearLayout li;
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            li = (LinearLayout) view.findViewById(R.id.li);
            li.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
           Intent intent=new Intent(c,TaskDetails.class);
             intent.putExtra("oid",moviesList.get(getAdapterPosition()).getOid());
             intent.putExtra("tid",moviesList.get(getAdapterPosition()).getTid());
           // intent.putExtra("xb",getAdapterPosition());

                    c.startActivity(intent);
                }
            });
        }
    }


    public MoviesAdapter(List<Movie> moviesList, Context c)
    {
        this.moviesList = moviesList;
    this.c=c;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_new, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());

        if (movie.getTitle().equals("Cancel")) {
            holder.title.setText(movie.getTitle());
            holder.title.setTextColor(Color.RED);
        }else {
            holder.title.setText(movie.getTitle());

        }
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}