package com.nanda.retrofitwithsoap.datamodel.mapper;

import com.nanda.retrofitwithsoap.app.AppConstants;
import com.nanda.retrofitwithsoap.datamodel.Movies;
import com.nanda.retrofitwithsoap.model.MoviesItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandagopal on 1/8/17.
 */
public class MovieMapper {

  public static MoviesItem convertDataModelToItem(Movies movies) {

    MoviesItem item = new MoviesItem();
    item.setMovieId(movies.getMovieId());
    item.setTitle(movies.getTitle());
    item.setYear(movies.getYear());
    item.setActors(movies.getActors());
    item.setCover(AppConstants.GET_IMAGE_PATH + movies.getCover());
    item.setDirector(movies.getDirector());
    item.setPlot(movies.getPlot());

    return item;
  }

  public static List<MoviesItem> convertDataModelToItem(List<Movies> moviesList) {

    if (moviesList == null) {
      return null;
    }

    List<MoviesItem> moviesItemList = new ArrayList<>(moviesList.size());

    for (int i = 0, moviesListSize = moviesList.size(); i < moviesListSize; i++) {
      moviesItemList.add(convertDataModelToItem(moviesList.get(i)));
    }

    return moviesItemList;
  }
}
