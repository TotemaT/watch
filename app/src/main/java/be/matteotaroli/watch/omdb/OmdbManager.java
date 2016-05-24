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

import be.matteotaroli.watch.pojo.MovieFull;
import be.matteotaroli.watch.pojo.Search;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OmdbManager {
    String ENDPOINT = "http://www.omdbapi.com";

    /**
     * This method allows to retrieve all movies on OMDd that contains the search terms.
     *
     * @param search Terms to search
     * @param page   Number of page
     * @return A list containing all the movies for the given page
     */
    @GET("/?type=movie")
    Call<Search> search(@Query("s") String search, @Query("page") int page);

    /**
     * This method allows to retrieve a single movie on OMDd based on its ID.
     *
     * @param imdbId ID of the movie
     * @return The movie whose ID matches the given one
     */
    @GET("/?type=movie")
    Call<MovieFull> searchById(@Query("i") String imdbId);
}
