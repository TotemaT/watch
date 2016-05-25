/*
* Watch allows to search and save movies to watch later or just to keep it handy.
*
* Copyright (C) 2016 Matteo Taroli
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

package be.matteotaroli.watch.activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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
    @BindView(R.id.list_header_textView)
    TextView listHeaderTextView;
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
        layoutManager = new LinearLayoutManager(this);
        movieRecyclerView.setLayoutManager(layoutManager);

        movies = new ArrayList<>();
        adapter = new MovieListAdapter(movies, this);
        movieRecyclerView.setAdapter(adapter);
        listHeaderTextView.setText("Recently Viewed");

        setSearchAction();
        /* Load last viewed */
    }

    private void setSearchAction() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                listHeaderTextView.setText("Results");
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
        View iV = v.findViewById(R.id.poster_imageView);
        ActivityOptions opt = ActivityOptions.makeSceneTransitionAnimation(this, iV, getString(R.string.activity_image_trans));
        Intent i = new Intent(MainActivity.this, DetailsActivity.class);
        i.putExtra("EXTRA_MOVIE", movies.get(position));
        startActivity(i, opt.toBundle());
    }
}
