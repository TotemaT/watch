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

import java.util.List;

import be.matteotaroli.watch.pojo.MovieFull;
import be.matteotaroli.watch.pojo.MovieShort;

public interface ApiManager {
    /**
     * This method allows to retrieve all movies on OMDd that contains the search terms
     * @param search Terms to search
     * @param page Number of page
     * @return A list containing all the movies for the given page
     */
    List<MovieShort> search(String search, int page);

    /**
     * This method allows to retrieve a single movie on OMDd with that title
     * @param title Title of the movie
     * @return The movie with that title
     */
    MovieFull searchByTitle(String title);
}
