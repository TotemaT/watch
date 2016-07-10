package be.matteotaroli.watch.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieFull extends MovieShort implements Parcelable {
    private String Rated;
    private String Runtime;
    private String Metascore;
    private String Genre;
    private String Plot;
    private String Released;
    private String Actors;
    private String imdbRating;

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

    public String getMetascore() {
        return Metascore;
    }

    public void setMetascore(String metascore) {
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

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
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

    protected MovieFull(Parcel in) {
        super(in);
        Rated = in.readString();
        Runtime = in.readString();
        Metascore = in.readString();
        Genre = in.readString();
        Plot = in.readString();
        Released = in.readString();
        Actors = in.readString();
        imdbRating = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(Rated);
        dest.writeString(Runtime);
        dest.writeString(Metascore);
        dest.writeString(Genre);
        dest.writeString(Plot);
        dest.writeString(Released);
        dest.writeString(Actors);
        dest.writeString(imdbRating);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<MovieFull> CREATOR = new Parcelable.Creator<MovieFull>() {
        @Override
        public MovieFull createFromParcel(Parcel in) {
            return new MovieFull(in);
        }

        @Override
        public MovieFull[] newArray(int size) {
            return new MovieFull[size];
        }
    };
}