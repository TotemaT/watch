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

public class MovieFull extends MovieShort {
    private String rated;
    private String length;
    private int metascore;
    private String genre;
    private String plot;

    public MovieFull(long imdbId, String poster, String title, String actors, String year, float rating, boolean bookmarked, String rated, String length, int metascore, String genre, String plot) {
        super(imdbId, poster, title, actors, year, rating, bookmarked);
        this.rated = rated;
        this.length = length;
        this.metascore = metascore;
        this.genre = genre;
        this.plot = plot;
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
