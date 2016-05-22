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
