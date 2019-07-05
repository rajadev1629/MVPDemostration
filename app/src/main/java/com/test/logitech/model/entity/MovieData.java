package com.test.logitech.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieData {

    @SerializedName("movies")
    public List<Movie> movies = null;

}