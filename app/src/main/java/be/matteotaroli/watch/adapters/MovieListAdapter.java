package be.matteotaroli.watch.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import be.matteotaroli.watch.R;
import be.matteotaroli.watch.pojo.MovieFull;
import be.matteotaroli.watch.utils.NumberUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {

    private List<MovieFull> movies;
    private Context ctx;

    public MovieListAdapter(Context ctx, List<MovieFull> movies) {
        this.ctx = ctx;
        this.movies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MovieFull movie = movies.get(position);
        Picasso.with(ctx).load(movie.getPoster()).placeholder(R.drawable.ic_movie).into(holder.posterImageView);
        holder.titleTextView.setText(movie.getTitle());
        holder.year_textView.setText(movie.getYear());
        if (!movie.getImdbRating().equals("N/A")) {
            holder.ratingBar.setRating(NumberUtil.roundToNearestHalf(Float.parseFloat(movie.getImdbRating()) / 2));
        }
        holder.actorsTextView.setText(movie.getActors());

        if (position == getItemCount()) holder.divider.setVisibility(View.INVISIBLE);
        else holder.divider.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.poster_imageView)
        CircleImageView posterImageView;
        //ImageView posterImageView;
        @BindView(R.id.title_textView)
        TextView titleTextView;
        @BindView(R.id.actors_textView)
        TextView actorsTextView;
        @BindView(R.id.ratingBar)
        RatingBar ratingBar;
        @BindView(R.id.year_textView)
        TextView year_textView;
        @BindView(R.id.divider)
        View divider;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
