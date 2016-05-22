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
    private String imdbID;
    private String Poster;
    private String Title;
    private String Year;
    private boolean Bookmarked;

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public boolean isBookmarked() {
        return Bookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        Bookmarked = bookmarked;
    }

    @Override
    public String toString() {
        return "MovieShort{" +
                "imdbID='" + imdbID + '\'' +
                ", Poster='" + Poster + '\'' +
                ", Title='" + Title + '\'' +
                ", Year='" + Year + '\'' +
                ", Bookmarked=" + Bookmarked +
                '}';
    }

    public MovieShort() {}

}
