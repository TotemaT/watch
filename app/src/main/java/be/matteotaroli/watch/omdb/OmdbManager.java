package be.matteotaroli.watch.omdb;

import java.util.List;

import be.matteotaroli.watch.pojo.MovieFull;
import be.matteotaroli.watch.pojo.MovieShort;

public interface OmdbManager {
    List<MovieShort> search(String search, int page);
    MovieFull searchByTitle(String title);
}
