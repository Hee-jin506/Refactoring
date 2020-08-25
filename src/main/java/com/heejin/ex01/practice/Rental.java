package com.heejin.ex01.practice;

public class Rental {
  private int _daysRented;
  private Movie _movie;
  
  public Rental(int daysRented, Movie movie) {
    _daysRented = daysRented;
    _movie = movie;
  }
  
  public int getDaysRented() {
    return _daysRented;
  }
  
  public Movie getMovie() {
    return _movie;
  }
}
