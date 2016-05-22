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

package be.matteotaroli.watch.sqlite;

import java.util.List;

import be.matteotaroli.watch.pojo.MovieFull;
import be.matteotaroli.watch.pojo.MovieShort;

public interface SqliteManager {
    /**
     * This method allows to insert a MovieShort object.
     * @param movie Movie to insert
     */
    void insert(MovieShort movie);
    /**
     * This method allows to insert a MovieFull object.
     * @param movie Movie to insert
     */
    void insert(MovieFull movie);
    /**
     * This method allows to insert all movies given.
     * @param movies List of movies to insert
     */
    void insertAll(List<MovieShort> movies);

    /**
     * This method allows to select all MovieShort from the database.
     * @param bookmarked Whether to select only bookmarked movies
     * @param page Number of page
     * @return All the movies
     */
    List<MovieShort> selectAll(boolean bookmarked, int page);

    /**
     * This method allows to select a single MovieFull.
     * @param id ID of the movie to select.
     * @return The movie whose ID matches the given one.
     */
    MovieFull selectMovie(long id);
}
