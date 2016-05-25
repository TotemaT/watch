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

package be.matteotaroli.watch.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieShort implements Parcelable {
    private String imdbID;
    private String Poster;
    private String Title;
    private String Year;
    private boolean Bookmarked;

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getPoster() {
        return Poster;
    }

    public String getBigPoster() {
        return Poster.replace("._V1_SX300", "");
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public boolean isBookmarked() {
        return Bookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        Bookmarked = bookmarked;
    }

    @Override
    public String toString() {
        return "MovieShort{" +
                "imdbID='" + imdbID + '\'' +
                ", Poster='" + Poster + '\'' +
                ", Title='" + Title + '\'' +
                ", Year='" + Year + '\'' +
                ", Bookmarked=" + Bookmarked +
                '}';
    }

    public MovieShort() {
    }


    protected MovieShort(Parcel in) {
        imdbID = in.readString();
        Poster = in.readString();
        Title = in.readString();
        Year = in.readString();
        Bookmarked = in.readByte() != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imdbID);
        dest.writeString(Poster);
        dest.writeString(Title);
        dest.writeString(Year);
        dest.writeByte((byte) (Bookmarked ? 0x01 : 0x00));
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<MovieShort> CREATOR = new Parcelable.Creator<MovieShort>() {
        @Override
        public MovieShort createFromParcel(Parcel in) {
            return new MovieShort(in);
        }

        @Override
        public MovieShort[] newArray(int size) {
            return new MovieShort[size];
        }
    };
}