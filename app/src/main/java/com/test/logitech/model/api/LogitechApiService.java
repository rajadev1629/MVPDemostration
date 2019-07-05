package com.test.logitech.model.api;

import com.test.logitech.model.entity.MovieData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LogitechApiService {

    /*
    * Add as many as you can API's for fetching data. collectively here
    * and get response on required screen/Class.
    * */

    @GET("bins/18buhu")
    Call<MovieData> getMovieList();
}
