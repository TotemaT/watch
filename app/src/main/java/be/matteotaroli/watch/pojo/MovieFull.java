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
    private String Rated;
    private String Runtime;
    private int Metascore;
    private String Genre;
    private String Plot;
    private String Released;
    private String Actors;
    private double imdbRating;

    public MovieFull() {
    }

    public String getRated() {
        return Rated;
    }

    public void setRated(String rated) {
        Rated = rated;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public int getMetascore() {
        return Metascore;
    }

    public void setMetascore(int metascore) {
        Metascore = metascore;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public String getReleased() {
        return Released;
    }

    public void setReleased(String released) {
        Released = released;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
    
    @Override
    public String toString() {
        return "MovieFull{" +
                super.toString() +
                "Rated='" + Rated + '\'' +
                ", Runtime='" + Runtime + '\'' +
                ", Metascore=" + Metascore +
                ", Genre='" + Genre + '\'' +
                ", Plot='" + Plot + '\'' +
                ", Released='" + Released + '\'' +
                ", Actors='" + Actors + '\'' +
                ", imdbRating=" + imdbRating +
                '}';
    }
}
