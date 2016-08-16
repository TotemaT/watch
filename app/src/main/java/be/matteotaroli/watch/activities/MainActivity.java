package be.matteotaroli.watch.activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import be.matteotaroli.watch.R;
import be.matteotaroli.watch.adapters.MovieListAdapter;
import be.matteotaroli.watch.listeners.RecyclerItemClickListener;
import be.matteotaroli.watch.pojo.MovieFull;
import be.matteotaroli.watch.pojo.MovieShort;
import be.matteotaroli.watch.pojo.Search;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements RecyclerItemClickListener {

    @BindView(R.id.search_searchView)
    SearchView searchView;
    @BindView(R.id.movies_recycler_view)
    RecyclerView movieRecyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private List<MovieFull> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        movieRecyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this, 2);
        movieRecyclerView.setLayoutManager(layoutManager);

        movies = new ArrayList<>();
        adapter = new MovieListAdapter(movies, this);
        movieRecyclerView.setAdapter(adapter);

        setSearchAction();
    }

    private void setSearchAction() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //listHeaderTextView.setText("Results");
                searchView.clearFocus();
                addMovies(query.trim());
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @OnClick(R.id.search_cardView)
    public void onClickCardView() {
        searchView.setIconified(false);
        searchView.requestFocus();
    }

    public void addMovies(String search) {
        for (int i = 0; i < 10; i++) {
            Call<Search> call = getOmdbManager().search(search, i);
            call.enqueue(new Callback<Search>() {
                @Override
                public void onResponse(Call<Search> call, Response<Search> response) {
                    if (response.body() != null && response.body().getSearch() != null) {
                        for (MovieShort movie : response.body().getSearch()) {
                            addMovieFull(movie.getImdbID());
                        }
                    }
                }

                @Override
                public void onFailure(Call<Search> call, Throwable t) {
                    Log.e("OnFailure", t.toString());
                }
            });
        }
    }

    public void addMovieFull(String id) {
        Call<MovieFull> call2 = getOmdbManager().searchById(id);
        call2.enqueue(new Callback<MovieFull>() {
            @Override
            public void onResponse(Call<MovieFull> call, Response<MovieFull> response) {
                movies.add(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<MovieFull> call, Throwable t) {
                Log.e("OnFailure", t.toString());
            }
        });
    }

    @Override
    public void onClick(View v, int position) {
        View poster = v.findViewById(R.id.poster_imageView);
        View title = v.findViewById(R.id.title_textView);
        View titleHolder = v.findViewById(R.id.linearlayout);

        Intent i = new Intent(MainActivity.this, DetailsActivity.class);
        i.putExtra("EXTRA_MOVIE", movies.get(position));
        ActivityOptions opt = ActivityOptions.makeSceneTransitionAnimation(this,
                Pair.create(poster, poster.getTransitionName()),
                Pair.create(title, title.getTransitionName()),
                Pair.create(titleHolder, titleHolder.getTransitionName()));
        startActivity(i, opt.toBundle());
    }
}
