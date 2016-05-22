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

import android.os.Bundle;
import android.util.Log;

import be.matteotaroli.watch.R;
import be.matteotaroli.watch.pojo.MovieFull;
import be.matteotaroli.watch.pojo.MovieShort;
import be.matteotaroli.watch.pojo.Search;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* select last viewed and add to list */

        Call<Search> call = getOmdbManager().search("pawn", 1);
        call.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                for (MovieShort movie : response.body().getSearch()) {
                    Log.d("OnResponse", movie.toString());
                }
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {
                Log.e("OnFailure", t.toString());
            }
        });

        Call<MovieFull> call2 = getOmdbManager().searchByTitle("the illusionist");
        call2.enqueue(new Callback<MovieFull>() {
            @Override
            public void onResponse(Call<MovieFull> call, Response<MovieFull> response) {
                Log.d("OnResponse", response.body().toString());
            }

            @Override
            public void onFailure(Call<MovieFull> call, Throwable t) {
                Log.e("OnFailure", t.toString());
            }
        });
    }
}
