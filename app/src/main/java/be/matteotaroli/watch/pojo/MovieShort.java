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

public class MovieShort {
    private String imdbId;
    private String poster;
    private String title;
    private String actors;
    private String releaseDate;
    private double rating;
    private boolean bookmarked;

    public MovieShort(String imdbId, String poster, String title, String actors, String releaseDate, double rating) {
        this.imdbId = imdbId;
        this.poster = poster;
        this.title = title;
        this.actors = actors;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.bookmarked = false;
    }

    public MovieShort(JSONObject json) {
        try {
            title = json.getString(Constants.TITLE);
            imdbId = json.getString(Constants.IMDB_ID);
            poster = json.getString(Constants.POSTER);
            actors = json.getString(Constants.ACTORS);
            releaseDate = json.getString(Constants.RELEASED);
            rating = json.getDouble(Constants.IMDB_RATING);
            bookmarked = false;
        } catch (JSONException e) {

            e.printStackTrace();
        }
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getPoster() {
        return poster;
    }

    public String getTitle() {
        return title;
    }

    public String getActors() {
        return actors;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public boolean isBookmarked() {
        return bookmarked;
    }

    @Override
    public String toString() {
        return "MovieShort{" +
                "imdbId='" + imdbId + '\'' +
                ", poster='" + poster + '\'' +
                ", title='" + title + '\'' +
                ", actors='" + actors + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", rating=" + rating +
                ", bookmarked=" + bookmarked +
                '}';
    }
}
