package com.test.logitech.view.viewinterface;

import com.test.logitech.model.entity.Movie;

import java.util.List;

public interface MovieDetailView {

    void setData(Movie movie);

    Movie captureData();

    void setNameList(List<String> strings);
}
