package com.nanda.retrofitwithsoap.model;

/**
 * Created by nandagopal on 1/8/17.
 */
public class MoviesItem {

  private int movieId;
  private String title;
  private String year;
  private String actors;
  private String plot;
  private String director;
  private String cover;

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
