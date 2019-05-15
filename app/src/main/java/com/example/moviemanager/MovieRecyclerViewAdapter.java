package com.example.moviemanager;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder> {
    List<Movie> movies;
    Context context;

    public MovieRecyclerViewAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    public Context getContext() {
        return context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.menu_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = movies.get(position);

        holder.tvtitle.setText(movie.getTitle());
        holder.tvOverview.setText(movie.getOverview());

        Picasso.with(context)
                .load(movie.getPosterPath())
                .into(holder.ivmovie);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvtitle = (TextView) itemView.findViewById(R.id.tvtitle);
        TextView tvOverview = (TextView) itemView.findViewById(R.id.tvoverview);
        ImageView ivmovie = (ImageView) itemView.findViewById(R.id.ivmovie);
        CardView cvmovie = (CardView) itemView.findViewById(R.id.cvmovie);
//        @BindView(R.id.tvtitle) TextView tvtitle;
//        @BindView(R.id.tvoverview) TextView tvOverview;
//        @BindView(R.id.ivmovie) ImageView ivmovie;
//        @BindView(R.id.cvmovie) CardView cvmovie;

        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            //  ButterKnife.bind(this,view);
        }

        @Override
        public void onClick(View v) {
            Movie movie = movies.get(getAdapterPosition());

            Intent intent = new Intent(getContext(), movieDetailActivity.class);
            intent.putExtra("MOVIE", movie);
            getContext().startActivity(intent);
        }
    }
}
