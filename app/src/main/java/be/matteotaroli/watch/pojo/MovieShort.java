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

public class MovieShort {
    private long imdbId;
    private String poster;
    private String title;
    private String actors;
    private String year;
    private float rating;
    private boolean bookmarked;

    public MovieShort(long imdbId, String poster, String title, String actors, String year, float rating, boolean bookmarked) {
        this.imdbId = imdbId;
        this.poster = poster;
        this.title = title;
        this.actors = actors;
        this.year = year;
        this.rating = rating;
        this.bookmarked = bookmarked;
    }

    public long getImdbId() {
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

    public String getYear() {
        return year;
    }

    public float getRating() {
        return rating;
    }

    public boolean isBookmarked() {
        return bookmarked;
    }

}
