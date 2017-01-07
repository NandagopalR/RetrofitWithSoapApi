package com.nanda.retrofitwithsoap.datamodel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nandagopal on 1/7/17.
 */
public class Movies {

  @SerializedName("MovieId") private int movieId;
  @SerializedName("Title") private String title;
  @SerializedName("Year") private String year;
  @SerializedName("Actors") private String actors;
  @SerializedName("Plot") private String plot;
  @SerializedName("Director") private String director;
  @SerializedName("Cover") private String cover;

  public int getMovieId() {
    return movieId;
  }

  public void setMovieId(int movieId) {
    this.movieId = movieId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getActors() {
    return actors;
  }

  public void setActors(String actors) {
    this.actors = actors;
  }

  public String getPlot() {
    return plot;
  }

  public void setPlot(String plot) {
    this.plot = plot;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public String getCover() {
    return cover;
  }

  public void setCover(String cover) {
    this.cover = cover;
  }
}
