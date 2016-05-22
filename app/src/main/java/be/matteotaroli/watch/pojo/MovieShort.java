package be.matteotaroli.watch.pojo;

public class MovieShort {
    private long imdbId;
    private String poster;
    private String title;
    private String actors;
    private String year;
    private float rating;
    private boolean bookmarked;

    public MovieShort(long imdbId, String poster, String title, String actors, String year, float rating, boolean bookmarked) {
        this.imdbId = imdbId;
        this.poster = poster;
        this.title = title;
        this.actors = actors;
        this.year = year;
        this.rating = rating;
        this.bookmarked = bookmarked;
    }

    public long getImdbId() {
        return imdbId;
    }

    public String getPoster() {
        return poster;
    }

    public String getTitle() {
        return title;
    }

    public String getActors() {
        return actors;
    }

    public String getYear() {
        return year;
    }

    public float getRating() {
        return rating;
    }

    public boolean isBookmarked() {
        return bookmarked;
    }

}
