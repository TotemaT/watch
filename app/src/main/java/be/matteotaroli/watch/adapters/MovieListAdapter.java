package be.matteotaroli.watch.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import be.matteotaroli.watch.R;
import be.matteotaroli.watch.listeners.RecyclerItemClickListener;
import be.matteotaroli.watch.pojo.MovieFull;
import be.matteotaroli.watch.utils.NumberUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {

    private List<MovieFull> movies;
    private Context ctx;
    private RecyclerItemClickListener recyclerItemClickListener;

    public MovieListAdapter(List<MovieFull> movies, RecyclerItemClickListener recyclerItemClickListener) {
        this.movies = movies;
        this.recyclerItemClickListener = recyclerItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        ctx = parent.getContext();
        ViewHolder vh = new ViewHolder(v, recyclerItemClickListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MovieFull movie = movies.get(position);
        Picasso.with(ctx).load(movie.getBigPoster()).placeholder(R.drawable.ic_movie).fit().centerCrop().into(holder.posterImageView);
        holder.titleTextView.setText(movie.getTitle());
        holder.year_textView.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.poster_imageView)
        ImageView posterImageView;
        @BindView(R.id.title_textView)
        TextView titleTextView;
        @BindView(R.id.year_textView)
        TextView year_textView;

        RecyclerItemClickListener onClickListener;

        public ViewHolder(View itemView, RecyclerItemClickListener onClickListener) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.onClickListener = onClickListener;
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(view, getAdapterPosition());
        }
    }
}
