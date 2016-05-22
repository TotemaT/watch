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

package be.matteotaroli.watch.pojo;

import org.json.JSONException;
import org.json.JSONObject;

import be.matteotaroli.watch.utils.Constants;

public class MovieFull extends MovieShort {
    private String rated;
    private String length;
    private int metascore;
    private String genre;
    private String plot;

    public MovieFull(String imdbId, String poster, String title, String actors, String year, double rating, String rated, String length, int metascore, String genre, String plot) {
        super(imdbId, poster, title, actors, year, rating);
        this.rated = rated;
        this.length = length;
        this.metascore = metascore;
        this.genre = genre;
        this.plot = plot;
    }

    public MovieFull(JSONObject json) {
        super(json);
        try {
            rated = json.getString(Constants.RATED);
            length = json.getString(Constants.RUNTIME);
            metascore = json.getInt(Constants.METASCORE);
            genre = json.getString(Constants.GENRE);
            plot = json.getString(Constants.PLOT);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getRated() {
        return rated;
    }

    public String getLength() {
        return length;
    }

    public int getMetascore() {
        return metascore;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlot() {
        return plot;
    }
}
