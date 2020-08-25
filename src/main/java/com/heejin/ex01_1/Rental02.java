package com.heejin.ex01_1;

public class Rental02 {
  private Movie _movie;
  private int _daysRented;
  
  public Rental02(Movie movie, int daysRented) {
    _movie = movie;
    _daysRented = daysRented;
  }
  
  public int getDaysRented() {
    return _daysRented;
  }
  
  public Movie getMovie() {
    return _movie;
  }

}
