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
