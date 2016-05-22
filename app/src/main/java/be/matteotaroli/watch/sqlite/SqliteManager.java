package be.matteotaroli.watch.sqlite;

import java.util.List;

import be.matteotaroli.watch.pojo.MovieFull;
import be.matteotaroli.watch.pojo.MovieShort;

public interface SqliteManager {
    void insert(MovieShort movie);
    void insert(MovieFull movie);
    void insertAll(List<MovieShort> movies);
    List<MovieShort> selectAll(boolean bookmarked, int page);
    MovieFull selectMovie(long id);
}
