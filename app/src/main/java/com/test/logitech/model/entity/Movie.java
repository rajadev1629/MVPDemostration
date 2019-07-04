package com.test.logitech.model.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Movie implements Comparable<Movie>, Parcelable {

    @SerializedName("Title")
    public String title;
    @SerializedName("Year")
    public String year;
    @SerializedName("Rated")
    public String rated;
    @SerializedName("Released")
    public String released;
    @SerializedName("Runtime")
    public String runtime;
    @SerializedName("Genre")
    public String genre;
    @SerializedName("Director")
    public String director;
    @SerializedName("Writer")
    public String writer;
    @SerializedName("Actors")
    public String actors;
    @SerializedName("Plot")
    public String plot;
    @SerializedName("Language")
    public String language;
    @SerializedName("Country")
    public String country;
    @SerializedName("Awards")
    public String awards;
    @SerializedName("Poster ")
    public String poster;
    @SerializedName("Ratings ")
    public String ratings;
    @SerializedName("Metascore ")
    public String metascore;
    @SerializedName("imdbRating ")
    public String imdbRating;
    @SerializedName("imdbVotes ")
    public String imdbVotes;
    @SerializedName("imdbID ")
    public String imdbID;
    @SerializedName("Type ")
    public String type;
    @SerializedName("DVD ")
    public String dVD;
    @SerializedName("BoxOffice ")
    public String boxOffice;
    @SerializedName("Production ")
    public String production;
    @SerializedName("Website ")
    public String website;
    @SerializedName("Response ")
    public String response;

    @Override
    public int compareTo(@NonNull Movie movie) {
        if (this.title != null && movie.title != null)
            return this.title.compareTo(movie.title);
        return 0;
    }

    protected Movie(Parcel in) {
        title = in.readString();
        year = in.readString();
        rated = in.readString();
        released = in.readString();
        runtime = in.readString();
        genre = in.readString();
        director = in.readString();
        writer = in.readString();
        actors = in.readString();
        plot = in.readString();
        language = in.readString();
        country = in.readString();
        awards = in.readString();
        poster = in.readString();
        ratings = in.readString();
        metascore = in.readString();
        imdbRating = in.readString();
        imdbVotes = in.readString();
        imdbID = in.readString();
        type = in.readString();
        dVD = in.readString();
        boxOffice = in.readString();
        production = in.readString();
        website = in.readString();
        response = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(year);
        dest.writeString(rated);
        dest.writeString(released);
        dest.writeString(runtime);
        dest.writeString(genre);
        dest.writeString(director);
        dest.writeString(writer);
        dest.writeString(actors);
        dest.writeString(plot);
        dest.writeString(language);
        dest.writeString(country);
        dest.writeString(awards);
        dest.writeString(poster);
        dest.writeString(ratings);
        dest.writeString(metascore);
        dest.writeString(imdbRating);
        dest.writeString(imdbVotes);
        dest.writeString(imdbID);
        dest.writeString(type);
        dest.writeString(dVD);
        dest.writeString(boxOffice);
        dest.writeString(production);
        dest.writeString(website);
        dest.writeString(response);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}