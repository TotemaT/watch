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
