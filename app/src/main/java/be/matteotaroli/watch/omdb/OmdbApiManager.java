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

package be.matteotaroli.watch.omdb;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.List;

import be.matteotaroli.watch.pojo.MovieFull;
import be.matteotaroli.watch.pojo.MovieShort;

public class OmdbApiManager implements ApiManager {
    private static final String BASE_URL = "http://www.omdbapi.com";
    private static final String SEARCH_QUERY = BASE_URL + "/?s=%s&page=%d";
    private static final String TITLE_QUERY = BASE_URL + "/?t=%s";

    private Context ctx;

    public OmdbApiManager(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public List<MovieShort> search(String search, int page) {
        String request = String.format(SEARCH_QUERY, search, page);
        sendRequest(request);
        return null;
    }

    @Override
    public MovieFull searchByTitle(String title) {
        String request = String.format(TITLE_QUERY, title);
        sendRequest(request);
        return null;
    }

    private String sendRequest(String request) {
        RequestQueue queue = Volley.newRequestQueue(ctx);
        request = request.replaceAll("\\s", "%20");

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, request, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.v("VOLLEY", parseMovieShort(response).toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("VOLLEY", error.toString());
                    }
                });
        queue.add(jsonRequest);
        return null;
    }

    /*
        { "Search" : [{movieShort1}, {movieShort2},...]}
     */
    private List<MovieShort> parse(JSONObject json) {
        return null;
    }

    private MovieShort parseMovieShort(JSONObject json) {
        return new MovieShort(json);
    }

    private MovieFull parseMovieFull(JSONObject json) {
        return null; //new MovieFull(json);
    }
}
